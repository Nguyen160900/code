package com.example.driver_license_test.serviceimpl;

import com.example.driver_license_test.config.contant.Errors;
import com.example.driver_license_test.dto.HistoryTestDTO;
import com.example.driver_license_test.dto.UserAnswerDTO;
import com.example.driver_license_test.entity.Answer;
import com.example.driver_license_test.entity.HistoryTest;
import com.example.driver_license_test.entity.Question;
import com.example.driver_license_test.entity.UserAnswer;
import com.example.driver_license_test.exception.BadRequestException;
import com.example.driver_license_test.exception.SysError;
import com.example.driver_license_test.repository.AnswerRepository;
import com.example.driver_license_test.repository.QuestionRepository;
import com.example.driver_license_test.repository.UserAnswerRepository;
import com.example.driver_license_test.service.CorrectAnswerService;
import com.example.driver_license_test.service.HistoryTestService;
import com.example.driver_license_test.service.UserAnswerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserAnswerServiceImpl implements UserAnswerService {
    private final UserAnswerRepository userAnswerRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final HistoryTestService historyTestService;
    private final CorrectAnswerService correctAnswerService;

    @Override
    public int saveUserAnswer(List<UserAnswerDTO> userAnswerDTOs, Integer levelId) {
        HistoryTest historyTest = historyTestService.saveHistoryTest(levelId);
        save(userAnswerDTOs, historyTest.getId());
        HistoryTestDTO historyTestDTO = HistoryTestDTO.builder()
                .point(correctAnswerService.checkAnswerPoint(userAnswerDTOs))
                .status(correctAnswerService.checkAnswerStatus(userAnswerDTOs))
                .build();
        historyTestService.updateHistoryTest(historyTestDTO, historyTest.getId());
        return historyTest.getId();
    }

    private void save(List<UserAnswerDTO> userAnswerDTOs, Integer historyTestId) {
        for (UserAnswerDTO userAnswerDTO : userAnswerDTOs) {
            HistoryTest historyTest = historyTestService.findById(historyTestId);
            Question question = questionRepository.findById(userAnswerDTO.getQuestionId())
                    .orElseThrow(() -> new BadRequestException(new SysError(Errors.ERROR_QUESTION_NOT_FOUND)));
            Answer answer = answerRepository.findById(userAnswerDTO.getAnswerId())
                    .orElseThrow(() -> new BadRequestException(new SysError(Errors.ERROR_ANSWER_NOT_FOUND)));
            UserAnswer save = UserAnswer.builder()
                    .historyTest(historyTest)
                    .question(question)
                    .answer(answer)
                    .build();
            userAnswerRepository.save(save);
        }
    }

    @Override
    public List<UserAnswerDTO> getAllByHistoryTestId(Integer historyTestId) {
        List<UserAnswer> userAnswers = userAnswerRepository.getByHistoryTestId(historyTestId);
        List<UserAnswerDTO> result = new ArrayList<>();
        for (UserAnswer userAnswer : userAnswers) {
            UserAnswerDTO userAnswerDTO = UserAnswerDTO.builder()
                    .questionId(userAnswer.getQuestion().getId())
                    .answerId(userAnswer.getAnswer().getId())
                    .build();
            result.add(userAnswerDTO);
        }
        return result;
    }
}
