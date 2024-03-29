package com.example.intc_backend.service;

import com.example.intc_backend.dto.StudentFullDto;
import com.example.intc_backend.dto.UserDto;
import com.example.intc_backend.dto.UserSaveRequestDto;
import com.example.intc_backend.model.User;
import com.example.intc_backend.repository.UserRepository;
import com.example.intc_backend.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceIml implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> findUserByType(String type) {
        List<UserDto> findUser = UserUtil.toListUserDto(userRepository.findUserByType(type));
        return findUser;
    }

    @Override
    public void save(UserSaveRequestDto userSaveRequestDto) {
        User user = UserUtil.toUser(userSaveRequestDto);

        String validPhone = user.getPhoneNumber().replaceAll("[\\ \\+\\-\\(\\)]", "");

        user.setPhoneNumber(validPhone);
        userRepository.save(user);
    }

    @Override
    public UserDto findUserByToken(String token) {
        UserDto userDto = UserUtil.toUserDto(userRepository.findByToken(token));
        return userDto;
    }

    @Override
    public User findByPhoneNumber(String phoneNumber) {
        User user = userRepository.findByPhoneNumber(phoneNumber);
        return user;
    }

    @Override
    public List<UserDto> findAll() {
//        int page = 0;
//        int size = 3;
//        Pageable paging = (Pageable) PageRequest.of(page, size);
//        System.out.println(userRepository.findAll(paging));
////        return userRepository.findAll(paging);
        //#TODO добавить пагинацию и сортировку
        return UserUtil.toListUserDto(userRepository.findAll());
    }

    public List<UserDto> getAllStudent(String type) {
        List<User> allUser = userRepository.findAll();
//        for (int i=0;i<allUser.size();i++){
//            if (!allUser.get(i).getType().contains("STUDENT")){
//                allUser.remove(i);
//            }
//        }
        allUser.removeIf(user -> !user.getType().contains(type));
//        allUser.forEach(user -> {
//            System.out.println(user);
//            if (!user.getType().contains("STUDENT")){
//                allUser.remove();
//            }
//        });
//        System.out.println(allUser.toArray());
        return UserUtil.toListUserDto(allUser);
    }

    @Override
    public UserDto find(Long id) {
        User user = userRepository.getById(id);
        return UserUtil.toUserDto(user);
    }

    @Override
    public boolean updatePhoneNumber(Long userId, String phone_number) {
        User user = userRepository.getById(userId);
        if (userRepository.existsById(userId)) {
            user.setPhoneNumber(phone_number);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (userRepository.existsById(id)) {
            //#TODO исправить тут
//            userRepository.getById(id).setActive(false);
            return true;
        }
        return false;
    }

    @Override
    public void updateToken(Long id, String token) {
        User user = userRepository.getById(id);
        user.setToken(token);
        userRepository.save(user);
    }

    @Override
    public List<UserDto> findAll(int page, int size) {
        List<UserDto> userDtoList = UserUtil.toListUserDto(userRepository.findAll(PageRequest.of(page, size)).getContent());
        return userDtoList;
    }

//    @Override
//    public StudentFullDto studentFullData(Long id) {
//
//    }
}
