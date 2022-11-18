package com.example.DriverLicenseTest.serviceimpl;

import com.example.DriverLicenseTest.dto.AnswerDTO;
import com.example.DriverLicenseTest.entity.Answer;
import com.example.DriverLicenseTest.repository.AnswerRepository;
import com.example.DriverLicenseTest.service.AnswerService;
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
    public List<AnswerDTO> getAnswerByQuestionId(Integer questionId) {
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
