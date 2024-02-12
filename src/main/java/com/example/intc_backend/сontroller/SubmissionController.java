package com.example.intc_backend.сontroller;

import com.example.intc_backend.dto.*;
import com.example.intc_backend.model.HomeworkTest;
import com.example.intc_backend.model.Submission;
import com.example.intc_backend.service.HomeworkService;
import com.example.intc_backend.service.SubmissionMaterialService;
import com.example.intc_backend.service.SubmissionService;
import com.example.intc_backend.service.SubmissionTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubmissionController {
    @Autowired
    private SubmissionService submissionService;
    @Autowired
    private HomeworkService homeworkService;
    @Autowired
    private SubmissionTestService submissionTestService;
    @Autowired
    private SubmissionMaterialService submissionMaterialService;

    @PostMapping(value = "/submission")
    private ResponseEntity<?> saveSubmission(@RequestBody SubmissionFullDto submissionFullDto) {
        SubmissionDto submissionDto = submissionService.save(submissionFullDto.getSubmission());
        HomeworkDto homeworkDto = homeworkService.findHomework(submissionFullDto.getSubmission().getHomeworkId());
        if (homeworkDto.getType().equals("t")) {
            SubmissionTestSaveRequestDto submissionTestSaveRequestDto = new SubmissionTestSaveRequestDto();
            submissionTestSaveRequestDto.setSubmissionId(submissionDto.getId());
            submissionTestSaveRequestDto.setSolution(submissionFullDto.getMaterial());
            submissionTestService.save(submissionTestSaveRequestDto);
        } else {
            if (homeworkDto.getType().equals("f")) {
                SubmissionMaterialSaveRequestDto material = new SubmissionMaterialSaveRequestDto();
                material.setSubmissionId(submissionDto.getId());
                material.setLink(submissionFullDto.getMaterial());
                submissionMaterialService.save(material);
            }
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/submission/grade")
    private ResponseEntity<?> setGradeToHomework(@RequestParam(name = "submissionId") Long submissionId, @RequestParam(name = "grade") Long gradeId) {
        SubmissionDto submissionDto = submissionService.findById(submissionId);
        submissionDto.setGradeId(gradeId);
        submissionService.saveEntry(submissionDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/submissions")
    private ResponseEntity<List<SubmissionSendFullDto>> getSubmissionByPage(@RequestParam(name = "teacherId")Long teacherId) {
        List<SubmissionSendFullDto> submissionSendFullDtoList = submissionService.findAllByItem(teacherId);
        return ResponseEntity.ok(submissionSendFullDtoList);
    }

}
