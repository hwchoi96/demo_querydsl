package com.example.demoorder.product.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GetProductResponse {

  private String name;
  private int price;
  private String category;

  @Builder
  public GetProductResponse(String name, int price, String category) {
    this.name = name;
    this.price = price;
    this.category = category;
  }
}
