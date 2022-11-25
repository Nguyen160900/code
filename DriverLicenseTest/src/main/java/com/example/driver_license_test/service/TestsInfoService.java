package com.example.driver_license_test.service;

import com.example.driver_license_test.dto.TestsInfoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TestsInfoService {
    Page<TestsInfoDTO> findAll(Pageable pageable);
    TestsInfoDTO findById(Integer testInfoId);
}
