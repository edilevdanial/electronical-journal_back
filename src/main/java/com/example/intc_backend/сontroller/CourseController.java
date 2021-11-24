package com.example.intc_backend.сontroller;

import com.example.intc_backend.dto.*;
import com.example.intc_backend.repository.CourseTeacherRelationRepository;
import com.example.intc_backend.service.CourseService;
import com.example.intc_backend.service.CourseTeacherRelationService;
import com.example.intc_backend.util.CourseFullDataUtil;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    private final CourseService courseService;
    private final CourseTeacherRelationService courseTeacherRelationService;

    public CourseController(CourseService courseService,CourseTeacherRelationService courseTeacherRelationService) {
        this.courseService = courseService;
        this.courseTeacherRelationService = courseTeacherRelationService;
    }
    
    @PostMapping(value = "/create/course")
    public ResponseEntity<?> createCourse(@RequestParam(name = "name")String name,@RequestParam(name = "teacherId")Long teacherId) {
        CourseSaveRequestDto courseSaveRequestDto = new CourseSaveRequestDto();
        courseSaveRequestDto.setName(name);
        courseService.save(courseSaveRequestDto);
        CourseDto courseDto = courseService.findByName(name);
        saveToCourseTeacherRelation(teacherId, courseDto.getId());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/connect/course")
    public ResponseEntity<?> connectCourse(@RequestParam(name = "courseId")Long courseId,@RequestParam(name = "teacherId")Long teacherId) {
        CourseTeacherRelationSaveDto courseTeacherRelationSaveDto = new CourseTeacherRelationSaveDto();
        courseTeacherRelationSaveDto.setTeacherId(teacherId);
        courseTeacherRelationSaveDto.setCourseId(courseId);
        courseTeacherRelationService.save(courseTeacherRelationSaveDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/not-connect/course")
    public ResponseEntity<?> notConnectCourse(@RequestParam(name = "courseId")Long courseId,@RequestParam(name = "teacherId")Long teacherId) {
        courseTeacherRelationService.deleteByCourseIdAndTeacherId(courseId,teacherId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/all/teacher")
    public ResponseEntity<List<CourseTeacherRelationDto>> getAllTeacher() {
        List<CourseTeacherRelationDto> courseTeacherRelationDtoList = courseTeacherRelationService.findAll();

        return ResponseEntity.ok(courseTeacherRelationDtoList);
    }

    @GetMapping(value = "/all/course")
    public ResponseEntity<List<CourseFullDataDto>> getFullObject() {
        List<CourseTeacherRelationDto> courseTeacherRelationDtoList = courseTeacherRelationService.findAll();
        List<CourseDto> courseDtoList = courseService.findAll();
        List<CourseFullDataDto> courseFullDataDto = CourseFullDataUtil.toCourseFullDataUtilList(courseDtoList,courseTeacherRelationDtoList);

        return ResponseEntity.ok(courseFullDataDto);
    }


    public void saveToCourseTeacherRelation(Long teacherId,Long courseId){
        CourseTeacherRelationSaveDto courseTeacherRelationSaveDto = new CourseTeacherRelationSaveDto();
        courseTeacherRelationSaveDto.setCourseId(courseId);
        courseTeacherRelationSaveDto.setTeacherId(teacherId);
        courseTeacherRelationService.save(courseTeacherRelationSaveDto);

    }
}
