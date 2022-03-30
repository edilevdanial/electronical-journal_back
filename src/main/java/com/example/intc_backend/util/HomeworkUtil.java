package com.example.intc_backend.util;

import com.example.intc_backend.dto.HomeworkDto;
import com.example.intc_backend.dto.HomeworkSaveRequestDto;
import com.example.intc_backend.model.Homework;

import java.util.ArrayList;
import java.util.List;

public class HomeworkUtil {
    public static Homework toHomework(HomeworkSaveRequestDto homeworkSaveRequestDto, Long courseId, Long groupId) {
        Homework homework = new Homework();
        homework.setDescription(homeworkSaveRequestDto.getDescription());
        homework.setCourseId(courseId);
        homework.setName(homeworkSaveRequestDto.getName());
        homework.setTeacherId(homeworkSaveRequestDto.getTeacherId());
        homework.setLessonId(homeworkSaveRequestDto.getLessonId());
        homework.setType(homeworkSaveRequestDto.getType());
        homework.setGroupId(groupId);
        return homework;
    }

    public static HomeworkDto toHomeWorkDto(Homework homework) {
        HomeworkDto homeworkDto = new HomeworkDto();
        homeworkDto.setId(homework.getId());
        homeworkDto.setDescription(homework.getDescription());
        homeworkDto.setCourseId(homework.getCourseId());
        homeworkDto.setName(homework.getName());
        homeworkDto.setTeacherId(homework.getTeacherId());
        homeworkDto.setLessonId(homework.getLessonId());
        homeworkDto.setType(homework.getType());
        homeworkDto.setGroupId(homework.getGroupId());
        return homeworkDto;
    }

    public static List<HomeworkDto> toHomeWorkDtoList(List<Homework> homeworkList) {
        List<HomeworkDto> homeworkDtoList = new ArrayList<>();
        for (Homework homework : homeworkList) {
            homeworkDtoList.add(toHomeWorkDto(homework));
        }
        return homeworkDtoList;
    }
}
