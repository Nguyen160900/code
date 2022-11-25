package com.example.driver_license_test.serviceimpl;

import com.example.driver_license_test.config.contant.Errors;
import com.example.driver_license_test.config.utils.DateRangeUtils;
import com.example.driver_license_test.dto.FeeDTO;
import com.example.driver_license_test.dto.LevelDTO;
import com.example.driver_license_test.dto.TestsInfoDTO;
import com.example.driver_license_test.entity.TestsInfo;
import com.example.driver_license_test.exception.BadRequestException;
import com.example.driver_license_test.exception.SysError;
import com.example.driver_license_test.repository.TestsInfoRepository;
import com.example.driver_license_test.repository.UserTestRepository;
import com.example.driver_license_test.service.FeeService;
import com.example.driver_license_test.service.TestsInfoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TestsInfoServiceImpl implements TestsInfoService {
    private final TestsInfoRepository testsInfoRepository;
    private final UserTestRepository userTestRepository;
    private final FeeService feeService;

    @Override
    public Page<TestsInfoDTO> findAll(Pageable pageable) {
        Page<TestsInfo> testsInfos = testsInfoRepository.findAll(pageable);

        return testsInfos.map(item -> {
            FeeDTO feeDTO = feeService.findByLevelId(item.getLevel().getId());
            return TestsInfoDTO.builder()
                    .id(item.getId())
                    .dateOpen(DateRangeUtils.convertDateTimeToDate(item.getDateOpen()))
                    .dateClose(DateRangeUtils.convertDateTimeToDate(item.getDateClose()))
                    .numberSubscription(item.getNumberSubscription())
                    .levelDTO(LevelDTO.builder()
                            .name(item.getLevel().getName())
                            .descriptions(item.getLevel().getDescriptions())
                            .build())
                    .categoryName(item.getLevel().getCategory().getName())
                    .feeDTO(feeDTO)
                    .numberRegister((int) userTestRepository.findByTestInfoId(item.getId()).stream().count())
                    .build();
        });
    }

    @Override
    public TestsInfoDTO findById(Integer testInfoId) {
        TestsInfo testsInfo = testsInfoRepository.findById(testInfoId)
                .orElseThrow(() -> new BadRequestException(new SysError(Errors.ERROR_TEST_INFO_NOT_FOUND)));
        FeeDTO feeDTO = feeService.findByLevelId(testsInfo.getLevel().getId());
        return TestsInfoDTO.builder()
                .id(testsInfo.getId())
                .dateRealTest(DateRangeUtils.convertDateTimeToDate(testsInfo.getDateRealTest()))
                .dateMockTest(DateRangeUtils.convertDateTimeToDate(testsInfo.getDateMockTest()))
                .dateOpen(DateRangeUtils.convertDateTimeToDate(testsInfo.getDateOpen()))
                .dateClose(DateRangeUtils.convertDateTimeToDate(testsInfo.getDateClose()))
                .numberSubscription(testsInfo.getNumberSubscription())
                .levelDTO(LevelDTO.builder()
                        .levelId(testsInfo.getLevel().getId())
                        .name(testsInfo.getLevel().getName())
                        .descriptions(testsInfo.getLevel().getDescriptions())
                        .build())
                .categoryName(testsInfo.getLevel().getCategory().getName())
                .feeDTO(feeDTO)
                .numberRegister((int) userTestRepository.findByTestInfoId((testsInfo.getId())).stream().count())
                .build();
    }
}
