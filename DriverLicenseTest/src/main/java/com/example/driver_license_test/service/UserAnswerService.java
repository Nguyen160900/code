package com.example.driver_license_test.service;

import com.example.driver_license_test.dto.UserAnswerDTO;

import java.util.List;

public interface UserAnswerService {
    int saveUserAnswer(List<UserAnswerDTO> userAnswerDTOs, Integer historyTestId);

    List<UserAnswerDTO> getAllByHistoryTestId(Integer historyTestId);
}
