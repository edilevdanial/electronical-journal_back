package com.example.intc_backend.repository;

import com.example.intc_backend.model.HomeworkMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeworkMaterialRepository extends JpaRepository<HomeworkMaterial, Long> {
}
