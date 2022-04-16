package com.example.intc_backend.util;

import com.example.intc_backend.dto.SubmissionDto;
import com.example.intc_backend.dto.SubmissionSaveRequestDto;
import com.example.intc_backend.model.Submission;

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
}
