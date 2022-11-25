package com.example.driver_license_test.serviceimpl;

import com.example.driver_license_test.config.contant.Errors;
import com.example.driver_license_test.config.utils.NumberQuestion;
import com.example.driver_license_test.dto.LevelDTO;
import com.example.driver_license_test.entity.Level;
import com.example.driver_license_test.exception.BadRequestException;
import com.example.driver_license_test.exception.SysError;
import com.example.driver_license_test.repository.LevelRepository;
import com.example.driver_license_test.service.LevelService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LevelServiceImpl implements LevelService {
    private final LevelRepository levelRepository;

    public LevelServiceImpl(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @Override
    public List<LevelDTO> getAllLevel() {
        List<Level> levels = levelRepository.findAll();
        List<LevelDTO> getAll = new ArrayList<>();
        for (Level level : levels) {
            LevelDTO levelDTO = LevelDTO.builder()
                    .levelId(level.getId())
                    .name(level.getName())
                    .descriptions(level.getDescriptions())
                    .timeTest(level.getTimeTest())
                    .categoryName(level.getCategory().getName())
                    .categoryDescription(level.getCategory().getDescriptions())
                    .build();
            getAll.add(levelDTO);
        }
        return getAll;
    }

    @Override
    public String getLevelName(Integer levelId) {
        Level level = levelRepository.findById(levelId)
                .orElseThrow(() -> new BadRequestException(new SysError(Errors.ERROR_LEVEL_NOT_FOUND)));
        return level.getName();
    }

    @Override
    public LevelDTO findById(Integer levelId) {
        Level level = levelRepository.findById(levelId)
                .orElseThrow(() -> new BadRequestException(new SysError(Errors.ERROR_LEVEL_NOT_FOUND)));
        return LevelDTO.builder()
                .levelId(level.getId())
                .name(level.getName())
                .descriptions(level.getDescriptions())
                .timeTest(level.getTimeTest())
                .categoryName(level.getCategory().getName())
                .descriptions(level.getCategory().getDescriptions())
                .numberQuestion(NumberQuestion.getNumberQuestion(level.getName()))
                .numberQuestionPass(NumberQuestion.getNumberQuestionPass(level.getName()))
                .build();
    }
}
