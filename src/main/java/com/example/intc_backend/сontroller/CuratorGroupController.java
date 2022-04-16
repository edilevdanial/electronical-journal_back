package com.example.intc_backend.сontroller;

import com.example.intc_backend.dto.CuratorGroup;
import com.example.intc_backend.dto.GroupDto;
import com.example.intc_backend.dto.TeacherGroupRelationSaveRequestDto;
import com.example.intc_backend.model.Group;
import com.example.intc_backend.service.TeacherGroupRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CuratorGroupController {
    @Autowired
    private TeacherGroupRelationService teacherGroupRelationService;


    @GetMapping(value = "/get/group/{id}")
    private ResponseEntity<CuratorGroup> findAllGroupAsCurator(@PathVariable(name = "id") Long teacherId) {
        CuratorGroup curatorGroup = teacherGroupRelationService.find(teacherId);
        return ResponseEntity.ok(curatorGroup);
    }

//    @PostMapping(value = "/set/group")
//    private ResponseEntity<?> setCuratorToGroup(@RequestBody TeacherGroupRelationSaveRequestDto teacherGroupRelationSaveRequestDto) {
//        teacherGroupRelationService.save(teacherGroupRelationSaveRequestDto);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
}
