package com.example.intc_backend.dto;

import java.util.List;

public class CuratorGroup {
    private GroupDto group;
    private List<UserDto> students;

    public GroupDto getGroup() {
        return group;
    }

    public void setGroup(GroupDto group) {
        this.group = group;
    }

    public List<UserDto> getStudents() {
        return students;
    }

    public void setStudents(List<UserDto> students) {
        this.students = students;
    }
}
