package com.example.intc_backend.сontroller;

import com.example.intc_backend.service.UserService;
import com.example.intc_backend.dto.UserDto;
import com.example.intc_backend.dto.UserSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(value = "/user")
    public ResponseEntity<?> create(@RequestBody UserSaveRequestDto userSaveRequestDto){
        //#TODO нормально сделать
//        user.setActive(true);
//        System.out.println(user.getType()+" "+user.getEmail());
        userService.save(userSaveRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<UserDto> read(@PathVariable(name="id")Long id){
        UserDto user = userService.find(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/all/user")
    public ResponseEntity<List<UserDto>> read() {
        List<UserDto> userDtos = userService.findAll();

        return userDtos != null &&  !userDtos.isEmpty()
                ? new ResponseEntity<>(userDtos, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/all/sort/user/{type}")
    public ResponseEntity<List<UserDto>> getAllStudent(@PathVariable(name = "type")String type) {
        List<UserDto> userDtos = userService.getAllStudent(type);

        return userDtos != null &&  !userDtos.isEmpty()
                ? new ResponseEntity<>(userDtos, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


//    @GetMapping(value = "/user/{id}")
//    public ResponseEntity<UserDto> read(@PathVariable(name = "id") int id) {
////        final User user =  clientService.find(id);
////        return user != null
////                ? new ResponseEntity<>(user, HttpStatus.OK)
////                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        return user != null
//                ? new ResponseEntity<>(user, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

}
