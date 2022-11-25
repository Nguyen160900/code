package com.example.driver_license_test.serviceimpl;

import com.example.driver_license_test.config.contant.Errors;
import com.example.driver_license_test.config.utils.NumberQuestion;
import com.example.driver_license_test.dto.AnswerDTO;
import com.example.driver_license_test.dto.QuestionDTO;
import com.example.driver_license_test.entity.Question;
import com.example.driver_license_test.exception.BadRequestException;
import com.example.driver_license_test.exception.SysError;
import com.example.driver_license_test.repository.QuestionRepository;
import com.example.driver_license_test.service.AnswerService;
import com.example.driver_license_test.service.LevelService;
import com.example.driver_license_test.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final LevelService levelService;
    private final AnswerService answerService;

    private Integer randomNumberQuestionParalyzed() {
        int[] items = new int[]{2, 3, 4};
        Random rand = new Random();
        return items[rand.nextInt(items.length)];
    }

    private List<QuestionDTO> getListQuestion(Integer levelId, Integer limit, Boolean type) {
        List<Question> questions;
        if (Boolean.TRUE.equals(type)) {
            questions = questionRepository.getQuestionToLevelId(levelId, limit, true);
        } else {
            questions = questionRepository.getQuestionToLevelId(levelId, limit, false);
        }
        List<QuestionDTO> getQuestion = new ArrayList<>();
        for (Question question : questions) {
            List<AnswerDTO> answerDTOList = answerService.getByQuestionId(question.getId());
            QuestionDTO questionDTO = QuestionDTO.builder()
                    .questionId(question.getId())
                    .name(question.getName())
                    .listAnswer(answerDTOList)
                    .image(question.getImage())
                    .build();
            getQuestion.add(questionDTO);
        }
        return getQuestion;
    }

    @Override
    public List<QuestionDTO> getQuestionToLevel(Integer levelId) {
        Integer numberQuestionParalyzed = randomNumberQuestionParalyzed();
        Integer numberQuestion = NumberQuestion.getNumberQuestion(levelService.getLevelName(levelId)) - numberQuestionParalyzed;
        List<QuestionDTO> questionParalyzed = getListQuestion(levelId, numberQuestionParalyzed, true);
        List<QuestionDTO> questions = getListQuestion(levelId, numberQuestion, false);
        List<QuestionDTO> getAllQuestionToLevel = new ArrayList<>();
        getAllQuestionToLevel.addAll(questions);
        getAllQuestionToLevel.addAll(questionParalyzed);
        Collections.shuffle(getAllQuestionToLevel);
        return getAllQuestionToLevel;
    }

    @Override
    public QuestionDTO getById(Integer questionId) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new BadRequestException(new SysError(Errors.ERROR_QUESTION_NOT_FOUND)));
        return QuestionDTO.builder()
                .questionId(question.getId())
                .name(question.getName())
                .type(question.getType())
                .image(question.getImage())
                .levelId(question.getLevel().getId())
                .levelName(question.getLevel().getName())
                .build();
    }


}
