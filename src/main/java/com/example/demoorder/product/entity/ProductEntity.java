package com.example.demoorder.product.entity;

import com.example.demoorder.order.entity.OrderEntity;
import jakarta.persistence.*;
import lombok.Getter;
import java.util.List;

@Entity
@Table(name = "tb_product")
@Getter
public class ProductEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "price")
  private int price;

  @Column(name = "category")
  private String category;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
  private List<OrderEntity> orderEntityList;
}
