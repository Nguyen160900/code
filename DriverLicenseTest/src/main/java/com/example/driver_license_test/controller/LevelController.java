package com.example.driver_license_test.controller;

import com.example.driver_license_test.config.contant.Constant;
import com.example.driver_license_test.dto.LevelDTO;
import com.example.driver_license_test.dto.ResponeJson;
import com.example.driver_license_test.service.LevelService;
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

    @GetMapping("/{levelId}")
    public ResponseEntity<ResponeJson<LevelDTO>> findById(@PathVariable("levelId") Integer levelId){
        LevelDTO levelDTO = levelService.findById(levelId);
        return ResponseEntity.ok().body(new ResponeJson<>(levelDTO, HttpStatus.OK, Constant.SUCCESS));
    }
}
