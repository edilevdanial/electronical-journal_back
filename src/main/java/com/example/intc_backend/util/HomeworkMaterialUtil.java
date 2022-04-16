package com.example.intc_backend.util;

import com.example.intc_backend.dto.HomeworkMaterialDto;
import com.example.intc_backend.dto.HomeworkMaterialSaveRequestDto;
import com.example.intc_backend.dto.HomeworkSaveRequestDto;
import com.example.intc_backend.model.HomeworkMaterial;

public class HomeworkMaterialUtil {
    public static HomeworkMaterial toHomeworkMaterial(HomeworkMaterialSaveRequestDto homeworkMaterialSaveRequestDto) {
        HomeworkMaterial homeworkMaterial = new HomeworkMaterial();
        homeworkMaterial.setHomeworkId(homeworkMaterialSaveRequestDto.getHomeworkId());
        homeworkMaterial.setLink(homeworkMaterialSaveRequestDto.getLink());
        return homeworkMaterial;
    }

    public static HomeworkMaterialDto toHomeworkMaterialDto(HomeworkMaterial homeworkMaterial) {
        HomeworkMaterialDto homeworkMaterialDto = new HomeworkMaterialDto();
        homeworkMaterialDto.setHomeworkId(homeworkMaterial.getHomeworkId());
        homeworkMaterialDto.setLink(homeworkMaterial.getLink());
        return homeworkMaterialDto;
    }
}
