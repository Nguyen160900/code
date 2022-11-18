package com.example.DriverLicenseTest.service;

import com.example.DriverLicenseTest.dto.QuestionDTO;

import java.util.List;

public interface QuestionService {
    List<QuestionDTO> getQuestionToLevel(Integer levelId);
}
