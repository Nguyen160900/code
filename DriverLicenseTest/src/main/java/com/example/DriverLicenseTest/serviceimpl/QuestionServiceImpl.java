package com.example.DriverLicenseTest.serviceimpl;

import com.example.DriverLicenseTest.config.Contant.Constant;
import com.example.DriverLicenseTest.dto.AnswerDTO;
import com.example.DriverLicenseTest.dto.QuestionDTO;
import com.example.DriverLicenseTest.entity.Question;
import com.example.DriverLicenseTest.repository.QuestionRepository;
import com.example.DriverLicenseTest.service.AnswerService;
import com.example.DriverLicenseTest.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final AnswerService answerService;

    public QuestionServiceImpl(QuestionRepository questionRepository, AnswerService answerService) {
        this.questionRepository = questionRepository;
        this.answerService = answerService;
    }

    private Integer randomNumberQuestionParalyzed() {
        int[] items = new int[]{2, 3, 4};
        Random rand = new Random();
        return items[rand.nextInt(items.length)];
    }

    private List<QuestionDTO> getQuestion(Integer levelId, Integer limit, Boolean type) {
        List<Question> questions;
        if (Boolean.TRUE.equals(type)) {
            questions = questionRepository.getQuestionToLevelId(levelId, limit, true);
        } else {
            questions = questionRepository.getQuestionToLevelId(levelId, limit, false);
        }
        List<QuestionDTO> getQuestion = new ArrayList<>();
        for (Question question : questions) {
            List<AnswerDTO> answerDTOList = answerService.getAnswerByQuestionId(question.getId());
            QuestionDTO questionDTO = QuestionDTO.builder()
                    .questionId(question.getId())
                    .name(question.getName())
                    .listAnswer(answerDTOList)
                    .build();
            getQuestion.add(questionDTO);
        }
        return getQuestion;
    }

    @Override
    public List<QuestionDTO> getQuestionToLevel(Integer levelId) {
        Integer numberQuestionParalyzed = randomNumberQuestionParalyzed();
        Integer numberQuestion = Constant.NUMBER_QUESTION - numberQuestionParalyzed;
        List<QuestionDTO> questionParalyzed = getQuestion(levelId, numberQuestionParalyzed, true);
        List<QuestionDTO> questions = getQuestion(levelId, numberQuestion, false);
        List<QuestionDTO> getAllQuestionToLevel = new ArrayList<>();
        getAllQuestionToLevel.addAll(questions);
        getAllQuestionToLevel.addAll(questionParalyzed);
        Collections.shuffle(getAllQuestionToLevel);
        return getAllQuestionToLevel;
    }
}
