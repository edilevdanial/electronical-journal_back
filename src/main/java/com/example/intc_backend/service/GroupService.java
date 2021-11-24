package com.example.intc_backend.service;

import com.example.intc_backend.dto.GroupDto;
import com.example.intc_backend.dto.GroupSaveRequestDto;

import java.util.List;

public interface GroupService {
    void save(GroupSaveRequestDto groupSaveRequestDto);

    List<GroupDto> findAll();

    GroupDto findById(Long id);

    GroupDto findByTeacherId(Long teacherId);

    boolean updateTeacherId(Long groupId, Long newCurator);

    boolean updateGroupName(Long groupId, String newNameGroup);

    boolean delete(Long id);
}
