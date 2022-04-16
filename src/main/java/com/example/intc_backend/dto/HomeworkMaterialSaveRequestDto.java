package com.example.intc_backend.dto;

public class HomeworkMaterialSaveRequestDto {
    private Long homeworkId;
    private String link;

    public Long getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Long homeworkId) {
        this.homeworkId = homeworkId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
