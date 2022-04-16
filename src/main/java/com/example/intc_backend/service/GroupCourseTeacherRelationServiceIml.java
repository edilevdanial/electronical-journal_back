package com.example.intc_backend.service;

import com.example.intc_backend.dto.*;
import com.example.intc_backend.model.GroupCourseTeacherRelation;
import com.example.intc_backend.repository.GroupCourseTeacherRelationRepository;
import com.example.intc_backend.util.GroupCourseTeacherRelationUtil;
import com.example.intc_backend.util.TeacherGroupRelationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GroupCourseTeacherRelationServiceIml implements GroupCourseTeacherRelationService {

    @Autowired
    private GroupCourseTeacherRelationRepository groupCourseTeacherRelationRepository;
    @Autowired
    private GroupService groupService;
    @Autowired
    private CourseService courseService;


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
    public List<GroupCourseTeacherRelationForTeacherDto> findAllGroupByTeacherId(Long teacherId) {
        List<GroupCourseTeacherRelationDto> groupCourseTeacherRelationDtoList = GroupCourseTeacherRelationUtil.toGroupCourseTeacherRelationDtoList(groupCourseTeacherRelationRepository.getGroupCourseTeacherRelationByTeacherId(teacherId));
        Map<Long, List<CourseDto>> groupCourseTeacherRelationForTeacherDto = new HashMap<>();
        for (GroupCourseTeacherRelationDto groupCourseTeacherRelationDto : groupCourseTeacherRelationDtoList) {
            if (!groupCourseTeacherRelationForTeacherDto.containsKey(groupService.findById(groupCourseTeacherRelationDto.getGroupId()).getId())) {
                groupCourseTeacherRelationForTeacherDto.put(groupService.findById(groupCourseTeacherRelationDto.getGroupId()).getId(), new ArrayList<CourseDto>());
            }
            groupCourseTeacherRelationForTeacherDto.get(groupService.findById(groupCourseTeacherRelationDto.getGroupId()).getId()).add(courseService.findById(groupCourseTeacherRelationDto.getCourseId()));
        }
        List<GroupCourseTeacherRelationForTeacherDto> groupCourseTeacherRelationForTeacherDtoList = new ArrayList<>();
        for (Map.Entry<Long, List<CourseDto>> item : groupCourseTeacherRelationForTeacherDto.entrySet()) {
            GroupCourseTeacherRelationForTeacherDto teacherDto = new GroupCourseTeacherRelationForTeacherDto();
            teacherDto.setCourse(item.getValue());
            teacherDto.setGroup(groupService.findById(item.getKey()));
            groupCourseTeacherRelationForTeacherDtoList.add(teacherDto);
        }
        return groupCourseTeacherRelationForTeacherDtoList;
    }

    @Override
    public List<GroupCourseTeacherRelationDto> findFreeCourse(Long groupId) {
//        return GroupCourseTeacherRelationUtil.toGroupCourseTeacherRelationDtoList(groupCourseTeacherRelationRepository.findAllByCourseIdNotInAndGroupId(groupId));
        return null;
    }

    @Override
    public List<CourseDto> getAllCourseByTeacherId(Long teacherId) {
        List<GroupCourseTeacherRelationDto> groupCourseTeacherRelationDtoList = GroupCourseTeacherRelationUtil.toGroupCourseTeacherRelationDtoList(groupCourseTeacherRelationRepository.getGroupCourseTeacherRelationByTeacherId(teacherId));
        Map<Long, CourseDto> courseDtoList = new HashMap<>();
        for (GroupCourseTeacherRelationDto groupCourseTeacherRelationDto : groupCourseTeacherRelationDtoList) {
            if (!courseDtoList.containsKey(groupCourseTeacherRelationDto.getCourseId())) {
                courseDtoList.put(groupCourseTeacherRelationDto.getCourseId(), courseService.findById(groupCourseTeacherRelationDto.getCourseId()));
            }
        }
        List<CourseDto> courseDtoListArray = new ArrayList<>();
        for (Map.Entry<Long, CourseDto> item : courseDtoList.entrySet()) {
            courseDtoListArray.add(item.getValue());
        }
            return courseDtoListArray;
    }
}
