package com.example.intc_backend.repository;

import com.example.intc_backend.model.HomeworkTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeworkTestRepository extends JpaRepository<HomeworkTest,Long> {
}
