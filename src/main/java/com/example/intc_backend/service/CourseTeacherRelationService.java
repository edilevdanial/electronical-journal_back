package com.example.intc_backend.service;

import com.example.intc_backend.dto.CourseTeacherRelationDto;
import com.example.intc_backend.dto.CourseTeacherRelationSaveDto;

import java.util.List;

public interface CourseTeacherRelationService {

    void save(CourseTeacherRelationSaveDto courseTeacherRelationSaveDto);

    List<CourseTeacherRelationDto> findByCourseId(Long courseId);

    List<CourseTeacherRelationDto> findByTeacherId(Long teacherId);
    List<CourseTeacherRelationDto> findAll();
    void deleteByCourseIdAndTeacherId(Long courseId,Long teacherId);

}
