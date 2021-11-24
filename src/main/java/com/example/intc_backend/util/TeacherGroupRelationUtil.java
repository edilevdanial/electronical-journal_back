package com.example.intc_backend.util;

import com.example.intc_backend.dto.TeacherGroupRelationDto;
import com.example.intc_backend.dto.TeacherGroupRelationSaveRequestDto;
import com.example.intc_backend.dto.UserDto;
import com.example.intc_backend.model.TeacherGroupRelation;
import com.example.intc_backend.model.User;

import java.util.ArrayList;
import java.util.List;

public class TeacherGroupRelationUtil {
    public static TeacherGroupRelationDto toTeacherGroupRelationDto(TeacherGroupRelation teacherGroupRelation){
        if (teacherGroupRelation==null){
            return null;
        }
        TeacherGroupRelationDto teacherRelationGroupDto = new TeacherGroupRelationDto();
        teacherRelationGroupDto.setGroupId(teacherGroupRelation.getGroupId());
        teacherRelationGroupDto.setTeacherId(teacherGroupRelation.getTeacherId());


        return teacherRelationGroupDto;
    }

    public static List<TeacherGroupRelationDto> teacherGroupRelationDtoList(List<TeacherGroupRelation> teacherGroupRelations){
        List<TeacherGroupRelationDto> teacherGroupRelationDtos = new ArrayList<>();
        //TODO ещё раз подумать
//        for(User user_:teacherGroupRelations){
//            userDtos.add(toUserDto(user_));
//        }
        for(int i=0;i<teacherGroupRelations.size();i++){
            teacherGroupRelationDtos.add(i,toTeacherGroupRelationDto(teacherGroupRelations.get(i)));
        }
        return teacherGroupRelationDtos;
    }

    public static TeacherGroupRelation toTeacherGroupRelation(TeacherGroupRelationSaveRequestDto teacherGroupRelationSaveRequestDto){
        if (teacherGroupRelationSaveRequestDto==null){
            return null;
        }
        TeacherGroupRelation teacherGroupRelation = new TeacherGroupRelation();
        teacherGroupRelation.setGroupId(teacherGroupRelationSaveRequestDto.getGroupId());
        teacherGroupRelation.setTeacherId(teacherGroupRelationSaveRequestDto.getTeacherId());


        return teacherGroupRelation;
    }
}
