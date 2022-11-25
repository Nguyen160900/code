package com.example.driver_license_test.serviceimpl;

import com.example.driver_license_test.dto.AnswerDTO;
import com.example.driver_license_test.entity.Answer;
import com.example.driver_license_test.repository.AnswerRepository;
import com.example.driver_license_test.service.AnswerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public List<AnswerDTO> getByQuestionId(Integer questionId) {
        List<Answer> answers = answerRepository.getAnswerByQuestionId(questionId);
        List<AnswerDTO> listAnswerDTO = new ArrayList<>();
        for (Answer answer : answers) {
            AnswerDTO answerDTO = AnswerDTO.builder()
                    .idAnswer(answer.getId())
                    .name(answer.getName())
                    .build();
            listAnswerDTO.add(answerDTO);
        }
        return listAnswerDTO;
    }
}
