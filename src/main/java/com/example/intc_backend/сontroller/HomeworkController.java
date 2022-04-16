package com.example.intc_backend.сontroller;

import com.example.intc_backend.dto.*;
import com.example.intc_backend.model.HomeworkTest;
import com.example.intc_backend.repository.HomeworkTestRepository;
import com.example.intc_backend.service.HomeworkMaterialService;
import com.example.intc_backend.service.HomeworkService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class HomeworkController {
    @Autowired
    private HomeworkService homeworkService;
    @Autowired
    private HomeworkMaterialService homeworkMaterialService;
    @Autowired
    private HomeworkTestRepository homeworkTestRepository;

    @PostMapping(value = "/homework")
    private ResponseEntity<?> saveHomework(@RequestBody FullHomeWorkDto fullHomeWork) {
        HomeworkDto homeworkDto = homeworkService.saveHomework(fullHomeWork.getHomework());
        if(fullHomeWork.getHomework().getType().equals("f")){
            HomeworkMaterialSaveRequestDto homeworkMaterialSaveRequestDto = new HomeworkMaterialSaveRequestDto();
            homeworkMaterialSaveRequestDto.setHomeworkId(homeworkDto.getId());
            homeworkMaterialSaveRequestDto.setLink(fullHomeWork.getMaterial());
            homeworkMaterialService.save(homeworkMaterialSaveRequestDto);
        }else{
            if(fullHomeWork.getHomework().getType().equals("t")){
                Gson g = new Gson();
                Test test = new Test();
                test.setTestId((long)1);
                test.setCorrectMessage("hello");
                test.setName("hello");
                List<String> answers = new ArrayList<>();
                answers.add("HELLO");
                List<Question> questions = new ArrayList<>();
                Question question = new Question();
                question.setQuestion("hello");
                question.setAnswers(answers);
                question.setCorrectAnswers("durys");
                questions.add(question);
                test.setQuestions(questions);
                test.setNoCorrectMessage("DURYS EMES");
//                g.fromJson("text",Test.class);
//                Test test2 = g.fromJson(fullHomeWork.getMaterial(), Test.class);
                HomeworkTest homeworkTest = new HomeworkTest();
                homeworkTest.setProblems(g.toJson(test));
                homeworkTest.setHomeworkId(homeworkDto.getId());
                homeworkTest.setName("HELLO");
                homeworkTestRepository.save(homeworkTest);
            }
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/get/allHomework")
    private ResponseEntity<List<HomeworkDto>> findAllHomeWorkGroupIdAndCourseId(@RequestParam(name = "courseId") Long courseId, @RequestParam(name = "groupId") Long groupId) {
        List<HomeworkDto> homeworkDtoList = homeworkService.findAllHomeworkByCourseAndGroupId(courseId, groupId);
        return ResponseEntity.ok(homeworkDtoList);
    }

    @GetMapping(value = "/get/homework/{id}")
    private ResponseEntity<HomeworkDto> findHomework(@PathVariable(name = "id") Long homeworkId) {
        HomeworkDto homeworkDto = homeworkService.findHomework(homeworkId);
        return ResponseEntity.ok(homeworkDto);
    }
}
