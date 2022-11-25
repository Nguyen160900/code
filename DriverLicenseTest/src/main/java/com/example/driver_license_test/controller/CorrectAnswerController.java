package com.example.driver_license_test.controller;

import com.example.driver_license_test.config.contant.Constant;
import com.example.driver_license_test.dto.CorrectAnswerDTO;
import com.example.driver_license_test.dto.ResponeJson;
import com.example.driver_license_test.service.CorrectAnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/correct-answer")
public class CorrectAnswerController {
    private final CorrectAnswerService correctAnswerService;

    public CorrectAnswerController(CorrectAnswerService correctAnswerService) {
        this.correctAnswerService = correctAnswerService;
    }

    @GetMapping("/result-test/{historyTestId}")
    public ResponseEntity<ResponeJson<List<CorrectAnswerDTO>>> getResultCorrectAnswer(@PathVariable("historyTestId") Integer historyTestId) {
        List<CorrectAnswerDTO> correctAnswerDTOs = correctAnswerService.showCorrectAnswer(historyTestId);
        return ResponseEntity.ok()
                .body(new ResponeJson<>(correctAnswerDTOs, HttpStatus.OK, Constant.SUCCESS));
    }
}
