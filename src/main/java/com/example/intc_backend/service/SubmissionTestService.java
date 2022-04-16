package com.example.intc_backend.service;

import com.example.intc_backend.dto.SubmissionTestDto;
import com.example.intc_backend.dto.SubmissionTestSaveRequestDto;

public interface SubmissionTestService {
    void save(SubmissionTestSaveRequestDto submissionTestSaveRequestDto);

    SubmissionTestDto findBySubmissionId(Long submissionId);

}
