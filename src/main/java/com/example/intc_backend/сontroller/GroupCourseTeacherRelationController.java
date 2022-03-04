package com.example.intc_backend.сontroller;

import com.example.intc_backend.dto.CourseDto;
import com.example.intc_backend.dto.GroupCourseTeacherRelationDto;
import com.example.intc_backend.dto.GroupCourseTeacherRelationSaveRequestDto;
import com.example.intc_backend.dto.GroupDto;
import com.example.intc_backend.model.GroupCourseTeacherRelation;
import com.example.intc_backend.service.CourseService;
import com.example.intc_backend.service.GroupCourseTeacherRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<List<GroupCourseTeacherRelationDto>> findAllCourses(@RequestBody GroupCourseTeacherRelationSaveRequestDto groupCourseTeacherRelationSaveRequestDto){
        System.out.println(groupCourseTeacherRelationSaveRequestDto.getCourseId());
        System.out.println(groupCourseTeacherRelationSaveRequestDto.getGroupId());
        System.out.println(groupCourseTeacherRelationSaveRequestDto.getTeacherId());
        groupCourseTeacherRelationService.save(groupCourseTeacherRelationSaveRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
//
//    @GetMapping(value = "/all/course")
//    public ResponseEntity<List<GroupCourseTeacherRelationDto>> findAllCourses(){
//        List<GroupCourseTeacherRelationDto> groupCourseTeacherRelationDtoList = groupCourseTeacherRelationService.findAll();
//
//        return ResponseEntity.ok(groupCourseTeacherRelationDtoList);
//    }
    @GetMapping(value = "/group-course/{id}")
    public ResponseEntity<List<GroupCourseTeacherRelationDto>> findAllCourses(@PathVariable(name = "id")Long groupId){
        List<GroupCourseTeacherRelationDto> groupCourseTeacherRelationDtoList = groupCourseTeacherRelationService.findByGroupId(groupId);

//        for (GroupCourseTeacherRelationDto groupCourseTeacherRelationDto:groupCourseTeacherRelationDtoList){
//
//        }
        return ResponseEntity.ok(groupCourseTeacherRelationDtoList);
    }

    @GetMapping(value = "/get-all-groups-teacher/{id}")
    public ResponseEntity<List<GroupDto>> getAllGroupsByTeacherId(@PathVariable(name = "id")Long teacherId){
        List<GroupDto> groupDtoList = groupCourseTeacherRelationService.findAllGroupByTeacherId(teacherId);
        return ResponseEntity.ok(groupDtoList);
    }
}
