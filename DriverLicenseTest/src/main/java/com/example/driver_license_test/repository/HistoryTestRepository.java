package com.example.driver_license_test.repository;

import com.example.driver_license_test.entity.HistoryTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HistoryTestRepository extends JpaRepository<HistoryTest, Integer> {
    HistoryTest findByTimeSaveAndUserId(LocalDateTime timeSaveNew, Integer id);

    List<HistoryTest> findByUserId(Integer userId);
}
