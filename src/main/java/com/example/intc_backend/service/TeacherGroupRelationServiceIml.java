package com.example.intc_backend.service;

import com.example.intc_backend.dto.GroupDto;
import com.example.intc_backend.dto.TeacherGroupRelationDto;
import com.example.intc_backend.dto.TeacherGroupRelationSaveRequestDto;
import com.example.intc_backend.model.Group;
import com.example.intc_backend.model.TeacherGroupRelation;
import com.example.intc_backend.repository.TeacherGroupRelationRepository;
import com.example.intc_backend.util.TeacherGroupRelationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherGroupRelationServiceIml implements TeacherGroupRelationService{

    @Autowired
    private TeacherGroupRelationRepository teacherGroupRelationRepository;


    @Override
    public void save(TeacherGroupRelationSaveRequestDto teacherGroupRelationSaveRequestDto) {
        TeacherGroupRelation teacherGroupRelation = TeacherGroupRelationUtil.toTeacherGroupRelation(teacherGroupRelationSaveRequestDto);
        teacherGroupRelationRepository.save(teacherGroupRelation);
    }

    @Override
    public List<TeacherGroupRelationDto> findAll() {
        List<TeacherGroupRelationDto> teacherGroupRelationList =
                TeacherGroupRelationUtil.teacherGroupRelationDtoList((List<TeacherGroupRelation>) teacherGroupRelationRepository.findAll());
        return teacherGroupRelationList;
    }

    @Override
    public Boolean find(Long teacherId) {
        TeacherGroupRelationDto teacherGroupRelationDto = new TeacherGroupRelationDto();

        boolean check = teacherGroupRelationRepository.existsById(teacherId);
//        System.out.println("boolean"+check);
        return check;
    }
}
