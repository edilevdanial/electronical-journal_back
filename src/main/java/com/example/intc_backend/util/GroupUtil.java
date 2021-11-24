package com.example.intc_backend.util;

import com.example.intc_backend.dto.GroupDto;
import com.example.intc_backend.dto.GroupSaveRequestDto;
import com.example.intc_backend.model.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupUtil {

    public static GroupDto toGroupDto(Group group){
        if (group==null){
            return null;
        }
        GroupDto groupDto = new GroupDto();
        groupDto.setId(group.getId());
        groupDto.setName(group.getName());
        groupDto.setTeacherId(group.getTeacherId());


        return groupDto;
    }

    public static List<GroupDto> toListGroupDto(List<Group> group){
        List<GroupDto> groupDtoList = new ArrayList<>();
        for (int i =0;i<group.size();i++){
            groupDtoList.add(i,toGroupDto(group.get(i)));
        }

        return  groupDtoList;
    }


    public static Group toGroup(GroupSaveRequestDto groupSaveRequestDto){
        if (groupSaveRequestDto==null){
            return null;
        }
        Group group = new Group();
        group.setName(groupSaveRequestDto.getName());
        group.setTeacherId(groupSaveRequestDto.getTeacherId());


        return group;
    }
}
