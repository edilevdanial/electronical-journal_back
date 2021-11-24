package com.example.intc_backend.service;

import com.example.intc_backend.model.User;
import com.example.intc_backend.repository.UserRepository;
import com.example.intc_backend.dto.UserDto;
import com.example.intc_backend.dto.UserSaveRequestDto;
import com.example.intc_backend.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceIml implements UserService {

    @Autowired
    private UserRepository clientRepository;

    @Override
    public  List<UserDto> findUserByType(String type) {
        System.out.println(type);
         List<UserDto> findUser = UserUtil.toListUserDto(clientRepository.findUserByType(type));
        System.out.println(Arrays.asList(findUser)+"HELLO");
         return findUser;
    }

    @Override
    public void save(UserSaveRequestDto userSaveRequestDto) {
        User user = UserUtil.toUser(userSaveRequestDto);
        clientRepository.save(user);
//        clientRepository.save(user);
    }

    @Override
    public List<UserDto> findAll() {
        return UserUtil.toListUserDto(clientRepository.findAll());
    }

    public List<UserDto> getAllStudent(String type){
        List<User> allUser = clientRepository.findAll();
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
        User user = clientRepository.getById(id);
        return UserUtil.toUserDto(user);
    }

//    @Override
//    public User find(Long id) {
//        return clientRepository.getById(id);
//    }

    @Override
    public boolean updatePhoneNumber(Long userId, String phone_number) {
        User user = clientRepository.getById(userId);
        if(clientRepository.existsById(userId)){
            user.setPhoneNumber(phone_number);
            clientRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (clientRepository.existsById(id)){
            clientRepository.getById(id).setActive(false);
            return true;
        }
        return false;
    }
}
