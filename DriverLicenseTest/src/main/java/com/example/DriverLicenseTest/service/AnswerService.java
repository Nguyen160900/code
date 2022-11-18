package com.example.DriverLicenseTest.service;

import com.example.DriverLicenseTest.dto.AnswerDTO;

import java.util.List;

public interface AnswerService {
    List<AnswerDTO> getAnswerByQuestionId(Integer questionId);
}
