package com.example.intc_backend.util;

import com.example.intc_backend.dto.SubmissionDto;
import com.example.intc_backend.dto.SubmissionMaterialDto;
import com.example.intc_backend.dto.SubmissionMaterialSaveRequestDto;
import com.example.intc_backend.model.SubmissionFile;

public class SubmissionMaterialUtil {
    public static SubmissionFile toSubmissionFile(SubmissionMaterialSaveRequestDto submissionMaterialSaveRequestDto) {
        SubmissionFile submissionFile = new SubmissionFile();
        submissionFile.setSubmissionId(submissionMaterialSaveRequestDto.getSubmissionId());
        submissionFile.setLink(submissionMaterialSaveRequestDto.getLink());
        return submissionFile;
    }

    public static SubmissionMaterialDto toSubmissionFileDto(SubmissionFile submissionFile) {
        SubmissionMaterialDto submissionFileDto = new SubmissionMaterialDto();
        submissionFileDto.setSubmissionId(submissionFile.getSubmissionId());
        submissionFileDto.setLink(submissionFile.getLink());
        return submissionFileDto;
    }
}
