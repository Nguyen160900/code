package com.example.driver_license_test.service;

import com.example.driver_license_test.dto.QuestionDTO;

import java.util.List;

public interface QuestionService {
    List<QuestionDTO> getQuestionToLevel(Integer levelId);
    QuestionDTO getById(Integer questionId);
}
