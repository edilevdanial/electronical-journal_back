package com.example.intc_backend.model;

import javax.persistence.*;

@Entity
@Table(name = "course_teacher_relation")
@IdClass(CourseTeacherId.class)
public class CourseTeacherRelation {
    @Id
    @Column(name = "course_id")
    private Long courseId;

    @Id
    @Column(name = "teacher_id")
    private Long teacherId;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
}
