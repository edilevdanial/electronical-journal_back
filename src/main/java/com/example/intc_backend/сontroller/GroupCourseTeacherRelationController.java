package com.example.intc_backend.сontroller;

import com.example.intc_backend.dto.*;
import com.example.intc_backend.model.GroupCourseTeacherRelation;
import com.example.intc_backend.service.CourseService;
import com.example.intc_backend.service.GroupCourseTeacherRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class GroupCourseTeacherRelationController {

    private final GroupCourseTeacherRelationService groupCourseTeacherRelationService;
    private final CourseService courseService;

    @Autowired
    public GroupCourseTeacherRelationController(GroupCourseTeacherRelationService groupCourseTeacherRelationService, CourseService courseService) {
        this.groupCourseTeacherRelationService = groupCourseTeacherRelationService;
        this.courseService = courseService;
    }

    @PostMapping(value = "/group-course")
    public ResponseEntity<List<GroupCourseTeacherRelationDto>> findAllCourses(@RequestBody GroupCourseTeacherRelationSaveRequestDto groupCourseTeacherRelationSaveRequestDto) {
        groupCourseTeacherRelationService.save(groupCourseTeacherRelationSaveRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/group-course/{id}")
    public ResponseEntity<List<CourseDto>> findAllCourses(@PathVariable(name = "id") Long groupId) {
        List<GroupCourseTeacherRelationDto> groupCourseTeacherRelationDtoList = groupCourseTeacherRelationService.findByGroupId(groupId);
        List<CourseDto> courseDtoList = new ArrayList<>();
        for (GroupCourseTeacherRelationDto groupCourseTeacherRelationDto : groupCourseTeacherRelationDtoList) {
            courseDtoList.add(courseService.findById(groupCourseTeacherRelationDto.getCourseId()));
        }
        return ResponseEntity.ok(courseDtoList);
    }

    @GetMapping(value = "/get-all-groups-teacher/{id}")
    public ResponseEntity<List<GroupCourseTeacherRelationForTeacherDto>> getAllGroupsByTeacherId(@PathVariable(name = "id") Long teacherId) {
        List<GroupCourseTeacherRelationForTeacherDto> groupCourseTeacherRelationForTeacherDtoList = groupCourseTeacherRelationService.findAllGroupByTeacherId(teacherId);
        return ResponseEntity.ok(groupCourseTeacherRelationForTeacherDtoList);
    }


    @GetMapping(value = "/get-all-course-teacher/{id}")
    public ResponseEntity<List<CourseDto>> getAllCoursesByTeacherId(@PathVariable(name = "id") Long teacherId) {
        List<CourseDto> groupCourseTeacherRelationDtoList = groupCourseTeacherRelationService.getAllCourseByTeacherId(teacherId);
        return ResponseEntity.ok(groupCourseTeacherRelationDtoList);
    }


//    @GetMapping(value = "/get-free-course/{groupId}")
//    public ResponseEntity<List<GroupCourseTeacherRelationDto>> getAllFreeCourse(@PathVariable(name = "groupId") Long groupId) {
//        List<GroupCourseTeacherRelationDto> groupCourseTeacherRelationDtoList = groupCourseTeacherRelationService.findFreeCourse(groupId);
//        return ResponseEntity.ok(groupCourseTeacherRelationDtoList);
//    }
}
