package com.example.intc_backend.service;

import com.example.intc_backend.dto.CourseTeacherRelationDto;
import com.example.intc_backend.dto.CourseTeacherRelationSaveDto;
import com.example.intc_backend.dto.GroupCourseTeacherRelationDto;
import com.example.intc_backend.dto.UserDto;
import com.example.intc_backend.model.CourseTeacherRelation;

import java.util.List;

public interface CourseTeacherRelationService {

    void save(CourseTeacherRelationSaveDto courseTeacherRelationSaveDto);

    void save(CourseTeacherRelationDto courseTeacherRelationDto);

    List<CourseTeacherRelationDto> findByCourseId(Long courseId);

    List<CourseTeacherRelationDto> findByTeacherId(Long teacherId);

    List<CourseTeacherRelationDto> findAll();

    List<UserDto> findAllWithName();

    List<UserDto> findTeacherByCourse(Long courseId);

    void deleteByCourseIdAndTeacherId(Long courseId, Long teacherId);

    CourseTeacherRelationDto findByCourseIdAndTeacherId(Long courseId, Long teacherId);

}
