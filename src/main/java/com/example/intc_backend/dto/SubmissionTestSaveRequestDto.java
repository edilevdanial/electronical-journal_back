package com.example.intc_backend.dto;

public class SubmissionTestSaveRequestDto {
    private Long submissionId;
    private String solution;

    public Long getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(Long submissionId) {
        this.submissionId = submissionId;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}
