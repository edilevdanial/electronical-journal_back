package com.example.intc_backend.repository;

import com.example.intc_backend.dto.TeacherGroupRelationDto;
import com.example.intc_backend.model.TeacherGroupRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherGroupRelationRepository extends JpaRepository<TeacherGroupRelation, Long> {
//    Boolean findByTeacherId(Long teacherId);
    TeacherGroupRelation findByTeacherId(Long teacherId);
}
