package com.example.intc_backend.service;

import com.example.intc_backend.dto.CourseDto;
import com.example.intc_backend.dto.CourseSaveRequestDto;
import com.example.intc_backend.model.Course;

import java.util.List;

public interface CourseService {
    void save(CourseSaveRequestDto courseSaveRequestDto);

    CourseDto findByName(String name);

    CourseDto findById(Long courseId);

    void delete(Long id);

    List<CourseDto> findAll();

}
