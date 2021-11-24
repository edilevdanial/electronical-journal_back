package com.example.intc_backend.service;

import com.example.intc_backend.dto.CourseTeacherRelationDto;
import com.example.intc_backend.dto.CourseTeacherRelationSaveDto;
import com.example.intc_backend.model.Course;
import com.example.intc_backend.model.CourseTeacherId;
import com.example.intc_backend.model.CourseTeacherRelation;
import com.example.intc_backend.repository.CourseTeacherRelationRepository;
import com.example.intc_backend.util.CourseTeacherRelationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseTeacherRelationServiceIml implements CourseTeacherRelationService {

    @Autowired
    private CourseTeacherRelationRepository courseTeacherRelationRepository;

    @Override
    public void save(CourseTeacherRelationSaveDto courseTeacherRelationSaveDto) {

        courseTeacherRelationRepository.save(CourseTeacherRelationUtil.toCourseRelation(courseTeacherRelationSaveDto));
    }

    @Override
    public List<CourseTeacherRelationDto> findByCourseId(Long courseId) {
        List<CourseTeacherRelationDto> courseTeacherRelationDto =CourseTeacherRelationUtil.toTeacherRelationDtoList(courseTeacherRelationRepository.findByCourseId(courseId));

        return courseTeacherRelationDto;
    }

    @Override
    public List<CourseTeacherRelationDto> findByTeacherId(Long teacherId) {
        List<CourseTeacherRelationDto> courseTeacherRelationDto =CourseTeacherRelationUtil.toTeacherRelationDtoList(courseTeacherRelationRepository.findByTeacherId(teacherId));

        return courseTeacherRelationDto;
    }

    @Override
    public List<CourseTeacherRelationDto> findAll() {
        List<CourseTeacherRelationDto> courseTeacherRelationDto =CourseTeacherRelationUtil.toTeacherRelationDtoList(courseTeacherRelationRepository.findAll());

        return courseTeacherRelationDto;
    }

    @Override
    public void deleteByCourseIdAndTeacherId(Long courseId, Long teacherId) {
        CourseTeacherId courseTeacherId = new CourseTeacherId(courseId,teacherId);
        courseTeacherRelationRepository.deleteById(courseTeacherId);
    }
//    @Override
//    public List<CourseTeacherRelationDto> findAllById() {
//        List<CourseTeacherRelationDto> courseTeacherRelationDto =CourseTeacherRelationUtil.toTeacherRelationDtoList(courseTeacherRelationRepository.findAllById(co));
//
//        return courseTeacherRelationDto;
//    }
}
