package com.example.demoorder.product.repository;

import com.example.demoorder.product.entity.ProductEntity;
import com.example.demoorder.product.entity.QProductEntity;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepositoryCustom {

  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public List<ProductEntity> getProductListWithPage(long offset, int pageSize) {

    QProductEntity product = QProductEntity.productEntity;

    return jpaQueryFactory.selectFrom(product)
        .offset(offset)
        .limit(pageSize)
        .fetch();
  }

  public List<ProductEntity> getProductListWithPageAndSortPriceDesc(long offset, int pageSize) {

    QProductEntity product = QProductEntity.productEntity;

    OrderSpecifier<?> orderSpecifier = new OrderSpecifier<>(Order.DESC, product.price);

    return jpaQueryFactory.selectFrom(product)
        .offset(offset)
        .limit(pageSize)
        .orderBy(orderSpecifier)
        .fetch();
  }
}
