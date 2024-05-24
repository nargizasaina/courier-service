package com.example.courier.repos;

import com.example.courier.models.ClientAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientAddressRepo extends JpaRepository<ClientAddress, Long> {
    ClientAddress findByClient_IdAndAddress_Id(Long clientId, Long addressId);
}
