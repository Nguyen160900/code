package com.example.driver_license_test.service;

import com.example.driver_license_test.dto.FeeDTO;

public interface FeeService {
    FeeDTO findByLevelId(Integer levelId);
}
