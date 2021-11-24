package com.example.intc_backend.util;

import com.example.intc_backend.dto.VacancyDto;
import com.example.intc_backend.dto.VacancySaveRequestDto;
import com.example.intc_backend.model.Vacancy;

import java.util.ArrayList;
import java.util.List;

public class VacancyUtil {

    public static Vacancy toVacancy(VacancySaveRequestDto vacancySaveRequestDto) {
        if (vacancySaveRequestDto == null) return null;
        Vacancy vacancy = new Vacancy();

        vacancy.setGraphic(vacancySaveRequestDto.getGraphic());
        vacancy.setSalary(vacancySaveRequestDto.getSalary());
        vacancy.setDescription(vacancySaveRequestDto.getDescription());
        vacancy.setCompanyName(vacancySaveRequestDto.getCompanyName());
        vacancy.setPosition(vacancySaveRequestDto.getPosition());
        vacancy.setCompanyAddress(vacancySaveRequestDto.getCompanyAddress());
        vacancy.setExperienceAge(vacancySaveRequestDto.getExperienceAge());

        return vacancy;
    }

    public static Vacancy toVacancy(VacancyDto vacancyDto) {
        if (vacancyDto == null) return null;

        Vacancy vacancy = new Vacancy();

        vacancy.setId(vacancyDto.getId());
        vacancy.setGraphic(vacancyDto.getGraphic());
        vacancy.setDescription(vacancyDto.getDescription());
        vacancy.setPosition(vacancyDto.getPosition());
        vacancy.setSalary(vacancyDto.getSalary());
        vacancy.setCompanyAddress(vacancyDto.getCompanyAddress());
        vacancy.setExperienceAge(vacancyDto.getExperienceAge());
        vacancy.setCompanyName(vacancyDto.getCompanyName());

        return vacancy;
    }

    public static VacancyDto toVacancyDto(Vacancy vacancy) {
        if (vacancy == null) return null;

        VacancyDto vacancyDto = new VacancyDto();

        vacancyDto.setId(vacancy.getId());
        vacancyDto.setSalary(vacancy.getSalary());
        vacancyDto.setDescription(vacancy.getDescription());
        vacancyDto.setGraphic(vacancy.getGraphic());
        vacancyDto.setPosition(vacancy.getPosition());
        vacancyDto.setCompanyName(vacancy.getCompanyName());
        vacancyDto.setCompanyAddress(vacancy.getCompanyAddress());
        vacancyDto.setExperienceAge(vacancy.getExperienceAge());

        return vacancyDto;
    }


    public static List<VacancyDto> toVacancyDtoList(List<Vacancy> vacancyList) {

        List<VacancyDto> vacancyDtoList = new ArrayList<>();

        for (Vacancy vacancy : vacancyList) {
            if (vacancy == null) {
                continue;
            }
            vacancyDtoList.add(toVacancyDto(vacancy));
        }

        return vacancyDtoList;
    }


}
