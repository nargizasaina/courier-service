package com.example.courier.repos;

import com.example.courier.models.Address;
import com.example.courier.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
    Address findByStreetAndAndHouseAndFlat(String street, int house, int flat);
}
