package com.example.courier.services;

import com.example.courier.models.Address;
import com.example.courier.models.dtos.CreateOrderDto;

public interface AddressService {
    Address createAddress(Address address);
}
