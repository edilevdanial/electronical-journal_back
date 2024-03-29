package com.example.intc_backend.сontroller;

import com.example.intc_backend.dto.*;
import com.example.intc_backend.repository.CourseTeacherRelationRepository;
import com.example.intc_backend.service.GroupService;
import com.example.intc_backend.service.StudentGroupClient;
import com.example.intc_backend.service.TeacherGroupRelationService;
import com.example.intc_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GroupController {
    //    private final GroupService groupService;
    private final UserService userService;
    private final TeacherGroupRelationService teacherGroupRelationService;
    private final CourseTeacherRelationRepository courseTeacherRelationRepository;
    private final GroupService groupService;
    private final StudentGroupClient studentGroupClient;

    @Autowired
    public GroupController(StudentGroupClient studentGroupClient, GroupService groupService, CourseTeacherRelationRepository courseTeacherRelationRepository, TeacherGroupRelationService teacherGroupRelationService, UserService userService) {
        this.groupService = groupService;
        this.studentGroupClient = studentGroupClient;
        this.teacherGroupRelationService = teacherGroupRelationService;
        this.userService = userService;
        this.courseTeacherRelationRepository = courseTeacherRelationRepository;
    }

    @PostMapping(value = "/create-group")
    public ResponseEntity<?> saveGroup(@RequestParam(name = "teacherId") Long teacherId, @RequestParam(name = "groupName") String groupName) {
        GroupSaveRequestDto newGroup = new GroupSaveRequestDto();
        newGroup.setName(groupName);
        newGroup.setTeacherId(teacherId);
        groupService.save(newGroup);

        GroupDto findGroupDto = groupService.findByTeacherId(teacherId);
        try {
            System.out.println(findGroupDto.getId() + "" + findGroupDto.getTeacherId());
        } catch (Exception error) {
            System.out.println(error);
        }

        TeacherGroupRelationSaveRequestDto teacherGroupRelationSaveRequestDto = new TeacherGroupRelationSaveRequestDto();

        teacherGroupRelationSaveRequestDto.setGroupId(findGroupDto.getId());
        teacherGroupRelationSaveRequestDto.setTeacherId(findGroupDto.getTeacherId());
        teacherGroupRelationService.save(teacherGroupRelationSaveRequestDto);

        return ResponseEntity.ok(findGroupDto);
    }

    @PostMapping(value = "/add/student")
    public ResponseEntity<?> saveStudent(@RequestBody StudentGroupRelationRequestSaveDto[] studentGroupRelationRequestSaveDtoList) {
        studentGroupClient.saveArray(studentGroupRelationRequestSaveDtoList);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/student/group")
    public ResponseEntity<List<UserDto>> findAllStudentsOfGroup(@RequestParam(name = "groupId") Long groupId) {
        List<StudentGroupRelationDto> studentId = studentGroupClient.findStudentIdByGroupId(groupId);
        List<UserDto> userDtoList = new ArrayList<>();
        for (StudentGroupRelationDto student : studentId) {
            userDtoList.add(userService.find(student.getStudentId()));
        }
        return ResponseEntity.ok(userDtoList);
    }

    @GetMapping(value = "/group/student")
    public ResponseEntity<List<UserDto>> findStudentOfGroup(@RequestParam(name = "groupId") Long groupId) {
        List<StudentGroupRelationDto> studentId = studentGroupClient.findStudentIdByGroupId(groupId);
        List<UserDto> userDtoList = new ArrayList<>();
        for (StudentGroupRelationDto student : studentId) {
            userDtoList.add(userService.find(student.getStudentId()));
        }
        return ResponseEntity.ok(userDtoList);
    }

    @GetMapping(value = "/all/group")
    public ResponseEntity<List<GroupDto>> findAllGroup() {
        List<GroupDto> groupDtoList = groupService.findAll();
        return ResponseEntity.ok(groupDtoList);
    }

    @GetMapping(value = "/get-all-free-student")
    public ResponseEntity<List<UserDto>> findAllStudent() {
        List<UserDto> userDtoList = userService.findUserByType("STUDENT");
        List<UserDto> findAllUser = new ArrayList<>();

        for (UserDto user : userDtoList) {
            if (studentGroupClient.findByStudentId(user.getId()) == null) {
                findAllUser.add(user);
            }
        }

        return ResponseEntity.ok(findAllUser);
    }

    @GetMapping(value = "/teachers-all-free")
    public ResponseEntity<List<UserDto>> findAllTeacher() {

        List<UserDto> userDtos = new ArrayList<>();
        List<UserDto> findUser = userService.findUserByType("TEACHER");
        for (UserDto user : findUser) {
            System.out.println(user.getId());
            System.out.println("GroupController" + groupService.findByTeacherId(user.getId()));
            if (groupService.findByTeacherId(user.getId()) == null) {
                userDtos.add(user);
            }
        }

        return ResponseEntity.ok(userDtos);
    }

    @DeleteMapping(value = "/delete-from-group/{id}")
    public ResponseEntity<?> deleteFromGroup(@PathVariable(name = "id") Long id) {
        System.out.println(id + "IDDDD");
        studentGroupClient.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
//    @GetMapping(value = "/courses/{courseId}/course-teacher-relations")
//    public ResponseEntity<List<CourseTeacherRelation>> findAllTeacher(@PathVariable(name = "coursesId") Long courseId) {
//    это сделано через path variable
//    можно добавить внутрь функций многа query parametrs cherez @QueryParam
//
//    }

}
