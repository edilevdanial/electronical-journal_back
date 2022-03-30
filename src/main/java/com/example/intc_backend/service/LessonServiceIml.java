package com.example.intc_backend.service;

import com.example.intc_backend.dto.LessonDto;
import com.example.intc_backend.dto.LessonSaveRequestDto;
import com.example.intc_backend.repository.LessonRepository;
import com.example.intc_backend.util.LessonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceIml implements LessonService {
    private final LessonRepository lessonRepository;

    public LessonServiceIml(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public void saveLesson(LessonSaveRequestDto lessonSaveRequestDto) {
        lessonRepository.save(LessonUtil.toLesson(lessonSaveRequestDto));
    }

    @Override
    public LessonDto getLessonById(Long lessonId) {
        LessonDto lessonDto = LessonUtil.toLessonDto(lessonRepository.getById(lessonId));
        return lessonDto;
    }

    @Override
    public List<LessonDto> allLessonByGroupId(Long groupId, Long courseId) {
        List<LessonDto> lessonDtoList = LessonUtil.toLessonDtoList(lessonRepository.findAllByGroupIdAndCourseId(groupId, courseId));
        return lessonDtoList;
    }
}
