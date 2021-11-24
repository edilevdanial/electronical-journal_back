package com.example.intc_backend.service;

import com.example.intc_backend.dto.StudentGroupRelationDto;
import com.example.intc_backend.dto.StudentGroupRelationRequestSaveDto;
import com.example.intc_backend.model.StudentGroupRelation;
import com.example.intc_backend.model.User;

import java.util.List;

public interface StudentGroupClient {

    void save(StudentGroupRelationRequestSaveDto studentGroupRelationRequestSaveDto);
    void saveArray(StudentGroupRelationRequestSaveDto[] studentGroupRelationRequestSaveDtoList);

    List<StudentGroupRelationDto> findByGroupId(Long groupId);
    StudentGroupRelationDto findByStudentId(Long studentId);
    List<StudentGroupRelationDto> findStudentIdByGroupId(Long groupId);

//    User read(Long id);

//    boolean updatePhoneNumber(User user,Long id,String phone_number);

    void delete(Long id);
}
