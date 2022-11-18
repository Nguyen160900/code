package com.example.DriverLicenseTest.controller;

import com.example.DriverLicenseTest.config.Contant.Constant;
import com.example.DriverLicenseTest.dto.LevelDTO;
import com.example.DriverLicenseTest.dto.ResponeJson;
import com.example.DriverLicenseTest.service.LevelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/level")
public class LevelController {
    private final LevelService levelService;

    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    @GetMapping("/all")
    public ResponseEntity<ResponeJson<List<LevelDTO>>> getAllLevel(){
        List<LevelDTO> allLevel = levelService.getAllLevel();
        return ResponseEntity.ok().body(new ResponeJson<>(allLevel, HttpStatus.OK, Constant.SUCCESS));
    }
}
