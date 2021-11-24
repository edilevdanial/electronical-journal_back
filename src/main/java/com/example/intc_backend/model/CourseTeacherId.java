package com.example.intc_backend.model;

import java.io.Serializable;

public class CourseTeacherId implements Serializable {

    private Long courseId;
    private Long teacherId;

    public CourseTeacherId() {
    }

    public CourseTeacherId(Long courseId, Long teacherId) {
        this.courseId = courseId;
        this.teacherId = teacherId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public Long getTeacherId() {
        return teacherId;
    }
}
