package com.example.driver_license_test.controller;

import com.example.driver_license_test.config.contant.Constant;
import com.example.driver_license_test.dto.ResponeJson;
import com.example.driver_license_test.dto.TestsInfoDTO;
import com.example.driver_license_test.service.TestsInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/test-info")
public class TestInfoController {
    private final TestsInfoService testsInfoService;

    public TestInfoController(TestsInfoService testsInfoService) {
        this.testsInfoService = testsInfoService;
    }

    @GetMapping
    public ResponseEntity<ResponeJson<Page<TestsInfoDTO>>> findAll(@RequestParam(defaultValue = "0") Integer page,
                                                                   @RequestParam(defaultValue = "10") Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("dateOpen").descending());
        Page<TestsInfoDTO> testsInfoDTOPage = testsInfoService.findAll(pageable);
        return ResponseEntity.ok().body(new ResponeJson<>(testsInfoDTOPage, HttpStatus.OK, Constant.SUCCESS));
    }
}
