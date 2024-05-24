package com.example.courier.repos;

import com.example.courier.models.Order;
import com.example.courier.models.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    Order findByOrderNum(int orderNum);
    List<Order> findAllByStatus(OrderStatus status);
}
