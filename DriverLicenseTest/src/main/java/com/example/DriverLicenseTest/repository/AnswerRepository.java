package com.example.DriverLicenseTest.repository;

import com.example.DriverLicenseTest.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    @Query("select a from Answer a where a.question.id = ?1")
    List<Answer> getAnswerByQuestionId(Integer id);
}
