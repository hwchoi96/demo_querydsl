package com.example.demoorder.user.service;

import com.example.demoorder.user.dto.CreateUserRequest;
import com.example.demoorder.user.dto.CreateUserResponse;
import com.example.demoorder.user.dto.ModifyUserRequest;
import com.example.demoorder.user.dto.ModifyUserResponse;
import com.example.demoorder.user.entity.UserEntity;
import com.example.demoorder.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  @Transactional
  public CreateUserResponse createUserV1(UserEntity requestUser) {

    UserEntity user = new UserEntity();
    user.setId(requestUser.getId());
    user.setName(requestUser.getName());
    user.setEmail(requestUser.getEmail());
    user.setAddress(requestUser.getAddress());

    userRepository.save(user);

    return CreateUserResponse.builder()
        .id(user.getId())
        .email(user.getEmail())
        .build();
  }

  @Transactional
  public CreateUserResponse createUserV2(CreateUserRequest request) {

    UserEntity user = new UserEntity();
    user.setName(request.getName());
    user.setEmail(request.getEmail());
    user.setAddress(request.getAddress());

    userRepository.save(user);

    return CreateUserResponse.builder()
        .id(user.getId())
        .email(user.getEmail())
        .build();
  }

  public ModifyUserResponse modifyUser(long id, ModifyUserRequest request) {

    UserEntity user = userRepository.findById(id).orElseThrow();
    user.setAddress(request.getAddress());
    userRepository.save(user); // 영속성 컨텍스트에 등록된 엔티티는 save를 쓰지 않아도 변경 감지를 통해 변경되나, 명시적으로 한번 더 호출함.

    return ModifyUserResponse.builder()
        .id(user.getId())
        .address(user.getAddress())
        .build();
  }
}
