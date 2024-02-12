package com.example.intc_backend.service;

import com.example.intc_backend.dto.HomeworkDto;
import com.example.intc_backend.dto.SubmissionDto;
import com.example.intc_backend.dto.SubmissionSaveRequestDto;
import com.example.intc_backend.dto.SubmissionSendFullDto;
import com.example.intc_backend.model.Submission;
import com.example.intc_backend.repository.SubmissionRepository;
import com.example.intc_backend.util.SubmissionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubmissionServiceIml implements SubmissionService {
    @Autowired
    private SubmissionRepository submissionRepository;
    @Autowired
    private HomeworkService homeworkService;
    @Autowired
    private UserService userService;

    @Override
    public SubmissionDto save(SubmissionSaveRequestDto submissionSaveRequestDto) {
        SubmissionDto submissionDto = SubmissionUtil.toSubmissionDto(submissionRepository.save(SubmissionUtil.toSubmission(submissionSaveRequestDto)));
        return submissionDto;
    }

    @Override
    public List<SubmissionDto> findAllSubmissionByHomework(Long homeworkId) {
        return null;
//        List<SubmissionDto> submissionDtoList = submissionRepository.findAllByHomeworkId(homeworkId);
    }

    @Override
    public SubmissionDto findById(Long submissionId) {
        SubmissionDto submission = SubmissionUtil.toSubmissionDto(submissionRepository.getById(submissionId));
        return submission;
    }

    @Override
    public List<SubmissionDto> findSubmissionByHomework(Long homeworkId) {
        List<SubmissionDto> submission = SubmissionUtil.toSubmissionDtoList(submissionRepository.findByHomeworkId(homeworkId));
        return submission;
    }

    @Override
    public void saveEntry(SubmissionDto submissionDto) {
        submissionRepository.save(SubmissionUtil.toSubmission(submissionDto));
    }

    @Override
    public List<SubmissionSendFullDto> findAllByItem(Long teacherId) {
        int page = 0;
        int size = 15;
        List<HomeworkDto> homeworkDtoList = homeworkService.findHomeworkByTeacherId(teacherId);
        List<SubmissionSendFullDto> submissionDtoList = new ArrayList<>();
        for (HomeworkDto homeworkDto : homeworkDtoList) {
            List<Submission> submission = submissionRepository.findByHomeworkId(homeworkDto.getId());
            if (submission != null) {
                submissionDtoList.addAll(SubmissionUtil.toSubmissionSendFullDto(SubmissionUtil.toSubmissionDtoList(submission), userService, homeworkDto));
            }
        }
        return submissionDtoList;
    }
}

