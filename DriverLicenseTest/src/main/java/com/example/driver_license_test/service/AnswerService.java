package com.example.driver_license_test.service;

import com.example.driver_license_test.dto.AnswerDTO;

import java.util.List;

public interface AnswerService {
    List<AnswerDTO> getByQuestionId(Integer questionId);
}
