package com.example.intc_backend.сontroller;

import com.example.intc_backend.dto.LessonDto;
import com.example.intc_backend.dto.LessonSaveRequestDto;
import com.example.intc_backend.service.LessonService;
import com.example.intc_backend.service.LessonServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LessonController {
    @Autowired
    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping(value = "/lesson")
    public ResponseEntity<HttpStatus> createLesson(@RequestBody LessonSaveRequestDto lessonSaveRequestDto) {
        lessonService.saveLesson(lessonSaveRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/lessons")
    public ResponseEntity<List<LessonDto>> getAllLessonsByCourseIdAndGroupId(@RequestParam(name = "groupId") Long groupId, @RequestParam(name = "courseId") Long courseId) {
        List<LessonDto> lessonDtoList = lessonService.allLessonByGroupId(groupId, courseId);

        return ResponseEntity.ok(lessonDtoList);
    }

    @GetMapping(value = "/lesson/{id}")
    public ResponseEntity<LessonDto> getLesson(@PathVariable(name = "id") Long lessonId) {
        LessonDto lessonDto = lessonService.getLessonById(lessonId);
        return ResponseEntity.ok(lessonDto);
    }

}
