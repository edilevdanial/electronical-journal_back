package com.example.intc_backend.util;

import com.example.intc_backend.dto.GroupCourseTeacherRelationDto;
import com.example.intc_backend.dto.GroupCourseTeacherRelationSaveRequestDto;
import com.example.intc_backend.model.GroupCourseTeacherRelation;

import java.util.ArrayList;
import java.util.List;

public class GroupCourseTeacherRelationUtil {

    public static GroupCourseTeacherRelation toGroupCourseTeacherRelation(GroupCourseTeacherRelationSaveRequestDto groupCourseTeacherRelationSaveRequestDto) {
        GroupCourseTeacherRelation groupCourseTeacherRelation = new GroupCourseTeacherRelation();

        groupCourseTeacherRelation.setGroupId(groupCourseTeacherRelationSaveRequestDto.getGroupId());
        groupCourseTeacherRelation.setCourseId(groupCourseTeacherRelationSaveRequestDto.getCourseId());
        groupCourseTeacherRelation.setTeacherId(groupCourseTeacherRelationSaveRequestDto.getTeacherId());
        return groupCourseTeacherRelation;
    }

    public static GroupCourseTeacherRelation toGroupCourseTeacherRelation(GroupCourseTeacherRelationDto groupCourseTeacherRelationDto) {
        GroupCourseTeacherRelation groupCourseTeacherRelation = new GroupCourseTeacherRelation();

        groupCourseTeacherRelation.setGroupId(groupCourseTeacherRelationDto.getGroupId());
        groupCourseTeacherRelation.setCourseId(groupCourseTeacherRelationDto.getCourseId());
        groupCourseTeacherRelation.setTeacherId(groupCourseTeacherRelationDto.getTeacherId());
        return groupCourseTeacherRelation;
    }

    public static GroupCourseTeacherRelationDto toGroupCourseTeacherRelationDto(GroupCourseTeacherRelation groupCourseTeacherRelation) {
        GroupCourseTeacherRelationDto groupCourseTeacherRelationDto = new GroupCourseTeacherRelationDto();

        groupCourseTeacherRelationDto.setGroupId(groupCourseTeacherRelation.getGroupId());
        groupCourseTeacherRelationDto.setCourseId(groupCourseTeacherRelation.getCourseId());
        groupCourseTeacherRelationDto.setTeacherId(groupCourseTeacherRelation.getTeacherId());
        return groupCourseTeacherRelationDto;
    }

    public static List<GroupCourseTeacherRelationDto> toGroupCourseTeacherRelationDtoList(List<GroupCourseTeacherRelation> groupCourseTeacherRelationList) {
        List<GroupCourseTeacherRelationDto> groupCourseTeacherRelationDtoList = new ArrayList<>();

        for (GroupCourseTeacherRelation groupCourseTeacherRelation : groupCourseTeacherRelationList) {
            groupCourseTeacherRelationDtoList.add(toGroupCourseTeacherRelationDto(groupCourseTeacherRelation));
        }
        return groupCourseTeacherRelationDtoList;
    }
}
