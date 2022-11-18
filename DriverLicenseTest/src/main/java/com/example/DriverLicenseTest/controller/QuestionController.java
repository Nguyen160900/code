package com.example.DriverLicenseTest.controller;

import com.example.DriverLicenseTest.config.Contant.Constant;
import com.example.DriverLicenseTest.dto.QuestionDTO;
import com.example.DriverLicenseTest.dto.ResponeJson;
import com.example.DriverLicenseTest.service.QuestionService;
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
@RequestMapping("/api/question")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/all/{levelId}")
    public ResponseEntity<ResponeJson<List<QuestionDTO>>> getQuestionByLevelId(@PathVariable("levelId") Integer levelId){
        List<QuestionDTO> allQuestion = questionService.getQuestionToLevel(levelId);
        return ResponseEntity.ok().body(new ResponeJson<>(allQuestion, HttpStatus.OK, Constant.SUCCESS));
    }
}
