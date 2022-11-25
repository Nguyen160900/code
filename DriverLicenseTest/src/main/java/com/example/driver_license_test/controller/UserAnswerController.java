package com.example.driver_license_test.controller;

import com.example.driver_license_test.config.contant.Constant;
import com.example.driver_license_test.dto.ResponeJson;
import com.example.driver_license_test.dto.UserAnswerDTO;
import com.example.driver_license_test.service.UserAnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/user-answer")
public class UserAnswerController {
    private final UserAnswerService userAnswerService;

    public UserAnswerController(UserAnswerService userAnswerService) {
        this.userAnswerService = userAnswerService;
    }

    @PostMapping("/save/{levelId}")
    public ResponseEntity<ResponeJson<Integer>> saveUserAnswer(@RequestBody List<UserAnswerDTO> userAnswerDTOs,
                                                               @PathVariable("levelId") Integer levelId) {
        int status = userAnswerService.saveUserAnswer(userAnswerDTOs, levelId);
        return ResponseEntity.ok().body(new ResponeJson<>(status, HttpStatus.OK, Constant.SUCCESS));
    }
}
