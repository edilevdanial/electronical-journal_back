package com.example.intc_backend.dto;

import java.util.List;

public class GroupCourseTeacherRelationForTeacherDto {
    private List<CourseDto> course;
    private GroupDto group;

    public List<CourseDto> getCourse() {
        return course;
    }

    public void setCourse(List<CourseDto> course) {
        this.course = course;
    }

    public GroupDto getGroup() {
        return group;
    }

    public void setGroup(GroupDto groupDto) {
        this.group = groupDto;
    }
}
