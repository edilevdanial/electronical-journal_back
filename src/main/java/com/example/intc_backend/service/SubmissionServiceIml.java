package com.example.intc_backend.service;

import com.example.intc_backend.dto.SubmissionDto;
import com.example.intc_backend.dto.SubmissionSaveRequestDto;
import com.example.intc_backend.repository.SubmissionRepository;
import com.example.intc_backend.util.SubmissionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionServiceIml implements SubmissionService {
    @Autowired
    private SubmissionRepository submissionRepository;

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
    public SubmissionDto findSubmissionByHomework(Long homeworkId) {
        SubmissionDto submission = SubmissionUtil.toSubmissionDto(submissionRepository.findByHomeworkId(homeworkId));
        return submission;
    }
}
