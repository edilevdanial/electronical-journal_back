package com.example.intc_backend.repository;

import com.example.intc_backend.model.TeacherGroupRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherGroupRelationRepository extends JpaRepository<TeacherGroupRelation, Long> {
//    Boolean findByTeacherId(Long teacherId);
}
