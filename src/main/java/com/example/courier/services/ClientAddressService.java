package com.example.courier.services;

import com.example.courier.models.Address;
import com.example.courier.models.Client;
import com.example.courier.models.ClientAddress;

public interface ClientAddressService {
    ClientAddress createClientAddress(Client client, Address address);
}
