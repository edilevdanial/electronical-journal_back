package com.example.intc_backend.repository;

import com.example.intc_backend.model.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework, Long> {
    List<Homework> findAllByCourseIdAndGroupId(Long courseId, Long groupId);
}
