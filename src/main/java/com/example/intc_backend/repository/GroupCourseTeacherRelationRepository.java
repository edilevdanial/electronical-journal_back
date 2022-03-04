package com.example.intc_backend.repository;

import com.example.intc_backend.model.GroupCourseTeacherRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupCourseTeacherRelationRepository extends JpaRepository<GroupCourseTeacherRelation,Long> {
    List<GroupCourseTeacherRelation> getGroupCourseTeacherRelationByGroupId(Long groupId);
    List<GroupCourseTeacherRelation> getGroupCourseTeacherRelationByTeacherId(Long teacherId);

}
