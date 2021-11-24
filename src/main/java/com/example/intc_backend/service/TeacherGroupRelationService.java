package com.example.intc_backend.service;

import com.example.intc_backend.dto.TeacherGroupRelationDto;
import com.example.intc_backend.dto.TeacherGroupRelationSaveRequestDto;
import com.example.intc_backend.dto.UserDto;
import com.example.intc_backend.dto.UserSaveRequestDto;
import com.example.intc_backend.model.TeacherGroupRelation;

import java.util.List;

public interface TeacherGroupRelationService {

    void save(TeacherGroupRelationSaveRequestDto teacherGroupRelationSaveRequestDto);

    List<TeacherGroupRelationDto> findAll();

    Boolean find(Long teacherId);
}
