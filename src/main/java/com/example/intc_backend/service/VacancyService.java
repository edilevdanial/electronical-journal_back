package com.example.intc_backend.service;

import com.example.intc_backend.dto.VacancyDto;
import com.example.intc_backend.dto.VacancySaveRequestDto;

import java.util.List;

public interface VacancyService {
    void save(VacancySaveRequestDto vacancySaveRequestDto);

    VacancyDto findById(Long id);

    List<VacancyDto> findAll();

    void updateVacancy(VacancyDto vacancyDto);
}
