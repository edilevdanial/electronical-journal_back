package com.example.intc_backend.dto;

import com.example.intc_backend.model.User;

public class SubmissionSendFullDto {
    private Long id;
    private UserDto student;
    private HomeworkDto homework;
    private Long gradeId;
    private String link;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getStudent() {
        return student;
    }

    public void setStudent(UserDto student) {
        this.student = student;
    }

    public HomeworkDto getHomework() {
        return homework;
    }

    public void setHomework(HomeworkDto homework) {
        this.homework = homework;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
