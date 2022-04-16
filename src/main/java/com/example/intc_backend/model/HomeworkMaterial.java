package com.example.intc_backend.model;

import javax.persistence.*;

@Entity
@Table(name = "homework_material")
public class HomeworkMaterial {
    @Id
    private Long homeworkId;
    @Column(name = "link")
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
