package com.example.demoorder.order.repository.impl;

import com.example.demoorder.order.entity.OrderEntity;
import com.example.demoorder.order.entity.QOrderEntity;
import com.example.demoorder.order.repository.inf.OrderRepositoryInterface;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository extends QuerydslRepositorySupport {

  private final OrderRepositoryInterface orderRepositoryInterface;
  private final JPAQueryFactory jpaQueryFactory;

  public OrderRepository(OrderRepositoryInterface orderRepositoryInterface,
                         JPAQueryFactory jpaQueryFactory) {
    super(OrderEntity.class);
    this.orderRepositoryInterface = orderRepositoryInterface;
    this.jpaQueryFactory = jpaQueryFactory;
  }

  public List<OrderEntity> getOrderByProductCategory(String category) {

    QOrderEntity order = QOrderEntity.orderEntity;

    return jpaQueryFactory.select(order)
        .from(order)
        .where(order.product.category.eq(category))
        .fetch();
  }
}
