package com.malkris.stockmanagement.client.repository;

import com.malkris.stockmanagement.client.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository
        extends JpaRepository<Client, UUID> {
}