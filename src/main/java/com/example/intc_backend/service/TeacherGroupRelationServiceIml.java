package com.example.intc_backend.service;

import com.example.intc_backend.dto.*;
import com.example.intc_backend.model.Group;
import com.example.intc_backend.model.TeacherGroupRelation;
import com.example.intc_backend.repository.TeacherGroupRelationRepository;
import com.example.intc_backend.util.GroupUtil;
import com.example.intc_backend.util.TeacherGroupRelationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherGroupRelationServiceIml implements TeacherGroupRelationService {

    @Autowired
    private TeacherGroupRelationRepository teacherGroupRelationRepository;
    @Autowired
    private GroupService groupService;
    @Autowired
    private StudentGroupClient client;
    @Autowired
    private UserService userService;


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
    public CuratorGroup find(Long teacherId) {
        TeacherGroupRelationDto teacherGroupRelationDto= TeacherGroupRelationUtil.toTeacherGroupRelationDto(teacherGroupRelationRepository.findByTeacherId(teacherId));
        List<StudentGroupRelationDto> studentGroupRelationDtoList = client.findStudentIdByGroupId(teacherGroupRelationDto.getGroupId());
        CuratorGroup curatorGroup = new CuratorGroup();
        List<UserDto> userDtoList = new ArrayList<>();
        curatorGroup.setGroup(groupService.findById(teacherGroupRelationDto.getGroupId()));
        for(StudentGroupRelationDto studentGroupRelationDto: studentGroupRelationDtoList){
            userDtoList.add(userService.find(studentGroupRelationDto.getStudentId()));
        }
        curatorGroup.setStudents(userDtoList);
        return curatorGroup;
    }
}
