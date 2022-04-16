package com.example.intc_backend.dto;

import java.util.List;

public class Test {
 private String name;
 private String correctMessage;
 private String noCorrectMessage;
 private List<Question> questions;
 private Long testId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCorrectMessage() {
        return correctMessage;
    }

    public void setCorrectMessage(String correctMessage) {
        this.correctMessage = correctMessage;
    }

    public String getNoCorrectMessage() {
        return noCorrectMessage;
    }

    public void setNoCorrectMessage(String noCorrectMessage) {
        this.noCorrectMessage = noCorrectMessage;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }
}
