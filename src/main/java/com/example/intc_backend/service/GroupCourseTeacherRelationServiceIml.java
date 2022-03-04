package com.example.intc_backend.service;

import com.example.intc_backend.dto.GroupCourseTeacherRelationDto;
import com.example.intc_backend.dto.GroupCourseTeacherRelationSaveRequestDto;
import com.example.intc_backend.dto.GroupDto;
import com.example.intc_backend.dto.TeacherGroupRelationDto;
import com.example.intc_backend.model.GroupCourseTeacherRelation;
import com.example.intc_backend.repository.GroupCourseTeacherRelationRepository;
import com.example.intc_backend.util.GroupCourseTeacherRelationUtil;
import com.example.intc_backend.util.TeacherGroupRelationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupCourseTeacherRelationServiceIml implements GroupCourseTeacherRelationService{

    @Autowired
    private GroupCourseTeacherRelationRepository groupCourseTeacherRelationRepository;
    @Autowired
    private GroupService groupService;


    @Override
    public List<GroupCourseTeacherRelationDto> findAll() {
        List<GroupCourseTeacherRelationDto> groupCourseTeacherRelationDtoList = GroupCourseTeacherRelationUtil.toGroupCourseTeacherRelationDtoList(groupCourseTeacherRelationRepository.findAll());

        return groupCourseTeacherRelationDtoList;
    }


    @Override
    public void save(GroupCourseTeacherRelationSaveRequestDto groupCourseTeacherRelationSaveRequestDto) {
        groupCourseTeacherRelationRepository.save(GroupCourseTeacherRelationUtil.toGroupCourseTeacherRelation(groupCourseTeacherRelationSaveRequestDto));
    }

    @Override
    public List<GroupCourseTeacherRelationDto> findByGroupId(Long groupId) {
        List<GroupCourseTeacherRelationDto> groupCourseTeacherRelationDtoList = GroupCourseTeacherRelationUtil.toGroupCourseTeacherRelationDtoList(groupCourseTeacherRelationRepository.getGroupCourseTeacherRelationByGroupId(groupId));

        return groupCourseTeacherRelationDtoList;
    }

    @Override
    public void changeTeacherIdInCourse(GroupCourseTeacherRelationDto groupCourseTeacherRelationDto, Long changeNeedTeacherId) {
        groupCourseTeacherRelationDto.setTeacherId(changeNeedTeacherId);
        groupCourseTeacherRelationRepository.save(GroupCourseTeacherRelationUtil.toGroupCourseTeacherRelation(groupCourseTeacherRelationDto));
    }
    @Override
    public List<GroupDto> findAllGroupByTeacherId(Long teacherId){
        List<GroupCourseTeacherRelationDto> groupCourseTeacherRelationDtoList = GroupCourseTeacherRelationUtil.toGroupCourseTeacherRelationDtoList(groupCourseTeacherRelationRepository.getGroupCourseTeacherRelationByTeacherId(teacherId));
        List<GroupDto> groupDtoList = new ArrayList<>();
        for(GroupCourseTeacherRelationDto groupCourseTeacherRelationDto: groupCourseTeacherRelationDtoList){
            groupDtoList.add(groupService.findById(groupCourseTeacherRelationDto.getGroupId()));
        }
        return groupDtoList;
    }
}
