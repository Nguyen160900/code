package com.example.driver_license_test.repository;

import com.example.driver_license_test.entity.UserTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserTestRepository extends JpaRepository<UserTest, Integer> {
    @Query("select u from UserTest u where u.testsInfo.id = ?1")
    List<UserTest> findByTestInfoId(Integer testInfoId);
}