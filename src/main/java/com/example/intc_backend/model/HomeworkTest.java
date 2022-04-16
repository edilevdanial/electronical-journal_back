package com.example.intc_backend.model;

import net.minidev.json.JSONObject;

import javax.persistence.*;

@Entity
@Table(name = "homework_test")
public class HomeworkTest {
    @Id
    private Long homeworkId;
    @Column(name = "name")
    private String name;
    @Column(name = "problems")
    private String problems;

    public Long getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Long homeworkId) {
        this.homeworkId = homeworkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProblems() {
        return problems;
    }

    public void setProblems(String problems) {
        this.problems = problems;
    }
}
