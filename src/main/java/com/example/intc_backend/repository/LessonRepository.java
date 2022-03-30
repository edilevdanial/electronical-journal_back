package com.example.intc_backend.repository;

import com.example.intc_backend.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,Long> {
    List<Lesson> findAllByGroupIdAndCourseId(Long groupId, Long courseId);
}
