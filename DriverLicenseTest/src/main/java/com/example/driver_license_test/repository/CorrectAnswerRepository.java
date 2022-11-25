package com.example.driver_license_test.repository;

import com.example.driver_license_test.entity.CorrectAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorrectAnswerRepository extends JpaRepository<CorrectAnswer, Integer> {
    CorrectAnswer findByQuestionId(Integer questionId);
}
