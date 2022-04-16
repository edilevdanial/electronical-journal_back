package com.example.intc_backend.dto;

import com.example.intc_backend.model.Submission;

public class SubmissionFullDto {
    private SubmissionSaveRequestDto submission;
    private String material;

    public SubmissionSaveRequestDto getSubmission() {
        return submission;
    }

    public void setSubmission(SubmissionSaveRequestDto submission) {
        this.submission = submission;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
