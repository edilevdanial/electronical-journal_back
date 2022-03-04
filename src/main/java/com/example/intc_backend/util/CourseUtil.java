package com.example.intc_backend.util;

import com.example.intc_backend.dto.CourseDto;
import com.example.intc_backend.dto.CourseSaveRequestDto;
import com.example.intc_backend.dto.VacancySaveRequestDto;
import com.example.intc_backend.model.Course;
import com.example.intc_backend.model.Vacancy;

import java.util.ArrayList;
import java.util.List;

public class CourseUtil {
    public static Course toCourse(CourseSaveRequestDto courseSaveRequestDto) {
        if (courseSaveRequestDto == null) return null;
        Course course = new Course();

        course.setName(courseSaveRequestDto.getName());

        return course;
    }

    public static CourseDto toCourseDto(Course course) {
        if (course == null) return null;
        CourseDto courseDto = new CourseDto();

        courseDto.setName(course.getName());
        courseDto.setId(course.getId());

        return courseDto;
    }

    public static List<CourseDto> toCourseDtoList(List<Course> courseList) {
        List<CourseDto> courseDtoList = new ArrayList<>();

        for (Course course : courseList) {
            courseDtoList.add(toCourseDto(course));
        }

        return courseDtoList;
    }
}
