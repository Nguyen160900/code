package com.example.driver_license_test.service;

import com.example.driver_license_test.dto.CorrectAnswerDTO;
import com.example.driver_license_test.dto.UserAnswerDTO;

import java.util.List;

public interface CorrectAnswerService {
    List<CorrectAnswerDTO> showCorrectAnswer(Integer historyTestId);
    CorrectAnswerDTO getByQuestionId(Integer questionId);
    int checkAnswerPoint(List<UserAnswerDTO> userAnswerDTOS);
    String checkAnswerStatus(List<UserAnswerDTO> userAnswerDTOS);
}
