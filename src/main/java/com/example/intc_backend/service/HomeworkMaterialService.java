package com.example.intc_backend.service;

import com.example.intc_backend.dto.HomeworkMaterialDto;
import com.example.intc_backend.dto.HomeworkMaterialSaveRequestDto;
import com.example.intc_backend.model.HomeworkMaterial;

public interface HomeworkMaterialService {
    void save(HomeworkMaterialSaveRequestDto homeworkMaterialSaveRequestDto);

    HomeworkMaterialDto getByHomeworkId(Long homeworkId);
}
