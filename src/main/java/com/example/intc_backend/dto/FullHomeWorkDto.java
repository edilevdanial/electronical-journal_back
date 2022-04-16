package com.example.intc_backend.dto;

import com.example.intc_backend.model.HomeworkMaterial;

public class FullHomeWorkDto {
    private HomeworkSaveRequestDto homework;
    private String material;
//    private HomeworkTestDto homeworkTest;

    public HomeworkSaveRequestDto getHomework() {
        return homework;
    }

    public void setHomework(HomeworkSaveRequestDto homework) {
        this.homework = homework;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

//    public HomeworkTestDto getHomeworkTest() {
//        return homeworkTest;
//    }
//
//    public void setHomeworkTest(HomeworkTestDto homeworkTest) {
//        this.homeworkTest = homeworkTest;
//    }
}
