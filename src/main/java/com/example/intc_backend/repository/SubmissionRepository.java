package com.example.intc_backend.repository;

import com.example.intc_backend.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    List<Submission> findAllByHomeworkId(Long homeworkId);
    List<Submission> findByHomeworkId(Long homeworkId);
}
