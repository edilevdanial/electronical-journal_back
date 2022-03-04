package com.example.intc_backend.repository;

import com.example.intc_backend.model.CourseTeacherId;
import com.example.intc_backend.model.CourseTeacherRelation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseTeacherRelationRepository extends JpaRepository<CourseTeacherRelation, CourseTeacherId> {
    List<CourseTeacherRelation> findByTeacherId(Long teacherId);

    List<CourseTeacherRelation> findByCourseId(Long courseId);

    CourseTeacherRelation findByCourseIdAndTeacherId(Long courseId,Long teacherId);

}
