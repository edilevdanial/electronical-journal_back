package com.example.intc_backend.dto;

import java.util.List;

public class CourseFullDataDto {
    private Long courseId;
    private String courseName;
    private List<Long> courseTeacherIdList;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Long> getCourseTeacherIdList() {
        return courseTeacherIdList;
    }

    public void setCourseTeacherRelationDtoList(List<Long> courseTeacherList) {
        this.courseTeacherIdList = courseTeacherList;
    }
}
