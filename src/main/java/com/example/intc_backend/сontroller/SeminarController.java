package com.example.intc_backend.сontroller;

import com.example.intc_backend.dto.NewsSaveRequestDto;
import com.example.intc_backend.dto.SeminarDto;
import com.example.intc_backend.dto.SeminarSaveRequestDto;
import com.example.intc_backend.service.SeminarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeminarController {
    private final SeminarService seminarService;

    @Autowired
    public SeminarController(SeminarService seminarService) {
        this.seminarService = seminarService;
    }

    @PostMapping(value = "create-seminar")
    public ResponseEntity<?> createSeminar(@RequestBody SeminarSaveRequestDto seminarSaveRequestDto){
        System.out.println(seminarSaveRequestDto.getCourseId());
        System.out.println(seminarSaveRequestDto.getGroupId());
        System.out.println(seminarSaveRequestDto.getTeacherId());
        System.out.println(seminarSaveRequestDto.getWeekDay());
        System.out.println(seminarSaveRequestDto.getStartTime());
        System.out.println(seminarSaveRequestDto.getEndTime());
        seminarService.save(seminarSaveRequestDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping(value = "update-seminar")
    public ResponseEntity<?> updateSeminar(@RequestBody SeminarDto seminarDto){

        System.out.println(seminarDto.getId());
        System.out.println(seminarDto.getCourseId());
        System.out.println(seminarDto.getGroupId());
        System.out.println(seminarDto.getTeacherId());
        System.out.println(seminarDto.getWeekDay());
        System.out.println(seminarDto.getStartTime());
        System.out.println(seminarDto.getEndTime());
        seminarService.updateSeminar(seminarDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "all/seminar")
    public ResponseEntity<List<SeminarDto>> allSeminar(){
        List<SeminarDto> seminarDtoList = seminarService.findAll();

        return ResponseEntity.ok(seminarDtoList);
    }
    @GetMapping(value = "seminar/group")
    public ResponseEntity<List<SeminarDto>> allSeminarByGroupId(@RequestParam(name = "groupId")Long groupId){
        List<SeminarDto> seminarDtoListByGroup = seminarService.findByGroupId(groupId);

        return ResponseEntity.ok(seminarDtoListByGroup);
    }
}
