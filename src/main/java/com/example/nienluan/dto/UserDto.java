package com.example.nienluan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {
  private int id;
  private String name;
  private String username;
  private String password;
  private String token;
  private String address;
}
