package com.example.demoorder.user.controller;

import com.example.demoorder.user.dto.CreateUserRequest;
import com.example.demoorder.user.dto.CreateUserResponse;
import com.example.demoorder.user.dto.ModifyUserRequest;
import com.example.demoorder.user.dto.ModifyUserResponse;
import com.example.demoorder.user.entity.UserEntity;
import com.example.demoorder.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/api/v1/member")
  public CreateUserResponse createUserV1(@RequestBody UserEntity userEntity) {

    /*
     * User 생성 API Version 1.
     *
     * Request에 담긴 UserEntity를 받아, 해당 내용을 데이터베이스에 저장한다.
     *
     * - 문제점1 : 클라이언트에게 엔티티 스펙을 그대로 노출해야 한다. (보안)
     * - 문제점2 : UserEntity의 스펙이 변경되는 경우 해당하는 API 모두를 변경해야 한다.
     *          -> 즉, 유저 정보에 성별이 추가된 경우 BE만 수정해야 하는 것이 아닌, 이 API를 호출하고 있는 클라이언트들도 모두 수정해야 한다.
     * - 문제점3 : 본 API는 사용자 id를 입력받기 때문에, 새로운 유저만 생성되어야 하는데, 기존 유저에 대해 update도 발생함. (의도했던 대로 동작하지 않음.)
     * - 문제점4 : 그 외에도 많음... 절대 엔티티 자체를 API에 노출하지 말자.
     */

    return userService.createUserV1(userEntity);
  }

  @PostMapping("/api/v2/member")
  public CreateUserResponse createUserV2(@RequestBody CreateUserRequest request) {

    /*
     * User 생성 API Version 2.
     *
     * 해당 API에서 유효한 DTO 스펙을 만들어, 해당 스펙으로 유저를 생성함.
     *
     * 항상 새로운 사용자가 생성된다.
     */

    return userService.createUserV2(request);
  }

  @PutMapping("/api/v2/user/{id}")
  public ModifyUserResponse modifyUser(@PathVariable long id, @RequestBody ModifyUserRequest request) {

    return userService.modifyUser(id, request);
  }
}
