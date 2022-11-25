package com.example.driver_license_test.service;

import com.example.driver_license_test.dto.LevelDTO;

import java.util.List;

public interface LevelService {
    List<LevelDTO> getAllLevel();
    String getLevelName(Integer levelId);
    LevelDTO findById(Integer levelId);
}
