package com.example.intc_backend.service;

import com.example.intc_backend.dto.CourseTeacherRelationDto;
import com.example.intc_backend.dto.CourseTeacherRelationSaveDto;
import com.example.intc_backend.dto.GroupCourseTeacherRelationDto;
import com.example.intc_backend.dto.UserDto;
import com.example.intc_backend.model.Course;
import com.example.intc_backend.model.CourseTeacherId;
import com.example.intc_backend.model.CourseTeacherRelation;
import com.example.intc_backend.model.GroupCourseTeacherRelation;
import com.example.intc_backend.repository.CourseTeacherRelationRepository;
import com.example.intc_backend.util.CourseTeacherRelationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseTeacherRelationServiceIml implements CourseTeacherRelationService {

    @Autowired
    private CourseTeacherRelationRepository courseTeacherRelationRepository;
    @Autowired
    private UserService userService;

    @Override
    public void save(CourseTeacherRelationSaveDto courseTeacherRelationSaveDto) {

        courseTeacherRelationRepository.save(CourseTeacherRelationUtil.toCourseRelation(courseTeacherRelationSaveDto));
    }

    @Override
    public List<UserDto> findTeacherByCourse(Long courseId) {
        List<CourseTeacherRelationDto> courseTeacherRelationDto = CourseTeacherRelationUtil.toTeacherRelationDtoList(courseTeacherRelationRepository.findByCourseId(courseId));
        List<UserDto> teacherList = new ArrayList<>();
        for (CourseTeacherRelationDto courseTeacherRelationDto1:courseTeacherRelationDto){
            teacherList.add(userService.find(courseTeacherRelationDto1.getTeacherId()));
        }
        return teacherList;
    }

    @Override
    public List<UserDto> findAllWithName() {
        List<UserDto> courseTeacherRelationDto = userService.findUserByType("TEACHER");
//        List<UserDto> userDtoList = new ArrayList<>();
//        for (CourseTeacherRelationDto courseTeacherRelationDto1:courseTeacherRelationDto){
//            userDtoList.add(userService.find(courseTeacherRelationDto1.getTeacherId()));
//        }
        return courseTeacherRelationDto;
    }

    @Override
    public List<CourseTeacherRelationDto> findByCourseId(Long courseId) {
        List<CourseTeacherRelationDto> courseTeacherRelationDto = CourseTeacherRelationUtil.toTeacherRelationDtoList(courseTeacherRelationRepository.findByCourseId(courseId));

        return courseTeacherRelationDto;
    }

    @Override
    public List<CourseTeacherRelationDto> findByTeacherId(Long teacherId) {
        List<CourseTeacherRelationDto> courseTeacherRelationDto = CourseTeacherRelationUtil.toTeacherRelationDtoList(courseTeacherRelationRepository.findByTeacherId(teacherId));

        return courseTeacherRelationDto;
    }

    @Override
    public List<CourseTeacherRelationDto> findAll() {
        List<CourseTeacherRelationDto> courseTeacherRelationDto = CourseTeacherRelationUtil.toTeacherRelationDtoList(courseTeacherRelationRepository.findAll());
        

        return courseTeacherRelationDto;
    }

    @Override
    public void deleteByCourseIdAndTeacherId(Long courseId, Long teacherId) {
        CourseTeacherId courseTeacherId = new CourseTeacherId(courseId, teacherId);
        courseTeacherRelationRepository.deleteById(courseTeacherId);
    }

    @Override
    public void save(CourseTeacherRelationDto courseTeacherRelationDto) {
        courseTeacherRelationRepository.save(CourseTeacherRelationUtil.toCourseRelation(courseTeacherRelationDto));

    }

    @Override
    public CourseTeacherRelationDto findByCourseIdAndTeacherId(Long courseId, Long teacherId) {
        CourseTeacherRelationDto courseTeacherRelationDto = CourseTeacherRelationUtil.toCourseRelationDto(courseTeacherRelationRepository.findByCourseIdAndTeacherId(courseId, teacherId));

        return courseTeacherRelationDto;
    }
//    @Override
//    public List<CourseTeacherRelationDto> findAllById() {
//        List<CourseTeacherRelationDto> courseTeacherRelationDto =CourseTeacherRelationUtil.toTeacherRelationDtoList(courseTeacherRelationRepository.findAllById(co));
//
//        return courseTeacherRelationDto;
//    }
}
