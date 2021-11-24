package com.example.intc_backend.service;

import com.example.intc_backend.dto.GroupDto;
import com.example.intc_backend.dto.GroupSaveRequestDto;
import com.example.intc_backend.model.Group;
import com.example.intc_backend.repository.GroupRepository;
import com.example.intc_backend.util.GroupUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceIml implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public void save(GroupSaveRequestDto groupSaveRequestDto) {
        Group group = GroupUtil.toGroup(groupSaveRequestDto);
        groupRepository.save(group);
    }

    @Override
    public List<GroupDto> findAll() {
        List<Group> groupList = groupRepository.findAll();

        return GroupUtil.toListGroupDto(groupList);
    }
    @Override
    public GroupDto findById(Long id) {
        GroupDto groupDto = GroupUtil.toGroupDto(groupRepository.getById(id));

        return groupDto;
    }

    @Override
    public GroupDto findByTeacherId(Long teacherId) {

        GroupDto groupDto = GroupUtil.toGroupDto(groupRepository.findByTeacherId(teacherId));

        return groupDto;
    }

    @Override
    public boolean updateTeacherId(Long groupId, Long newCurator) {
        return false;
    }

    @Override
    public boolean updateGroupName(Long groupId, String newNameGroup) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
