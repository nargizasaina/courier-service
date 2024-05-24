package com.example.courier.services.impl;

import com.example.courier.models.Client;
import com.example.courier.models.dtos.CreateOrderDto;
import com.example.courier.repos.ClientRepo;
import com.example.courier.services.ClientService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepo clientRepo;

    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public Client createClient(Client client) {
        Client existingClient = clientRepo.findByFirstNameAndLastName(client.getFirstName(), client.getLastName());
        if (existingClient != null) {
            return existingClient;
        }
        Client newClient = new Client();
        newClient.setLastName(client.getLastName());
        newClient.setFirstName(client.getFirstName());
        newClient.setPhone(client.getPhone());
        clientRepo.save(newClient);
        return newClient;
    }
}
