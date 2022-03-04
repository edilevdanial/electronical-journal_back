package com.example.intc_backend.сontroller;

import com.example.intc_backend.dto.*;
import com.example.intc_backend.service.CourseService;
import com.example.intc_backend.service.CourseTeacherRelationService;
import com.example.intc_backend.util.CourseFullDataUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    private final CourseService courseService;
    private final CourseTeacherRelationService courseTeacherRelationService;

    public CourseController(CourseService courseService, CourseTeacherRelationService courseTeacherRelationService) {
        this.courseService = courseService;
        this.courseTeacherRelationService = courseTeacherRelationService;
    }

    @PostMapping(value = "course/create")
    public ResponseEntity<?> createCourse(@RequestParam(name = "name") String name, @RequestParam(name = "teacherId") Long teacherId) {
        CourseSaveRequestDto courseSaveRequestDto = new CourseSaveRequestDto();
        courseSaveRequestDto.setName(name);
        courseService.save(courseSaveRequestDto);
        CourseDto courseDto = courseService.findByName(name);
        saveToCourseTeacherRelation(teacherId, courseDto.getId());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "course/connect/course")
    public ResponseEntity<?> connectCourse(@RequestParam(name = "courseId") Long courseId, @RequestParam(name = "teacherId") Long teacherId) {
        CourseTeacherRelationSaveDto courseTeacherRelationSaveDto = new CourseTeacherRelationSaveDto();
        courseTeacherRelationSaveDto.setTeacherId(teacherId);
        courseTeacherRelationSaveDto.setCourseId(courseId);
        courseTeacherRelationService.save(courseTeacherRelationSaveDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "course/not-connect/course")
    public ResponseEntity<?> notConnectCourse(@RequestParam(name = "courseId") Long courseId, @RequestParam(name = "teacherId") Long teacherId) {
        courseTeacherRelationService.deleteByCourseIdAndTeacherId(courseId, teacherId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "course/all/teacher")
    public ResponseEntity<List<UserDto>> getAllTeacher() {
        List<UserDto> userDtoList = courseTeacherRelationService.findAllWithName();

        return ResponseEntity.ok(userDtoList);
    }

    @GetMapping(value = "course/teacher")
    public ResponseEntity<List<UserDto>> getCourseTeacher(@RequestParam(name = "courseId") Long courseId) {
        List<UserDto> userDtoList = courseTeacherRelationService.findTeacherByCourse(courseId);

        return ResponseEntity.ok(userDtoList);
    }

    @GetMapping(value = "/course/all")
    public ResponseEntity<List<CourseFullDataDto>> getFullObject() {
        List<CourseTeacherRelationDto> courseTeacherRelationDtoList = courseTeacherRelationService.findAll();
        List<CourseDto> courseDtoList = courseService.findAll();
        List<CourseFullDataDto> courseFullDataDto = CourseFullDataUtil.toCourseFullDataUtilList(courseDtoList, courseTeacherRelationDtoList);

        return ResponseEntity.ok(courseFullDataDto);
    }

    @PostMapping(value = "course/update")
    public ResponseEntity<?> updateCourse(@RequestParam(name = "courseId") Long courseId, @RequestParam(name = "courseName") String courseName, @RequestParam(name = "upDateTeacherId") Long upDateTeacherId, @RequestParam(name = "teacherId") Long teacherId) {
        CourseDto courseDto = courseService.findById(courseId);
        if (courseName != null) {
            courseDto.setName(courseName);
        }
        if (teacherId != null) {
            CourseTeacherRelationDto courseTeacherRelationDto = courseTeacherRelationService.findByCourseIdAndTeacherId(courseId, upDateTeacherId);
            courseTeacherRelationDto.setTeacherId(teacherId);
            courseTeacherRelationService.save(courseTeacherRelationDto);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    public void saveToCourseTeacherRelation(Long teacherId, Long courseId) {
        CourseTeacherRelationSaveDto courseTeacherRelationSaveDto = new CourseTeacherRelationSaveDto();
        courseTeacherRelationSaveDto.setCourseId(courseId);
        courseTeacherRelationSaveDto.setTeacherId(teacherId);
        courseTeacherRelationService.save(courseTeacherRelationSaveDto);
    }

}
