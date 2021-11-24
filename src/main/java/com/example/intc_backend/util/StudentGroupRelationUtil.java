package com.example.intc_backend.util;

import com.example.intc_backend.dto.StudentGroupRelationDto;
import com.example.intc_backend.dto.StudentGroupRelationRequestSaveDto;
import com.example.intc_backend.dto.TeacherGroupRelationDto;
import com.example.intc_backend.model.StudentGroupRelation;

import java.util.ArrayList;
import java.util.List;

public class StudentGroupRelationUtil {

    public static StudentGroupRelationDto toStudentGroupRelationDto(StudentGroupRelation studentGroupRelation){
        if (studentGroupRelation==null){
            return null;
        }
        StudentGroupRelationDto studentGroupRelationDto = new StudentGroupRelationDto();
        studentGroupRelationDto.setGroupId(studentGroupRelation.getGroupId());
        studentGroupRelationDto.setStudentId(studentGroupRelation.getStudentId());


        return studentGroupRelationDto;
    }

    public static StudentGroupRelation toStudentGroupRelation(StudentGroupRelationRequestSaveDto studentGroupRelationRequestSaveDto){
        if (studentGroupRelationRequestSaveDto==null){
            return null;
        }
        StudentGroupRelation studentGroupRelation = new StudentGroupRelation();
        studentGroupRelation.setGroupId(studentGroupRelationRequestSaveDto.getGroupId());
        studentGroupRelation.setStudentId(studentGroupRelationRequestSaveDto.getStudentId());


        return studentGroupRelation;
    }
    public static StudentGroupRelation toStudentGroupRelation(StudentGroupRelationDto studentGroupRelationDto){
        if (studentGroupRelationDto==null){
            return null;
        }
        StudentGroupRelation studentGroupRelation = new StudentGroupRelation();
        studentGroupRelation.setGroupId(studentGroupRelationDto.getGroupId());
        studentGroupRelation.setStudentId(studentGroupRelationDto.getStudentId());


        return studentGroupRelation;
    }

    public static List<StudentGroupRelationDto> toStudentGroupRelationDtoList(List<StudentGroupRelation> studentGroupRelationList ){
        List<StudentGroupRelationDto> studentGroupRelationDtoList = new ArrayList<>();
        //TODO ещё раз подумать
//        for(User user_:teacherGroupRelations){
//            userDtos.add(toUserDto(user_));
//        }
        for(int i=0;i<studentGroupRelationList.size();i++){
            studentGroupRelationDtoList.add(i,toStudentGroupRelationDto(studentGroupRelationList.get(i)));
        }
        return studentGroupRelationDtoList;
    }

    public static List<StudentGroupRelation> toStudentGroupRelationList(StudentGroupRelationRequestSaveDto[] studentGroupRelationRequestSaveDtoList ){
        List<StudentGroupRelation> studentGroupRelationDtoList = new ArrayList<>();
        //TODO ещё раз подумать
//        for(User user_:teacherGroupRelations){
//            userDtos.add(toUserDto(user_));
//        }
//        System.out.println(studentGroupRelationRequestSaveDtoList[0].getGroupId());
        for(int i=0;i<studentGroupRelationRequestSaveDtoList.length;i++){
            studentGroupRelationDtoList.add(i,toStudentGroupRelation(studentGroupRelationRequestSaveDtoList[i]));
        }
        return studentGroupRelationDtoList;
    }
    public static List<StudentGroupRelation> toStudentGroupRelationList(StudentGroupRelationDto[] studentGroupRelationRequestSaveDtoList ){
        List<StudentGroupRelation> studentGroupRelationDtoList = new ArrayList<>();
        //TODO ещё раз подумать
//        for(User user_:teacherGroupRelations){
//            userDtos.add(toUserDto(user_));
//        }
//        System.out.println(studentGroupRelationRequestSaveDtoList[0].getGroupId());
        for(int i=0;i<studentGroupRelationRequestSaveDtoList.length;i++){
            studentGroupRelationDtoList.add(i,toStudentGroupRelation(studentGroupRelationRequestSaveDtoList[i]));
        }
        return studentGroupRelationDtoList;
    }
}
