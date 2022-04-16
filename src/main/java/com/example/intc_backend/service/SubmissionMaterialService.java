package com.example.intc_backend.service;

import com.example.intc_backend.dto.SubmissionMaterialDto;
import com.example.intc_backend.dto.SubmissionMaterialSaveRequestDto;
import com.example.intc_backend.util.SubmissionUtil;

public interface SubmissionMaterialService {
    void save(SubmissionMaterialSaveRequestDto materialSaveRequestDto);
    SubmissionMaterialDto getBySubmissionId(Long submissionId);
}
