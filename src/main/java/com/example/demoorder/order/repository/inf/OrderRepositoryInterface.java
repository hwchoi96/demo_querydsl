package com.example.demoorder.order.repository.inf;

import com.example.demoorder.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositoryInterface extends JpaRepository<OrderEntity, Long> {
}
