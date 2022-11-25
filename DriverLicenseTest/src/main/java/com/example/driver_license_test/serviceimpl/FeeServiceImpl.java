package com.example.driver_license_test.serviceimpl;

import com.example.driver_license_test.config.utils.DateRangeUtils;
import com.example.driver_license_test.dto.FeeDTO;
import com.example.driver_license_test.entity.Fee;
import com.example.driver_license_test.repository.FeeRepository;
import com.example.driver_license_test.service.FeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FeeServiceImpl implements FeeService {
    private final FeeRepository feeRepository;

    @Override
    public FeeDTO findByLevelId(Integer levelId) {
        Fee fee = feeRepository.findByLevelIdDesc(levelId).get(0);
        Integer total = fee.getApplication() + fee.getTheoretical() + fee.getPratice() + fee.getCard();
        return FeeDTO.builder()
                .application(fee.getApplication())
                .theoretical(fee.getTheoretical())
                .pratice(fee.getPratice())
                .card(fee.getCard())
                .total(total)
                .timeSave(DateRangeUtils.convertDate(fee.getTimeSave()))
                .build();
    }
}
