package com.example.intc_backend.service;

import com.example.intc_backend.dto.VacancyDto;
import com.example.intc_backend.dto.VacancySaveRequestDto;
import com.example.intc_backend.model.Vacancy;
import com.example.intc_backend.repository.VacancyRepository;
import com.example.intc_backend.util.VacancyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacancyServiceIml implements VacancyService{

    @Autowired
    private VacancyRepository vacancyRepository;

    @Override
    public void save(VacancySaveRequestDto vacancySaveRequestDto) {

       vacancyRepository.save(VacancyUtil.toVacancy(vacancySaveRequestDto));
    }

    @Override
    public VacancyDto findById(Long id) {
        VacancyDto vacancyDto = VacancyUtil.toVacancyDto(vacancyRepository.getById(id));

        return vacancyDto;
    }

    @Override
    public List<VacancyDto> findAll() {
        List<VacancyDto> vacancyDtoList = VacancyUtil.toVacancyDtoList(vacancyRepository.findAll());

        return vacancyDtoList;
    }

    @Override
    public void updateVacancy(VacancyDto vacancyDto) {
        Vacancy vacancy = VacancyUtil.toVacancy(vacancyDto);

        vacancyRepository.save(vacancy);
    }
}
