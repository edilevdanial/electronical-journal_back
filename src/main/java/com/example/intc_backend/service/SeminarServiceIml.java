package com.example.intc_backend.service;

import com.example.intc_backend.dto.SeminarDto;
import com.example.intc_backend.dto.SeminarSaveRequestDto;
import com.example.intc_backend.model.Seminar;
import com.example.intc_backend.repository.SeminarRepository;
import com.example.intc_backend.util.SeminarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.spi.ServiceRegistry;
import java.util.List;

@Service
public class SeminarServiceIml implements SeminarService{

    @Autowired
    private SeminarRepository seminarRepository;
    @Autowired
    private CourseService courseService;

    @Override
    public void save(SeminarSaveRequestDto seminarSaveRequestDto) {
        seminarRepository.save(SeminarUtil.toSeminar(seminarSaveRequestDto));
    }

    @Override
    public SeminarDto findById(Long id) {
        return null;
    }

    @Override
    public List<SeminarDto> findAll() {
        List<SeminarDto> seminarDtoList = SeminarUtil.toSeminarDtoList(seminarRepository.findAll(),courseService);
        return seminarDtoList;
    }

    @Override
    public void updateSeminar(SeminarDto seminarDto) {
        seminarRepository.save(SeminarUtil.toSeminar(seminarDto));
    }

    @Override
    public List<SeminarDto> findByGroupId(Long groupId) {
        List<SeminarDto> seminarDtoListByGroup = SeminarUtil.toSeminarDtoList(seminarRepository.findByGroupId(groupId),courseService);
        return seminarDtoListByGroup;
    }

    @Override
    public void saveArray(SeminarSaveRequestDto[] seminarSaveRequestDto) {
        for(SeminarSaveRequestDto saveRequestDto:seminarSaveRequestDto){
            seminarRepository.save(SeminarUtil.toSeminar(saveRequestDto));
        }
    }

    @Override
    public List<SeminarDto> findByTeacherId(Long teacherId) {
        List<SeminarDto> seminarDtoListByGroup = SeminarUtil.toSeminarDtoList(seminarRepository.findByTeacherId(teacherId),courseService);
        return seminarDtoListByGroup;
    }
}
