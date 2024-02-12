package com.example.intc_backend.util;

import com.example.intc_backend.dto.*;
import com.example.intc_backend.model.Submission;
import com.example.intc_backend.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class SubmissionUtil {
    public static Submission toSubmission(SubmissionSaveRequestDto submissionSaveRequestDto) {
        Submission submission = new Submission();
//        submission.setLink(submissionSaveRequestDto.getLink());
        submission.setStudentId(submissionSaveRequestDto.getStudentId());
//        submission.setGradeId(submissionSaveRequestDto.getGradeId());
        submission.setHomeworkId(submissionSaveRequestDto.getHomeworkId());
        return submission;
    }
    public static Submission toSubmission(SubmissionDto submissionDto) {
        Submission submission = new Submission();
        submission.setHomeworkId(submissionDto.getHomeworkId());
        submission.setId(submissionDto.getId());
        submission.setGradeId(submissionDto.getId());
        submission.setStudentId(submissionDto.getStudentId());
        return submission;
    }

    public static SubmissionDto toSubmissionDto(Submission submission) {
        SubmissionDto submissionDto = new SubmissionDto();
        submissionDto.setId(submission.getId());
        submissionDto.setStudentId(submission.getStudentId());
        submissionDto.setGradeId(submission.getGradeId());
        submissionDto.setHomeworkId(submission.getHomeworkId());
        return submissionDto;
    }

    public static List<SubmissionDto> toSubmissionDtoList(List<Submission> submissions) {
        List<SubmissionDto> submissionDtoList = new ArrayList<>();
        for (Submission submission : submissions) {
            submissionDtoList.add(toSubmissionDto(submission));
        }
        return submissionDtoList;
    }
    public static List<SubmissionSendFullDto> toSubmissionSendFullDto(List<SubmissionDto> submissions, UserService userService, HomeworkDto homeworkDto) {
        List<SubmissionSendFullDto> submissionSendFullDtoList = new ArrayList<>();
        for(SubmissionDto submissionDto: submissions){
            SubmissionSendFullDto submissionSendFullDto = new SubmissionSendFullDto();
            submissionSendFullDto.setId(submissionDto.getId());
            submissionSendFullDto.setHomework(homeworkDto);
            submissionSendFullDto.setStudent(userService.find(submissionDto.getStudentId()));
            submissionSendFullDto.setGradeId(submissionDto.getGradeId());
            submissionSendFullDto.setLink(submissionDto.getLink());
            submissionSendFullDtoList.add(submissionSendFullDto);
        }
        return submissionSendFullDtoList;
    }
}
