package com.example.intc_backend.dto;

import javax.persistence.Column;

public class SubmissionSaveRequestDto {
    private Long studentId;
    private Long homeworkId;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Long homeworkId) {
        this.homeworkId = homeworkId;
    }

}
