package com.example.nienluan.controllers;

import com.example.nienluan.configs.UserAuthProvider;
import com.example.nienluan.dto.CredentialsDto;
import com.example.nienluan.dto.RegisterDto;
import com.example.nienluan.dto.UserDto;
import com.example.nienluan.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class UserController {

  private final UserServices userService;
  private final UserAuthProvider userAuthProvider;
  @PostMapping("/login")
  public ResponseEntity<UserDto> login(@RequestBody CredentialsDto credentialsDto){

    UserDto user = userService.login(credentialsDto);
    user.setToken(userAuthProvider.createToken(user.getUsername()));
    return ResponseEntity.ok(user);
  }

  @PostMapping("/register")
  public ResponseEntity<UserDto> register(@RequestBody RegisterDto registerDto){
  UserDto user = userService.register(registerDto);
  user.setToken(userAuthProvider.createToken(user.getUsername()));

  return ResponseEntity.created(URI.create("/users" + user.getId()))
          .body(user);
  }

}
