package com.example.nienluan.mappers;

import com.example.nienluan.dto.RegisterDto;
import com.example.nienluan.dto.UserDto;
import com.example.nienluan.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public UserDto toUserDto(User user) {
    UserDto userDto = UserDto.builder()
            .username(user.getUsername())
            .id(user.getId())
            .name(user.getName())
            .password(user.getPassword())
            .build();
    return userDto;
  }

  ;

  public User registerToUser(RegisterDto signUpDto) {
    User user = new User();
    user.setAge(signUpDto.getAge());
    user.setPassword(signUpDto.getPassword());
    user.setUsername(signUpDto.getUsername());
    user.setPhoneNumber(signUpDto.getPhoneNumber());
    user.setSex(signUpDto.getSex());
    return user;
  }

  ;

}
