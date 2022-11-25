package com.example.driver_license_test.repository;

import com.example.driver_license_test.entity.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer, Integer> {
    List<UserAnswer> getByHistoryTestId(Integer historyTestId);
}
