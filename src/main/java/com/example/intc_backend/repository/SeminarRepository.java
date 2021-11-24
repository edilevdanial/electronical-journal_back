package com.example.intc_backend.repository;

import com.example.intc_backend.dto.SeminarDto;
import com.example.intc_backend.model.Seminar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeminarRepository extends JpaRepository<Seminar,Long> {
    List<Seminar> findByGroupId(Long id);
}
