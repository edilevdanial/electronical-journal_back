package com.example.intc_backend.dto;

//Для того чтоб получать курсы которые есть в группе
public class SeminarGroupCoursesDto {
    private CourseDto course;
    private UserDto teacher;
    private Long groupId;

    public CourseDto getCourse() {
        return course;
    }

    public void setCourse(CourseDto course) {
        this.course = course;
    }

    public UserDto getTeacher() {
        return teacher;
    }

    public void setTeacher(UserDto teacher) {
        this.teacher = teacher;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
