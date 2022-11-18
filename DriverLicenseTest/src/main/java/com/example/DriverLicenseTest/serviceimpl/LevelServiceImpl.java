package com.example.DriverLicenseTest.serviceimpl;

import com.example.DriverLicenseTest.dto.LevelDTO;
import com.example.DriverLicenseTest.entity.Level;
import com.example.DriverLicenseTest.repository.LevelRepository;
import com.example.DriverLicenseTest.service.LevelService;
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
                    .build();
            getAll.add(levelDTO);
        }
        return getAll;
    }
}
