package com.example.courier.services.impl;

import com.example.courier.exceptions.InvalidOrderStatus;
import com.example.courier.exceptions.NoOrderByOrderNum;
import com.example.courier.models.*;
import com.example.courier.models.dtos.ChangeStatusDto;
import com.example.courier.models.dtos.CreateOrderDto;
import com.example.courier.models.enums.OrderStatus;
import com.example.courier.repos.OrderRepo;
import com.example.courier.services.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final ParcelService parcelService;
    private final ClientService clientService;
    private final AddressService addressService;
    private final ClientAddressService clientAddressService;

    public OrderServiceImpl(OrderRepo orderRepo, ParcelService parcelService, ClientService clientService, AddressService addressService, ClientAddressService clientAddressService) {
        this.orderRepo = orderRepo;
        this.parcelService = parcelService;
        this.clientService = clientService;
        this.addressService = addressService;
        this.clientAddressService = clientAddressService;
    }

    @Override
    public Order createOrder(CreateOrderDto createOrderDto) {
        Parcel parcel = parcelService.createParcel(createOrderDto.getParcel());
        double price = parcelService.calculateDeliveryCost(parcel);

        Client sender = clientService.createClient(createOrderDto.getSender());
        Client recipient = clientService.createClient(createOrderDto.getRecipient());

        Address senderAddress = addressService.createAddress(createOrderDto.getPickUpAddress());
        Address deliveryAddress = addressService.createAddress(createOrderDto.getDeliveryAddress());

        clientAddressService.createClientAddress(sender, senderAddress);
        clientAddressService.createClientAddress(recipient, deliveryAddress);
        Order order = new Order();
        order.setDeliveryTime(createOrderDto.getDeliveryTime());
        order.setPickUpAddress(createOrderDto.getPickUpAddress());
        order.setDeliveryAddress(createOrderDto.getDeliveryAddress());
        order.setSender(createOrderDto.getSender());
        order.setRecipient(createOrderDto.getRecipient());
        order.setParcel(parcel);
        order.setSender(sender);
        order.setRecipient(recipient);
        order.setDeliveryAddress(deliveryAddress);
        order.setPickUpAddress(senderAddress);
        order.setStatus(OrderStatus.NEW);
        order.setPrice(price);
        orderRepo.save(order);
        return order;
    }

    @Override
    public Order changeStatus(ChangeStatusDto changeStatusDto) {
        Order order = orderRepo.findByOrderNum(changeStatusDto.getOrderNum());
        if (order == null) {
            throw new NoOrderByOrderNum(changeStatusDto.getOrderNum());
        }

        order.setStatus(changeStatusDto.getStatus());
        orderRepo.save(order);
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public List<Order> getAllOrdersByStatus(String status) {
        OrderStatus orderStatus;
        try {
            orderStatus = OrderStatus.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidOrderStatus();
        }
        return orderRepo.findAllByStatus(orderStatus);
    }
}
