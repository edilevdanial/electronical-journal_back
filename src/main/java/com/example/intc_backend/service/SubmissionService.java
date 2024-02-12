package com.example.intc_backend.service;

import com.example.intc_backend.dto.HomeworkDto;
import com.example.intc_backend.dto.SubmissionDto;
import com.example.intc_backend.dto.SubmissionSaveRequestDto;
import com.example.intc_backend.dto.SubmissionSendFullDto;

import java.util.List;

public interface SubmissionService {
    SubmissionDto save(SubmissionSaveRequestDto submissionSaveRequestDto);
    List<SubmissionDto> findAllSubmissionByHomework(Long homeworkId);
    List<SubmissionDto> findSubmissionByHomework(Long homeworkId);
    SubmissionDto findById(Long submissionId);
    void saveEntry(SubmissionDto submissionDto);
    List<SubmissionSendFullDto> findAllByItem(Long teacherId);
}
