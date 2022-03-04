package com.example.intc_backend.model;

import javax.persistence.*;

@Entity
@Table(name = "group_course_teacher_relation")
@IdClass(GroupCourseTeacherId.class)
public class GroupCourseTeacherRelation {
    @Id
    @Column(name = "group_id")
    private Long groupId;
    @Id
    @Column(name = "course_id")
    private Long courseId;
    @Column(name = "teacher_id")
    private Long teacherId;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

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
