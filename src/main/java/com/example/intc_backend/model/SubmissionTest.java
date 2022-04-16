package com.example.intc_backend.model;

import org.w3c.dom.Text;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "submission_test")
public class SubmissionTest {
    @Id
    private Long submissionId;
    @Column(name = "solution")
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
