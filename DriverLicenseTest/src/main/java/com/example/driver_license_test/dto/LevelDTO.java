package com.example.driver_license_test.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LevelDTO {
    private Integer levelId;
    private String name;
    private String descriptions;
    private Integer timeTest;
    private String categoryName;
    private String categoryDescription;
    private Integer numberQuestion;
    private Integer numberQuestionPass;
}
