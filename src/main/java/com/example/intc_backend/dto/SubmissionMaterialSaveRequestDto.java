package com.example.intc_backend.dto;

public class SubmissionMaterialSaveRequestDto {
    private Long submissionId;
    private String link;

    public Long getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(Long submissionId) {
        this.submissionId = submissionId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
