package com.example.intc_backend.util;

import com.example.intc_backend.dto.GroupDto;
import com.example.intc_backend.dto.LessonDto;
import com.example.intc_backend.dto.LessonSaveRequestDto;
import com.example.intc_backend.model.Group;
import com.example.intc_backend.model.Lesson;

import java.util.ArrayList;
import java.util.List;

public class LessonUtil {
    public static LessonDto toLessonDto(Lesson lesson){
        LessonDto lessonDto = new LessonDto();
        lessonDto.setId(lesson.getId());
        lessonDto.setCourseId(lesson.getCourseId());
        lessonDto.setGroupId(lesson.getGroupId());
        lessonDto.setDescription(lesson.getDescription());
        lessonDto.setLink(lesson.getLink());
        lessonDto.setName(lesson.getName());
        return lessonDto;
    }
    public static List<LessonDto> toLessonDtoList(List<Lesson> lessonList){
        List<LessonDto> lessonDtoList = new ArrayList<>();
        for (Lesson lesson:lessonList){
            lessonDtoList.add(toLessonDto(lesson));
        }
        return lessonDtoList;
    }
    public static Lesson toLesson(LessonSaveRequestDto lessonSaveRequestDto){
        Lesson lesson = new Lesson();
        lesson.setCourseId(lessonSaveRequestDto.getCourseId());
        lesson.setDescription(lessonSaveRequestDto.getDescription());
        lesson.setGroupId(lessonSaveRequestDto.getGroupId());
        lesson.setLink(lessonSaveRequestDto.getLink());
        lesson.setName(lessonSaveRequestDto.getName());
        return lesson;
    }
}
