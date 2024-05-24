package com.example.courier.services;

import com.example.courier.models.Order;
import com.example.courier.models.dtos.ChangeStatusDto;
import com.example.courier.models.dtos.CreateOrderDto;

import java.util.List;

public interface OrderService {
    Order createOrder(CreateOrderDto createOrderDto);

    Order changeStatus(ChangeStatusDto changeStatusDto);

    List<Order> getAllOrders();

    List<Order> getAllOrdersByStatus(String status);
}
