package com.example.intc_backend.util;

import com.example.intc_backend.model.User;
import com.example.intc_backend.dto.UserDto;
import com.example.intc_backend.dto.UserSaveRequestDto;

import java.util.ArrayList;
import java.util.List;

public class UserUtil {

    public static UserDto toUserDto(User user){
        if(user==null){
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPatronymicName(user.getPatronymicName());
        userDto.setEmail(user.getEmail());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setActive(user.getActive());
        userDto.setType(user.getType());

        return userDto;
    }


    public static List<UserDto> toListUserDto(List<User> user){
        List<UserDto> userDtoList = new ArrayList<>();
        //TODO ещё раз подумать
//        for(User user_:user){
//            userDtos.add(toUserDto(user_));
//        }
        for(int i=0;i<user.size();i++){
            userDtoList.add(i,toUserDto(user.get(i)));
        }
        return userDtoList;
    }




    public static User toUser(UserSaveRequestDto userSaveRequestDto){
        if(userSaveRequestDto==null){
            return null;
        }
        User user = new User();
        user.setFirstName(userSaveRequestDto.getFirstName());
        user.setPhoneNumber(userSaveRequestDto.getPhoneNumber());
        user.setLastName(userSaveRequestDto.getLastName());
        user.setPassword(userSaveRequestDto.getPassword());
        user.setType(userSaveRequestDto.getType());
        user.setActive(true);
        user.setEmail(userSaveRequestDto.getEmail());
        user.setPatronymicName(userSaveRequestDto.getPatronymicName());
        user.setToken("fsfdasdasdasdsadas");
        return user;
    }

}
