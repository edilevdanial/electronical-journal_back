package com.example.intc_backend.service;

import com.example.intc_backend.dto.UserDto;
import com.example.intc_backend.dto.UserSaveRequestDto;
import com.example.intc_backend.model.User;
import com.example.intc_backend.repository.UserRepository;
import com.example.intc_backend.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceIml implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> findUserByType(String type) {
        System.out.println(type);
        List<UserDto> findUser = UserUtil.toListUserDto(userRepository.findUserByType(type));
        System.out.println(Arrays.asList(findUser) + "HELLO");
        return findUser;
    }

    @Override
    public void save(UserSaveRequestDto userSaveRequestDto) {
        User user = UserUtil.toUser(userSaveRequestDto);
        userRepository.save(user);
//        clientRepository.save(user);
    }

    @Override
    public List<UserDto> findAll() {
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

//    @Override
//    public User find(Long id) {
//        return clientRepository.getById(id);
//    }

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
            userRepository.getById(id).setActive(false);
            return true;
        }
        return false;
    }
}
