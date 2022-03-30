package com.example.intc_backend.сontroller;

import com.example.intc_backend.dto.HomeworkDto;
import com.example.intc_backend.dto.HomeworkSaveRequestDto;
import com.example.intc_backend.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeworkController {
    @Autowired
    private HomeworkService homeworkService;

    @PostMapping(value = "/create/homework")
    private ResponseEntity<?> saveHomework(@RequestBody HomeworkSaveRequestDto homeworkSaveRequestDto) {
        homeworkService.saveHomework(homeworkSaveRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/get/allHomework")
    private ResponseEntity<List<HomeworkDto>> findAllHomeWorkGroupIdAndCourseId(@RequestParam(name = "courseId") Long courseId, @RequestParam(name = "groupId") Long groupId) {
        List<HomeworkDto> homeworkDtoList = homeworkService.findAllHomeworkByCourseAndGroupId(courseId, groupId);
        return ResponseEntity.ok(homeworkDtoList);
    }

    @GetMapping(value = "/get/homework/{id}")
    private ResponseEntity<HomeworkDto> findHomework(@PathVariable(name = "id") Long homeworkId) {
        HomeworkDto homeworkDto = homeworkService.findHomework(homeworkId);
        return ResponseEntity.ok(homeworkDto);
    }
}
