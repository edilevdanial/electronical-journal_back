package com.example.intc_backend.service;

import com.example.intc_backend.dto.GroupCourseTeacherRelationDto;
import com.example.intc_backend.dto.GroupCourseTeacherRelationSaveRequestDto;
import com.example.intc_backend.dto.GroupDto;
import com.example.intc_backend.model.GroupCourseTeacherRelation;

import java.util.List;

public interface GroupCourseTeacherRelationService {

    void save(GroupCourseTeacherRelationSaveRequestDto groupCourseTeacherRelationSaveRequestDto);

    List<GroupCourseTeacherRelationDto> findByGroupId(Long groupId);

    List<GroupDto> findAllGroupByTeacherId(Long teacherId);

    void changeTeacherIdInCourse(GroupCourseTeacherRelationDto groupCourseTeacherRelationDto, Long changeNeedTeacherId);

    List<GroupCourseTeacherRelationDto> findAll();
}
