package com.example.intc_backend.service;

//import com.example.intc_backend.Model.UserModel.UserSaveRequestDto userSaveRequestDto;
import com.example.intc_backend.dto.UserDto;
import com.example.intc_backend.dto.UserSaveRequestDto;
import com.example.intc_backend.model.User;

import java.util.List;

public interface UserService {

    void save(UserSaveRequestDto userSaveRequestDto);

    List<UserDto> findAll();

    UserDto find(Long id);

    List<UserDto> getAllStudent(String type);

    List<UserDto> findUserByType(String type);

    boolean updatePhoneNumber(Long userId,String phone_number);

    boolean delete(Long id);
}
