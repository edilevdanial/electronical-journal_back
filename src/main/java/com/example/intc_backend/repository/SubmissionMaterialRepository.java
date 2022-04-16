package com.example.intc_backend.repository;

import com.example.intc_backend.model.SubmissionFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionMaterialRepository extends JpaRepository<SubmissionFile, Long> {
}
