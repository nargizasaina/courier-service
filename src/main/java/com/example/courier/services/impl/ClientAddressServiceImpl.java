package com.example.courier.services.impl;

import com.example.courier.models.Address;
import com.example.courier.models.Client;
import com.example.courier.models.ClientAddress;
import com.example.courier.repos.ClientAddressRepo;
import com.example.courier.repos.ClientRepo;
import com.example.courier.services.ClientAddressService;
import org.springframework.stereotype.Service;

@Service
public class ClientAddressServiceImpl implements ClientAddressService {
    private final ClientAddressRepo clientAddressRepo;

    public ClientAddressServiceImpl(ClientAddressRepo clientAddressRepo) {
        this.clientAddressRepo = clientAddressRepo;
    }

    @Override
    public ClientAddress createClientAddress(Client client, Address address) {
        ClientAddress existingClAdd = clientAddressRepo.findByClient_IdAndAddress_Id(client.getId(), address.getId());
        if (existingClAdd != null)
            return existingClAdd;
        ClientAddress clientAddress1 = new ClientAddress();

        clientAddress1.setAddress(address);
        clientAddress1.setClient(client);
        clientAddressRepo.save(clientAddress1);
        return clientAddress1;
    }
}
