package com.example.driver_license_test.serviceimpl;

import com.example.driver_license_test.config.contant.Errors;
import com.example.driver_license_test.config.utils.WebInfo;
import com.example.driver_license_test.dto.HistoryTestDTO;
import com.example.driver_license_test.entity.HistoryTest;
import com.example.driver_license_test.entity.Level;
import com.example.driver_license_test.entity.User;
import com.example.driver_license_test.exception.BadRequestException;
import com.example.driver_license_test.exception.SysError;
import com.example.driver_license_test.repository.HistoryTestRepository;
import com.example.driver_license_test.repository.LevelRepository;
import com.example.driver_license_test.repository.UserRepository;
import com.example.driver_license_test.service.HistoryTestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class HistoryTestServiceImpl implements HistoryTestService {
    private final HistoryTestRepository historyTestRepository;
    private final UserRepository userRepository;
    private final LevelRepository levelRepository;
    private final UserDetailsServiceImpl userDetailsService;

    @Override
    public HistoryTest saveHistoryTest(Integer levelId) {
        LocalDateTime timeSave = LocalDateTime.now();
        User userWeb = userDetailsService.getUserByEmail(WebInfo.getUsername());
        User user = userRepository.findById(userWeb.getId())
                .orElseThrow(() -> new BadRequestException(new SysError(Errors.ERROR_USER_NOT_FOUND)));
        Level level = levelRepository.findById(levelId)
                .orElseThrow(() -> new BadRequestException(new SysError(Errors.ERROR_LEVEL_NOT_FOUND)));
        HistoryTest save = HistoryTest.builder()
                .user(user)
                .level(level)
                .timeSave(timeSave)
                .build();
        return historyTestRepository.save(save);
    }

    @Override
    public HistoryTestDTO getById(Integer histtoryId) {
        HistoryTest historyTest = findById(histtoryId);
        return HistoryTestDTO.builder()
                .id(historyTest.getId())
                .userId(historyTest.getUser().getId())
                .levelId(historyTest.getLevel().getId())
                .timeSave(historyTest.getTimeSave())
                .status(historyTest.getStatus())
                .point(historyTest.getPoint())
                .build();
    }

    @Override
    public List<HistoryTestDTO> getHistoryTestByUserId() {
        User user = userDetailsService.getUserByEmail(WebInfo.getUsername());
        List<HistoryTest> historyTests = historyTestRepository.findByUserId(user.getId());
        List<HistoryTestDTO> result = new ArrayList<>();
        for (HistoryTest historyTest : historyTests) {
            HistoryTestDTO historyTestDTO = HistoryTestDTO.builder()
                    .id(historyTest.getId())
                    .userId(historyTest.getUser().getId())
                    .levelId(historyTest.getLevel().getId())
                    .levelName(historyTest.getLevel().getName())
                    .levelDescriptions(historyTest.getLevel().getDescriptions())
                    .timeSave(historyTest.getTimeSave())
                    .status(historyTest.getStatus())
                    .point(historyTest.getPoint())
                    .build();
            result.add(historyTestDTO);
        }
        return result;
    }

    @Override
    public HistoryTest updateHistoryTest(HistoryTestDTO historyTestDTO, Integer historyTestId) {
        HistoryTest historyTest = findById(historyTestId);
        historyTest.setPoint(historyTestDTO.getPoint());
        historyTest.setStatus(historyTestDTO.getStatus());
        return historyTestRepository.save(historyTest);
    }

    @Override
    public HistoryTest findById(Integer id) {
        return historyTestRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(new SysError(Errors.ERROR_HISTORY_TEST_NOT_FOUND)));
    }


}
