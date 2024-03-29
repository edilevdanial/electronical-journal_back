package com.example.intc_backend.service;

import com.example.intc_backend.dto.HomeworkDto;
import com.example.intc_backend.dto.HomeworkSaveRequestDto;

import java.util.List;

public interface HomeworkService {
    List<HomeworkDto> findAllHomeworkByCourseAndGroupId(Long courseId, Long groupId);

    HomeworkDto findHomework(Long homeworkId);

    HomeworkDto saveHomework(HomeworkSaveRequestDto homeworkSaveRequestDto);

    List<HomeworkDto> findHomeworkByTeacherId(Long teacherId);

    List<HomeworkDto> findHomeworkByLessonId(Long lessonId);
}
