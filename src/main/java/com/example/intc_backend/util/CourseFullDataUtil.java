package com.example.intc_backend.util;

import com.example.intc_backend.dto.CourseDto;
import com.example.intc_backend.dto.CourseFullDataDto;
import com.example.intc_backend.dto.CourseTeacherRelationDto;
import com.example.intc_backend.dto.UserDto;
import com.example.intc_backend.model.Course;
import com.example.intc_backend.service.TeacherGroupRelationService;
import com.example.intc_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CourseFullDataUtil {
    //    private static TeacherGroupRelationService userService
//    public static CourseFullDataDto toCourseFullDataUtil(CourseDto courseDto, List<CourseTeacherRelationDto> courseTeacherRelationDtoList){
//        CourseFullDataDto courseFullDataDto = new CourseFullDataDto();
//        courseFullDataDto.setCourseId(courseDto.getId());
//        courseFullDataDto.setCourseName(courseDto.getName());
//        List<Long> teacherIdList = new ArrayList<>();
//        for (CourseTeacherRelationDto courseTeacherRelationDto:courseTeacherRelationDtoList){
//            teacherIdList.add(courseTeacherRelationDto.getTeacherId());
//        }
//        courseFullDataDto.setCourseTeacherRelationDtoList(teacherIdList);
//
//        return courseFullDataDto;
//    }

    public static CourseFullDataDto toCourseFullDataUtil(CourseDto courseDto, List<Long> teacherIdList) {
        CourseFullDataDto courseFullDataDto = new CourseFullDataDto();
        courseFullDataDto.setCourse(courseDto);
        courseFullDataDto.setCourseTeacherList(teacherIdList);

        return courseFullDataDto;
    }

    public static List<CourseFullDataDto> toCourseFullDataUtilList(List<CourseDto> courseDtoList, List<CourseTeacherRelationDto> courseTeacherRelationDtoList) {
        List<CourseFullDataDto> courseFullDataDtoList = new ArrayList<>();
        for (CourseDto courseDto : courseDtoList) {
            List<Long> teacherList = new ArrayList<>();
            for (CourseTeacherRelationDto courseTeacherRelationDto : courseTeacherRelationDtoList) {
                if (Objects.equals(courseDto.getId(), courseTeacherRelationDto.getCourseId())) {
                    teacherList.add(courseTeacherRelationDto.getTeacherId());
                }
            }
            courseFullDataDtoList.add(toCourseFullDataUtil(courseDto, teacherList));
        }

        return courseFullDataDtoList;
    }

}
