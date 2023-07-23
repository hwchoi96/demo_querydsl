package com.example.demoorder.order.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GetOrderResponse {

  private String userEmail;
  private String productName;
  private int productPrice;
  private String productCategory;

  @Builder
  public GetOrderResponse(String userEmail, String productName, int productPrice, String productCategory) {
    this.userEmail = userEmail;
    this.productName = productName;
    this.productPrice = productPrice;
    this.productCategory = productCategory;
  }
}
