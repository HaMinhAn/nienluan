package com.example.nienluan.services;

import com.example.nienluan.dto.CredentialsDto;
import com.example.nienluan.dto.RegisterDto;
import com.example.nienluan.dto.UserDto;
import com.example.nienluan.exceptions.AppException;
import com.example.nienluan.mappers.UserMapper;
import com.example.nienluan.models.User;
import com.example.nienluan.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServices {
  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final PasswordEncoder passwordEncoder;

  public UserDto findByUsername(String username) {
    User user = userRepository.findByUsername(username).orElseThrow(() -> new AppException("Unknoew user", HttpStatus.NOT_FOUND));

    return userMapper.toUserDto(user);
  }

  public UserDto login(CredentialsDto credentialsDto) {

    User user = userRepository.findByUsername(credentialsDto.getUsername()).orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

    if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), user.getPassword())){
        return userMapper.toUserDto(user);
    }
    throw new AppException("Invalid password",HttpStatus.BAD_REQUEST);
  }

  public UserDto register(RegisterDto registerDto){
  Optional<User> userOptional = userRepository.findByUsername(registerDto.getUsername());
  if (userOptional.isPresent()){
    throw new AppException("User is existed", HttpStatus.BAD_REQUEST);
  }
    User user = userMapper.registerToUser(registerDto);
    user.setPassword(passwordEncoder.encode(CharBuffer.wrap(registerDto.getPassword())));

    User userSave = userRepository.save(user);

    return userMapper.toUserDto(userSave);
  }
}
