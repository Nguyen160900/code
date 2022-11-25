package com.example.driver_license_test.controller;

import com.example.driver_license_test.config.contant.Constant;
import com.example.driver_license_test.dto.ResponeJson;
import com.example.driver_license_test.dto.UserTestDTO;
import com.example.driver_license_test.service.UserTestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/user-test")
public class UserTestController {
    private final UserTestService userTestService;

    public UserTestController(UserTestService userTestService) {
        this.userTestService = userTestService;
    }

    @PostMapping("/save")
    public ResponseEntity<ResponeJson<Boolean>> saveUserAnswer(@RequestBody UserTestDTO userTestDTO) {
        boolean status = userTestService.save(userTestDTO);
        return ResponseEntity.ok().body(new ResponeJson<>(status, HttpStatus.OK, Constant.SUCCESS));
    }
}
