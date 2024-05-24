package com.example.courier.services.impl;

import com.example.courier.models.Address;
import com.example.courier.models.dtos.CreateOrderDto;
import com.example.courier.repos.AddressRepo;
import com.example.courier.services.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;

    public AddressServiceImpl(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    @Override
    public Address createAddress(Address address) {
        Address existingAddress = addressRepo.findByStreetAndAndHouseAndFlat(address.getStreet(), address.getHouse(), address.getFlat());
        if (existingAddress != null) {
            return existingAddress;
        }
        Address address1 = new Address();
        address1.setCity(address.getCity());
        address1.setStreet(address.getStreet());
        address1.setHouse(address.getHouse());
        address1.setFlat(address.getFlat());
        address1.setFloor(address.getFloor());
        addressRepo.save(address1);
        return address1;
    }
}
