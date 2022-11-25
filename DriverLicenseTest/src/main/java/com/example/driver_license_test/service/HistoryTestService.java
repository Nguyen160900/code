package com.example.driver_license_test.service;

import com.example.driver_license_test.dto.HistoryTestDTO;
import com.example.driver_license_test.entity.HistoryTest;

import java.util.List;

public interface HistoryTestService {
    HistoryTest saveHistoryTest(Integer levelId);
    HistoryTestDTO getById(Integer histtoryId);

    List<HistoryTestDTO> getHistoryTestByUserId();

    HistoryTest updateHistoryTest(HistoryTestDTO historyTestDTO, Integer historyTestId);

    HistoryTest findById(Integer id);
}
