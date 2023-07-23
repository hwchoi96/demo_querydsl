package com.example.demoorder.user.entity;

import com.example.demoorder.order.entity.OrderEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_user")
@Setter
@Getter
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "address")
  private String address;

  @Column(name = "email")
  private String email;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  private List<OrderEntity> orderEntityList;
}
