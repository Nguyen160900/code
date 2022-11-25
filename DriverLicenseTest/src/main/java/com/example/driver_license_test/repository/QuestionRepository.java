package com.example.driver_license_test.repository;

import com.example.driver_license_test.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    @Query(value = "SELECT * FROM questions\n" +
            "INNER JOIN levels ON levels.id = questions.level_id\n" +
            "WHERE levels.id = :levelId AND questions.type = :type\n" +
            "ORDER BY RAND () limit :limit", nativeQuery = true)
    List<Question> getQuestionToLevelId(@Param("levelId") Integer levelId,
                                        @Param("limit") Integer limit,
                                        @Param("type") Boolean type);
}
