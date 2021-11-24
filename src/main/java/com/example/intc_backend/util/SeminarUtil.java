package com.example.intc_backend.util;

import com.example.intc_backend.dto.SeminarDto;
import com.example.intc_backend.dto.SeminarSaveRequestDto;
import com.example.intc_backend.model.Seminar;

import java.util.ArrayList;
import java.util.List;

public class SeminarUtil {
    public static Seminar toSeminar(SeminarSaveRequestDto seminarSaveRequestDto){
        Seminar seminar = new Seminar();
        seminar.setCourseId(seminarSaveRequestDto.getCourseId());
        seminar.setGroupId(seminarSaveRequestDto.getGroupId());
        seminar.setTeacherId(seminarSaveRequestDto.getTeacherId());
        seminar.setWeekDay(seminarSaveRequestDto.getWeekDay());
        seminar.setStartTime(seminarSaveRequestDto.getStartTime());
        seminar.setEndTime(seminarSaveRequestDto.getEndTime());

        return seminar;
    }
    public static Seminar toSeminar(SeminarDto seminarDto){
        Seminar seminar = new Seminar();
        seminar.setCourseId(seminarDto.getCourseId());
        seminar.setGroupId(seminarDto.getGroupId());
        seminar.setTeacherId(seminarDto.getTeacherId());
        seminar.setWeekDay(seminarDto.getWeekDay());
        seminar.setStartTime(seminarDto.getStartTime());
        seminar.setEndTime(seminarDto.getEndTime());

        return seminar;
    }
    public static SeminarDto toSeminarDto(Seminar seminar){
        SeminarDto seminarDto = new SeminarDto();
        seminarDto.setId(seminar.getId());
        seminarDto.setCourseId(seminar.getCourseId());
        seminarDto.setGroupId(seminar.getGroupId());
        seminarDto.setTeacherId(seminar.getTeacherId());
        seminarDto.setWeekDay(seminar.getWeekDay());
        seminarDto.setStartTime(seminar.getStartTime());
        seminarDto.setEndTime(seminar.getEndTime());

        return seminarDto;
    }
    public static List<SeminarDto> toSeminarDtoList(List<Seminar> seminarList){
        List<SeminarDto> seminarDtoList = new ArrayList<>();

       for (Seminar seminar:seminarList){
           seminarDtoList.add(toSeminarDto(seminar));
       }

        return seminarDtoList;
    }
}
