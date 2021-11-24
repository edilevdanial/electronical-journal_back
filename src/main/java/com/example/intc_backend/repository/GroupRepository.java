package com.example.intc_backend.repository;

import com.example.intc_backend.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByTeacherId(Long teacherId);
}