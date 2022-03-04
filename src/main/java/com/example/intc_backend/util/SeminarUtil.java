package com.example.intc_backend.util;

import com.example.intc_backend.dto.CourseDto;
import com.example.intc_backend.dto.GroupDto;
import com.example.intc_backend.dto.SeminarDto;
import com.example.intc_backend.dto.SeminarSaveRequestDto;
import com.example.intc_backend.model.Course;
import com.example.intc_backend.model.Seminar;
import com.example.intc_backend.service.CourseService;
import com.example.intc_backend.service.GroupService;
import com.example.intc_backend.service.SeminarService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class SeminarUtil {


    public static Seminar toSeminar(SeminarSaveRequestDto seminarSaveRequestDto) {
        Seminar seminar = new Seminar();
        seminar.setCourseId(seminarSaveRequestDto.getCourseId());
        seminar.setGroupId(seminarSaveRequestDto.getGroupId());
        seminar.setTeacherId(seminarSaveRequestDto.getTeacherId());
        seminar.setWeekDay(seminarSaveRequestDto.getWeekDay());
        seminar.setStartTime(seminarSaveRequestDto.getStartTime());
        seminar.setEndTime(seminarSaveRequestDto.getEndTime());

        return seminar;
    }

    public static Seminar toSeminar(SeminarDto seminarDto) {
        Seminar seminar = new Seminar();
        seminar.setCourseId(seminarDto.getCourse().getId());
        seminar.setGroupId(seminarDto.getGroupId());
        seminar.setTeacherId(seminarDto.getTeacherId());
        seminar.setWeekDay(seminarDto.getWeekDay());
        seminar.setStartTime(seminarDto.getStartTime());
        seminar.setEndTime(seminarDto.getEndTime());

        return seminar;
    }

    public static SeminarDto toSeminarDto(Seminar seminar, CourseDto courseDto) {
        SeminarDto seminarDto = new SeminarDto();
        seminarDto.setId(seminar.getId());
        seminarDto.setCourse(courseDto);
        seminarDto.setGroupId(seminar.getGroupId());
        seminarDto.setTeacherId(seminar.getTeacherId());
        seminarDto.setWeekDay(seminar.getWeekDay());
        seminarDto.setStartTime(seminar.getStartTime());
        seminarDto.setEndTime(seminar.getEndTime());

        return seminarDto;
    }

    public static List<SeminarDto> toSeminarDtoList(List<Seminar> seminarList, CourseService courseService) {
        List<SeminarDto> seminarDtoList = new ArrayList<>();

        for (Seminar seminar : seminarList) {
            seminarDtoList.add(toSeminarDto(seminar, courseService.findById(seminar.getCourseId())));
        }

        return seminarDtoList;
    }
}
