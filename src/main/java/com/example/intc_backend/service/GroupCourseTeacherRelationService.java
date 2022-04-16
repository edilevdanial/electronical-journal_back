package com.example.intc_backend.service;

import com.example.intc_backend.dto.*;
import com.example.intc_backend.model.GroupCourseTeacherRelation;

import java.util.List;
import java.util.Map;

public interface GroupCourseTeacherRelationService {

    void save(GroupCourseTeacherRelationSaveRequestDto groupCourseTeacherRelationSaveRequestDto);

    List<GroupCourseTeacherRelationDto> findByGroupId(Long groupId);

    List<GroupCourseTeacherRelationForTeacherDto> findAllGroupByTeacherId(Long teacherId);

    void changeTeacherIdInCourse(GroupCourseTeacherRelationDto groupCourseTeacherRelationDto, Long changeNeedTeacherId);

    List<GroupCourseTeacherRelationDto> findAll();

    List<CourseDto> getAllCourseByTeacherId(Long teacherId);

    List<GroupCourseTeacherRelationDto> findFreeCourse(Long groupId);
}
