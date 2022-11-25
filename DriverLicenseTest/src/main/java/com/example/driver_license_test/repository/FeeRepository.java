package com.example.driver_license_test.repository;

import com.example.driver_license_test.entity.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeeRepository extends JpaRepository<Fee, Integer> {
    @Query("select f from Fee f " +
            "where f.level.id = ?1 " +
            "order by f.timeSave DESC")
    List<Fee> findByLevelIdDesc(Integer levelId);
}