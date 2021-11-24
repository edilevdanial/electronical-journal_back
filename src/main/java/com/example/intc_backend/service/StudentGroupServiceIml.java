package com.example.intc_backend.service;

import com.example.intc_backend.dto.StudentGroupRelationDto;
import com.example.intc_backend.dto.StudentGroupRelationRequestSaveDto;
import com.example.intc_backend.model.StudentGroupRelation;
import com.example.intc_backend.repository.StudentGroupRepository;
import com.example.intc_backend.util.StudentGroupRelationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentGroupServiceIml implements StudentGroupClient{

    @Autowired
    private StudentGroupRepository studentGroupRepository;

    @Override
    public void save(StudentGroupRelationRequestSaveDto studentGroupRelationRequestSaveDto) {
        StudentGroupRelation studentGroupRelation = StudentGroupRelationUtil.toStudentGroupRelation(studentGroupRelationRequestSaveDto);

        studentGroupRepository.save(studentGroupRelation);
    }

    @Override
    public void saveArray(StudentGroupRelationRequestSaveDto[] studentGroupRelationRequestSaveDtoList) {
        List<StudentGroupRelation> studentGroupRelation = StudentGroupRelationUtil.toStudentGroupRelationList(studentGroupRelationRequestSaveDtoList);
        studentGroupRepository.saveAll(studentGroupRelation);
    }

    @Override
    public List<StudentGroupRelationDto> findStudentIdByGroupId(Long groupId) {
        List<StudentGroupRelationDto> studenIdList = StudentGroupRelationUtil.toStudentGroupRelationDtoList(studentGroupRepository.findStudentIdByGroupId(groupId));

        return studenIdList;
    }

    @Override
    public List<StudentGroupRelationDto> findByGroupId(Long groupId) {
        List<StudentGroupRelationDto> studentGroupRelationDtoList = StudentGroupRelationUtil.toStudentGroupRelationDtoList(studentGroupRepository.findByGroupId(groupId));

        return studentGroupRelationDtoList;
    }

    @Override
    public StudentGroupRelationDto findByStudentId(Long studentId) {
        StudentGroupRelationDto studentGroupRelationDto = StudentGroupRelationUtil.toStudentGroupRelationDto(studentGroupRepository.findByStudentId(studentId));

        return studentGroupRelationDto;
    }

    @Override
    public void delete(Long id) {
        studentGroupRepository.deleteById(id);
    }
}
