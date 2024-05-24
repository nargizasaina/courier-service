package com.example.courier.controllers;

import com.example.courier.models.Order;
import com.example.courier.models.dtos.ChangeStatusDto;
import com.example.courier.models.dtos.CreateOrderDto;
import com.example.courier.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Validated
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/list")
    public List<Order> getAllOrders () {
        return orderService.getAllOrders();
    }

    @GetMapping("/status")
    public List<Order> getAllOrders (@RequestParam(required = true) String status) {
        return orderService.getAllOrdersByStatus(status);
    }

    @PostMapping("/create")
    public Order createOrder (@RequestBody @Valid CreateOrderDto createOrderDto) {
        return orderService.createOrder(createOrderDto);
    }

    @PutMapping("/change-status")
    public Order changeStatus(@RequestBody ChangeStatusDto changeStatusDto){
        return orderService.changeStatus(changeStatusDto);
    }
}
