package com.example.courier.exceptions;

public class InvalidOrderStatus extends RuntimeException{
    public InvalidOrderStatus() {
        super("InvalidOrderStatus");
    }

}
