package com.example.intc_backend.dto;

import java.util.List;

public class CourseFullDataDto {
    private CourseDto course;
    private List<Long> courseTeacherList;

    public CourseDto getCourse() {
        return course;
    }

    public void setCourse(CourseDto course) {
        this.course = course;
    }

    public void setCourseTeacherList(List<Long> courseTeacherList) {
        this.courseTeacherList = courseTeacherList;
    }

    public List<Long> getCourseTeacherList() {
        return courseTeacherList;
    }
}
