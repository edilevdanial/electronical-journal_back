package com.example.intc_backend.util;

import com.example.intc_backend.dto.CourseTeacherRelationDto;
import com.example.intc_backend.dto.CourseTeacherRelationSaveDto;
import com.example.intc_backend.dto.TeacherGroupRelationDto;
import com.example.intc_backend.dto.TeacherGroupRelationSaveRequestDto;
import com.example.intc_backend.model.CourseTeacherRelation;
import com.example.intc_backend.model.TeacherGroupRelation;

import java.util.ArrayList;
import java.util.List;

public class CourseTeacherRelationUtil {
    public static CourseTeacherRelation toCourseRelation(CourseTeacherRelationSaveDto courseTeacherRelationSaveDto) {
        CourseTeacherRelation courseTeacherRelation = new CourseTeacherRelation();

        courseTeacherRelation.setTeacherId(courseTeacherRelationSaveDto.getTeacherId());
        courseTeacherRelation.setCourseId(courseTeacherRelationSaveDto.getCourseId());

        return courseTeacherRelation;
    }

    public static CourseTeacherRelation toCourseRelation(CourseTeacherRelationDto courseTeacherRelationDto) {
        CourseTeacherRelation courseTeacherRelation = new CourseTeacherRelation();

        courseTeacherRelation.setTeacherId(courseTeacherRelationDto.getTeacherId());
        courseTeacherRelation.setCourseId(courseTeacherRelationDto.getCourseId());

        return courseTeacherRelation;
    }

    public static CourseTeacherRelationDto toCourseRelationDto(CourseTeacherRelation courseTeacherRelation) {
        CourseTeacherRelationDto courseTeacherRelationDto = new CourseTeacherRelationDto();

        courseTeacherRelationDto.setTeacherId(courseTeacherRelation.getTeacherId());
        courseTeacherRelationDto.setCourseId(courseTeacherRelation.getCourseId());

        return courseTeacherRelationDto;
    }

    public static List<CourseTeacherRelationDto> toTeacherRelationDtoList(List<CourseTeacherRelation> courseTeacherRelationList) {
        List<CourseTeacherRelationDto> courseTeacherRelationDtoList = new ArrayList<>();

        for (CourseTeacherRelation course : courseTeacherRelationList) {
            courseTeacherRelationDtoList.add(toCourseRelationDto(course));
        }

        return courseTeacherRelationDtoList;
    }

}
