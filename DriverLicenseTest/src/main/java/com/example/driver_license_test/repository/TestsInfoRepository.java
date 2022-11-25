package com.example.driver_license_test.repository;

import com.example.driver_license_test.entity.TestsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestsInfoRepository extends JpaRepository<TestsInfo, Integer> {
}