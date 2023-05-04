package com.pinapp.challenge.challenge.repository;

import com.pinapp.challenge.challenge.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
}
