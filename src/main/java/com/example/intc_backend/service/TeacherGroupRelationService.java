package com.example.intc_backend.service;

import com.example.intc_backend.dto.*;
import com.example.intc_backend.model.TeacherGroupRelation;

import java.util.List;

public interface TeacherGroupRelationService {

    void save(TeacherGroupRelationSaveRequestDto teacherGroupRelationSaveRequestDto);

    List<TeacherGroupRelationDto> findAll();

    Boolean find(Long teacherId);

}
