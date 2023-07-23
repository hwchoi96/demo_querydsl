package com.example.demoorder.order.entity;

import com.example.demoorder.product.entity.ProductEntity;
import com.example.demoorder.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_order")
@Getter
@Setter
public class OrderEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long orderId;

  @ManyToOne(fetch = FetchType.LAZY)
  private UserEntity user;

  @ManyToOne(fetch = FetchType.LAZY)
  private ProductEntity product;
}
