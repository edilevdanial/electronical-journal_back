package com.example.intc_backend.repository;

import com.example.intc_backend.model.SubmissionTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionTestRepository extends JpaRepository<SubmissionTest,Long> {
}
