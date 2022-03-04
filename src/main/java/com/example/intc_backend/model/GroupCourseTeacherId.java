package com.example.intc_backend.model;

import java.io.Serializable;

public class GroupCourseTeacherId implements Serializable {
    private Long groupId;
    private Long courseId;

    public GroupCourseTeacherId() {
    }

    public GroupCourseTeacherId(Long groupId, Long courseId) {
        this.groupId = groupId;
        this.courseId = courseId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public Long getCourseId() {
        return courseId;
    }
}
