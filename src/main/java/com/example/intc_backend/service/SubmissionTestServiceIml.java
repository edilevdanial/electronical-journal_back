package com.example.intc_backend.service;

import com.example.intc_backend.dto.SubmissionTestDto;
import com.example.intc_backend.dto.SubmissionTestSaveRequestDto;
import com.example.intc_backend.model.SubmissionTest;
import com.example.intc_backend.repository.SubmissionTestRepository;
import com.example.intc_backend.util.SubmissionTestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmissionTestServiceIml implements SubmissionTestService{

    @Autowired
    private SubmissionTestRepository submissionTestRepository;

    @Override
    public void save(SubmissionTestSaveRequestDto submissionTestSaveRequestDto) {
        submissionTestRepository.save(SubmissionTestUtil.toSubmissionTest(submissionTestSaveRequestDto));
    }

    @Override
    public SubmissionTestDto findBySubmissionId(Long submissionId) {
        SubmissionTestDto submissionTestDto = SubmissionTestUtil.toSubmissionTestDto(submissionTestRepository.getById(submissionId));
        return submissionTestDto;
    }
}
