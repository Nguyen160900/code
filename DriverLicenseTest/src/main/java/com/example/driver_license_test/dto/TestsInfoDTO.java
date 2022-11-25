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
public class TestsInfoDTO {
    private Integer id;
    private String dateRealTest;
    private String dateMockTest;
    private String dateOpen;
    private String dateClose;
    private Integer numberSubscription;
    private LevelDTO levelDTO;
    private String categoryName;
    private FeeDTO feeDTO;
    private Integer numberRegister;
}
