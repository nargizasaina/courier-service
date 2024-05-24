package com.example.courier.exceptions;

public class NoOrderByOrderNum extends RuntimeException{
    public NoOrderByOrderNum(int message) {
        super("Order not found! order number = " + message);
    }
}
