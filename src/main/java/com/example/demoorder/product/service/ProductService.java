package com.example.demoorder.product.service;

import com.example.demoorder.product.dto.GetProductResponse;
import com.example.demoorder.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public List<GetProductResponse> getProductList(String category) {

    // queryDSL를 이용한 where = category 조회 로직 실습

    return productRepository.findAll().stream()
        .map(m ->
            GetProductResponse.builder()
              .name(m.getName())
              .price(m.getPrice())
              .category(m.getCategory())
              .build())
        .collect(Collectors.toList());
  }

  public List<GetProductResponse> getProductListWithPage(int page, int size) {

    PageRequest pageRequest = PageRequest.of(page, size);

    return productRepository.getProductListWithPage(pageRequest.getOffset(), pageRequest.getPageSize())
        .stream()
        .map(m ->
            GetProductResponse.builder()
                .name(m.getName())
                .price(m.getPrice())
                .category(m.getCategory())
                .build())
        .collect(Collectors.toList());
  }

  public List<GetProductResponse> getProductListWithPageAndSortPriceDesc(int page, int size) {

    PageRequest pageRequest = PageRequest.of(page, size);

    return productRepository.getProductListWithPageAndSortPriceDesc(pageRequest.getOffset(), pageRequest.getPageSize())
        .stream()
        .map(m ->
            GetProductResponse.builder()
                .name(m.getName())
                .price(m.getPrice())
                .category(m.getCategory())
                .build())
        .collect(Collectors.toList());
  }
}
