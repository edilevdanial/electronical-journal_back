package com.example.intc_backend.service;

import com.example.intc_backend.dto.CourseDto;
import com.example.intc_backend.dto.CourseSaveRequestDto;
import com.example.intc_backend.model.Course;
import com.example.intc_backend.repository.CourseRepository;
import com.example.intc_backend.util.CourseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceIml implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<CourseDto> findAll() {
        List<CourseDto> courseDtoList = CourseUtil.toCourseDtoList(courseRepository.findAll());
        CourseDto courseDto = new CourseDto();
        Object obj = new Object();
        return courseDtoList;
    }

    @Override
    public CourseDto findByName(String name) {
        return  CourseUtil.toCourseDto(courseRepository.findByName(name));
    }

    @Override
    public void save(CourseSaveRequestDto courseSaveRequestDto) {
        courseRepository.save(CourseUtil.toCourse(courseSaveRequestDto));
    }

    @Override
    public CourseDto findById(Long courseId) {
        CourseDto courseDto = CourseUtil.toCourseDto(courseRepository.getById(courseId));

        return courseDto;
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }
}
