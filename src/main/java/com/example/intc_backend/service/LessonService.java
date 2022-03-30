package com.example.intc_backend.service;

import com.example.intc_backend.dto.LessonDto;
import com.example.intc_backend.dto.LessonSaveRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LessonService {
    void saveLesson(LessonSaveRequestDto lessonSaveRequestDto);

    LessonDto getLessonById(Long lessonId);

    List<LessonDto> allLessonByGroupId(Long groupId,Long courseId);

}
