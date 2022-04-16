package com.example.intc_backend.util;

import com.example.intc_backend.dto.SubmissionSaveRequestDto;
import com.example.intc_backend.dto.SubmissionTestDto;
import com.example.intc_backend.dto.SubmissionTestSaveRequestDto;
import com.example.intc_backend.model.SubmissionTest;

public class SubmissionTestUtil {
    public static SubmissionTest toSubmissionTest(SubmissionTestSaveRequestDto submissionTestSaveRequestDto){
        SubmissionTest submissionTest = new SubmissionTest();
        submissionTest.setSubmissionId(submissionTestSaveRequestDto.getSubmissionId());
        submissionTest.setSolution(submissionTestSaveRequestDto.getSolution());
        return submissionTest;
    }

    public static SubmissionTestDto toSubmissionTestDto(SubmissionTest submissionTest){
        SubmissionTestDto submissionTestDto = new SubmissionTestDto();
        submissionTestDto.setSubmissionId(submissionTest.getSubmissionId());
        submissionTestDto.setSolution(submissionTest.getSolution());
        return submissionTestDto;
    }

}
