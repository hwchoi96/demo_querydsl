package com.example.demoorder.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {

  private String name;
  private String address;
  private String email;
}
