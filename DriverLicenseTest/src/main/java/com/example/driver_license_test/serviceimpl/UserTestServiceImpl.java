package com.example.driver_license_test.serviceimpl;

import com.example.driver_license_test.config.contant.Errors;
import com.example.driver_license_test.config.utils.DateRangeUtils;
import com.example.driver_license_test.config.utils.WebInfo;
import com.example.driver_license_test.dto.TestsInfoDTO;
import com.example.driver_license_test.dto.UserTestDTO;
import com.example.driver_license_test.entity.TestsInfo;
import com.example.driver_license_test.entity.User;
import com.example.driver_license_test.entity.UserTest;
import com.example.driver_license_test.exception.BadRequestException;
import com.example.driver_license_test.exception.SysError;
import com.example.driver_license_test.repository.UserRepository;
import com.example.driver_license_test.repository.UserTestRepository;
import com.example.driver_license_test.service.TestsInfoService;
import com.example.driver_license_test.service.UserTestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UserTestServiceImpl implements UserTestService {
    private final UserTestRepository userTestRepository;
    private final UserDetailsServiceImpl userDetailsService;
    private final UserRepository userRepository;
    private final TestsInfoService testsInfoService;

    @Override
    public int getNumberRegister(Integer testInfoId) {
        int count = 0;
        List<UserTest> userTests = userTestRepository.findByTestInfoId(testInfoId);
        for (int i = 0; i < userTests.size(); i++) {
            count += 1;
        }
        return count;
    }

    @Override
    public boolean save(UserTestDTO userTestDTO) {
        User userWeb = userDetailsService.getUserByEmail(WebInfo.getUsername());
        User user = userRepository.findById(userWeb.getId())
                .orElseThrow(() -> new BadRequestException(new SysError(Errors.ERROR_USER_NOT_FOUND)));
        TestsInfoDTO testsInfoDTO = testsInfoService.findById(userTestDTO.getTestInfoId());
        TestsInfo testsInfo = TestsInfo.builder()
                .id(testsInfoDTO.getId())
                .dateRealTest(DateRangeUtils.convertDateTime(testsInfoDTO.getDateRealTest()))
                .dateMockTest(DateRangeUtils.convertDateTime(testsInfoDTO.getDateMockTest()))
                .numberSubscription(testsInfoDTO.getNumberSubscription())
                .build();
        UserTest userTest = UserTest.builder()
                .user(user)
                .testsInfo(testsInfo)
                .timeSubscriptions(LocalDateTime.now())
                .build();
        userTestRepository.save(userTest);
        return true;
    }
}
