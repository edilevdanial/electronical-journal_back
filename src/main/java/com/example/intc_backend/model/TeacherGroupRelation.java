package com.example.intc_backend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "teacher_group_relation", schema = "public")
public class TeacherGroupRelation {
    @Id
    @Column(name = "teacher_id")
    private Long teacherId;
    @Column(name = "group_id")
    private Long groupId;

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

}
