package com.example.driver_license_test.controller;

import com.example.driver_license_test.config.contant.Constant;
import com.example.driver_license_test.dto.HistoryTestDTO;
import com.example.driver_license_test.dto.ResponeJson;
import com.example.driver_license_test.service.HistoryTestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/history-test")
public class HistoryTestController {
    private final HistoryTestService historyTestService;

    public HistoryTestController(HistoryTestService historyTestService) {
        this.historyTestService = historyTestService;
    }

    @GetMapping("/history")
    public ResponseEntity<ResponeJson<List<HistoryTestDTO>>> getHistoryTest() {
        List<HistoryTestDTO> historyTestDTOS = historyTestService.getHistoryTestByUserId();
        return ResponseEntity.ok().body(new ResponeJson<>(historyTestDTOS, HttpStatus.OK, Constant.SUCCESS));
    }
}
