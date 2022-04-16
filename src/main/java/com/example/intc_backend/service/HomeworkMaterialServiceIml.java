package com.example.intc_backend.service;

import com.example.intc_backend.dto.HomeworkMaterialDto;
import com.example.intc_backend.dto.HomeworkMaterialSaveRequestDto;
import com.example.intc_backend.model.HomeworkMaterial;
import com.example.intc_backend.repository.HomeworkMaterialRepository;
import com.example.intc_backend.util.HomeworkMaterialUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeworkMaterialServiceIml implements HomeworkMaterialService {
    @Autowired
    private HomeworkMaterialRepository homeworkMaterialRepository;
    @Override
    public void save(HomeworkMaterialSaveRequestDto homeworkMaterialSaveRequestDto) {
         homeworkMaterialRepository.save(HomeworkMaterialUtil.toHomeworkMaterial(homeworkMaterialSaveRequestDto));
    }

    @Override
    public HomeworkMaterialDto getByHomeworkId(Long homeworkId) {
      HomeworkMaterialDto homeworkMaterialDto = HomeworkMaterialUtil.toHomeworkMaterialDto(homeworkMaterialRepository.getById(homeworkId));
      return homeworkMaterialDto;
    }
}
