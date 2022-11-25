package com.example.driver_license_test.service;

import com.example.driver_license_test.dto.UserTestDTO;

public interface UserTestService {
    int getNumberRegister(Integer testInfoId);

    boolean save(UserTestDTO userTestDTO);
}
