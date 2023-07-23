package com.example.demoorder.user.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
public class ModifyUserResponse {

  private long id;
  private String address;

  @Builder
  public ModifyUserResponse(long id, String address) {
    this.id = id;
    this.address = address;
  }
}
