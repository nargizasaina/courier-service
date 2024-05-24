package com.example.courier.repos;

import com.example.courier.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {
    Client findByFirstNameAndLastName(String firstName, String lastName);
}
