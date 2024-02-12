package com.example.intc_backend.сontroller;


import com.example.intc_backend.dto.UserDto;
import com.example.intc_backend.dto.UserSaveRequestDto;
import com.example.intc_backend.service.UserService;
import com.example.intc_backend.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @PostMapping(value = "/user")
    public ResponseEntity<?> create(@RequestBody UserSaveRequestDto userSaveRequestDto) {
        String encodedPassword = this.passwordEncoder.encode(userSaveRequestDto.getPassword());
        System.out.println("YEP BRO HERE ");
        userSaveRequestDto.setPassword(encodedPassword);
        System.out.println(userSaveRequestDto.toString());
        userService.save(userSaveRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<UserDto> readById(@PathVariable(name = "id") Long id) {
        UserDto user = userService.find(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/user")
    public ResponseEntity<UserDto> readByPhoneName(@RequestParam(name = "phone") String phone) {
        UserDto user = UserUtil.toUserDto(userService.findByPhoneNumber(phone));
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserDto>> read() {

        List<UserDto> userDtos = userService.findAll(0, 10);

        return userDtos != null && !userDtos.isEmpty()
                ? new ResponseEntity<>(userDtos, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/user/me")
    public ResponseEntity<UserDto> findByToken(@RequestHeader(name = "Authorization") String token) {
        System.out.println("TOKENNN" + token.split(" ")[1]);
        UserDto userDto = userService.findUserByToken(token.split(" ")[1]);

        return userDto != null
                ? new ResponseEntity<>(userDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/userByType")
    public ResponseEntity<List<UserDto>> getAllUserByType(@RequestParam(name = "type") String type) {
        List<UserDto> userDtoList = userService.findUserByType(type);

        return userDtoList != null && !userDtoList.isEmpty()
                ? new ResponseEntity<>(userDtoList, HttpStatus.OK)
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
