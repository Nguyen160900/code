package com.example.driver_license_test.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CorrectAnswerDTO {
    private Integer levelId;
    private Integer questionId;
    private String questionName;
    private Integer correctAnswerId;
    private Integer userAnswerId;
    private List<AnswerDTO> answerDTOs;
}
