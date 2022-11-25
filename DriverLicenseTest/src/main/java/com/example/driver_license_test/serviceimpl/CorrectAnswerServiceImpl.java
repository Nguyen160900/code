package com.example.driver_license_test.serviceimpl;

import com.example.driver_license_test.config.utils.NumberQuestion;
import com.example.driver_license_test.dto.AnswerDTO;
import com.example.driver_license_test.dto.CorrectAnswerDTO;
import com.example.driver_license_test.dto.HistoryTestDTO;
import com.example.driver_license_test.dto.QuestionDTO;
import com.example.driver_license_test.dto.UserAnswerDTO;
import com.example.driver_license_test.entity.CorrectAnswer;
import com.example.driver_license_test.entity.UserAnswer;
import com.example.driver_license_test.repository.CorrectAnswerRepository;
import com.example.driver_license_test.repository.UserAnswerRepository;
import com.example.driver_license_test.service.AnswerService;
import com.example.driver_license_test.service.CorrectAnswerService;
import com.example.driver_license_test.service.HistoryTestService;
import com.example.driver_license_test.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CorrectAnswerServiceImpl implements CorrectAnswerService {
    public static final String FAIL = "Fail";
    public static final String PASS = "Pass";
    private final CorrectAnswerRepository correctAnswerRepository;
    private final UserAnswerRepository userAnswerRepository;
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final HistoryTestService historyTestService;

    @Override
    public List<CorrectAnswerDTO> showCorrectAnswer(Integer historyTestId) {
        HistoryTestDTO historyTestDTO = historyTestService.getById(historyTestId);
        List<UserAnswer> userAnswers = userAnswerRepository.getByHistoryTestId(historyTestId);
        List<CorrectAnswerDTO> result = new ArrayList<>();
        for (UserAnswer userAnswer : userAnswers) {
            QuestionDTO questionDTO = questionService.getById(userAnswer.getQuestion().getId());
            List<AnswerDTO> listAnswerDTO = answerService.getByQuestionId(userAnswer.getQuestion().getId());
            CorrectAnswerDTO correctAnswer = getByQuestionId(userAnswer.getQuestion().getId());
            CorrectAnswerDTO correctAnswerDTO = CorrectAnswerDTO.builder()
                    .levelId(historyTestDTO.getLevelId())
                    .questionId(userAnswer.getQuestion().getId())
                    .questionName(questionDTO.getName())
                    .userAnswerId(userAnswer.getAnswer().getId())
                    .answerDTOs(listAnswerDTO)
                    .correctAnswerId(correctAnswer.getCorrectAnswerId())
                    .build();
            result.add(correctAnswerDTO);
        }
        return result;
    }

    @Override
    public CorrectAnswerDTO getByQuestionId(Integer questionId) {
        CorrectAnswer correctAnswer = correctAnswerRepository.findByQuestionId(questionId);
        return CorrectAnswerDTO.builder()
                .questionId(correctAnswer.getQuestion().getId())
                .correctAnswerId(correctAnswer.getAnswer().getId())
                .build();
    }

    @Override
    public int checkAnswerPoint(List<UserAnswerDTO> userAnswerDTOS) {
        int point = 0;
        for (UserAnswerDTO userAnswerDTO : userAnswerDTOS) {
            CorrectAnswerDTO correctAnswer = getByQuestionId(userAnswerDTO.getQuestionId());
            if (Objects.equals(userAnswerDTO.getAnswerId(), correctAnswer.getCorrectAnswerId())) {
                point += 1;
            }
        }
        return point;
    }

    @Override
    public String checkAnswerStatus(List<UserAnswerDTO> userAnswerDTOS) {
        String levelName = "";
        for (UserAnswerDTO userAnswerDTO : userAnswerDTOS) {
            QuestionDTO question = questionService.getById(userAnswerDTO.getQuestionId());
            levelName = question.getLevelName();
            CorrectAnswerDTO correctAnswer = getByQuestionId(userAnswerDTO.getQuestionId());
            if (!Boolean.TRUE.equals(question.getType()) &&
                    !Objects.equals(userAnswerDTO.getAnswerId(), correctAnswer.getCorrectAnswerId())) {
                return FAIL;
            }
        }
        if(checkAnswerPoint(userAnswerDTOS) < NumberQuestion.getNumberQuestionPass(levelName))
        {
            return FAIL;
        }
        return PASS;
    }
}
