package com.example.intc_backend.service;

import com.example.intc_backend.dto.HomeworkDto;
import com.example.intc_backend.dto.HomeworkSaveRequestDto;
import com.example.intc_backend.dto.LessonDto;
import com.example.intc_backend.repository.HomeworkRepository;
import com.example.intc_backend.util.HomeworkUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeworkServiceIml implements HomeworkService {
    @Autowired
    private HomeworkRepository homeworkRepository;
    @Autowired
    private LessonService lessonService;

    @Override
    public List<HomeworkDto> findAllHomeworkByCourseAndGroupId(Long courseId, Long groupId) {
        List<HomeworkDto> homeworkDtoList = HomeworkUtil.toHomeWorkDtoList(homeworkRepository.findAllByCourseIdAndGroupId(courseId, groupId));
        return homeworkDtoList;
    }

    @Override
    public HomeworkDto findHomework(Long homeworkId) {
        HomeworkDto homeworkDto = HomeworkUtil.toHomeWorkDto(homeworkRepository.getById(homeworkId));
        return homeworkDto;
    }

    @Override
    public HomeworkDto saveHomework(HomeworkSaveRequestDto homeworkSaveRequestDto) {
        LessonDto lessonDto = lessonService.getLessonById(homeworkSaveRequestDto.getLessonId());
       HomeworkDto homeworkDto =  HomeworkUtil.toHomeWorkDto(homeworkRepository.save(HomeworkUtil.toHomework(homeworkSaveRequestDto, lessonDto.getCourseId(), lessonDto.getGroupId())));
       return homeworkDto;
    }

    @Override
    public List<HomeworkDto> findHomeworkByTeacherId(Long teacherId) {
        List<HomeworkDto> homeworkDtoList = HomeworkUtil.toHomeWorkDtoList(homeworkRepository.findAllByTeacherId(teacherId));
        return homeworkDtoList;
    }

    @Override
    public List<HomeworkDto> findHomeworkByLessonId(Long lessonId) {
        List<HomeworkDto> homeworkDtoList = HomeworkUtil.toHomeWorkDtoList(homeworkRepository.findAllByLessonId(lessonId));
        return homeworkDtoList;
    }
}
