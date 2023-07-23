package com.example.demoorder.order.controller;

import com.example.demoorder.order.dto.GetOrderResponse;
import com.example.demoorder.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @GetMapping("/api/v1/order/user")
  public List<GetOrderResponse> getOrderByUser(@RequestParam("user") String email) {

    // 숙제! -> 요청에 입력한 사용자의 이메일과 같은 주문 목록을 서비스와 레포지토리에 구현체를 넣어서 올바른 값을 반환하도록 해보세요.
    return new ArrayList<>();
  }

  @GetMapping("/api/v1/order/product")
  public List<GetOrderResponse> getOrderByProductCategory(@RequestParam("category") String category) {

    return orderService.getOrderByProductCategory(category);
  }
}
