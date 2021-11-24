package com.example.intc_backend.service;

import com.example.intc_backend.dto.SeminarDto;
import com.example.intc_backend.dto.SeminarSaveRequestDto;

import java.util.List;

public interface SeminarService {

    void save(SeminarSaveRequestDto seminarSaveRequestDto);

    SeminarDto findById(Long id);
    List<SeminarDto> findAll();
    void updateSeminar(SeminarDto seminarDto);
    List<SeminarDto> findByGroupId(Long groupId);

}
