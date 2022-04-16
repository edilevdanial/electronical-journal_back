package com.example.intc_backend.service;

import com.example.intc_backend.dto.SubmissionDto;
import com.example.intc_backend.dto.SubmissionMaterialDto;
import com.example.intc_backend.dto.SubmissionMaterialSaveRequestDto;
import com.example.intc_backend.repository.SubmissionMaterialRepository;
import com.example.intc_backend.util.SubmissionMaterialUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmissionMaterialServiceIml implements SubmissionMaterialService {

    @Autowired
    private SubmissionMaterialRepository submissionMaterialRepository;

    @Override
    public void save(SubmissionMaterialSaveRequestDto materialSaveRequestDto) {
        submissionMaterialRepository.save(SubmissionMaterialUtil.toSubmissionFile(materialSaveRequestDto));
    }

    @Override
    public SubmissionMaterialDto getBySubmissionId(Long submissionId) {
        SubmissionMaterialDto submissionMaterialDto = SubmissionMaterialUtil.toSubmissionFileDto(submissionMaterialRepository.getById(submissionId));
        return submissionMaterialDto;
    }
}
