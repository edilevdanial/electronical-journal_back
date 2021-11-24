package com.example.intc_backend.repository;

import com.example.intc_backend.model.StudentGroupRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentGroupRepository extends JpaRepository<StudentGroupRelation, Long> {
    List<StudentGroupRelation> findByGroupId(Long groupId);

    StudentGroupRelation findByStudentId(Long studentId);

    List<StudentGroupRelation> findStudentIdByGroupId(Long groupId);
}