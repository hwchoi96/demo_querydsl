package com.example.demoorder.product.controller;

import com.example.demoorder.product.dto.GetProductResponse;
import com.example.demoorder.product.service.ProductService;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping("/api/v1/product")
  public List<GetProductResponse> getProductList(@Nullable @RequestParam("category") String category) {

    return productService.getProductList(category);
  }

  @GetMapping("/api/v2/product")
  public List<GetProductResponse> getProductListWithPage(@RequestParam("page") int page,
                                                         @RequestParam("size") int size) {

    // 페이징 처리 1: 정렬 기준없이, 쌓인 데이터 순서대로 페이징 처리
    return productService.getProductListWithPage(page, size);
  }

  @GetMapping("/api/v3/product")
  public List<GetProductResponse> getProductListWithPageAndSortPriceDesc(@RequestParam("page") int page,
                                                                         @RequestParam("size") int size) {

    // 페이징 처리 2: 가격 기준 내림차순 정렬된 데이터에 대한 페이징 처리
    return productService.getProductListWithPageAndSortPriceDesc(page, size);
  }
}
