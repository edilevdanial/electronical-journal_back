package com.example.intc_backend.repository;

import com.example.intc_backend.dto.CourseDto;
import com.example.intc_backend.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    Course findByName(String name);
}
