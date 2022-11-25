package com.example.driver_license_test.repository;

import com.example.driver_license_test.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    @Query("select a from Answer a where a.question.id = ?1")
    List<Answer> getAnswerByQuestionId(Integer id);
}
