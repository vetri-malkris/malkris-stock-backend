package com.malkris.stockmanagement.client.service;

import com.malkris.stockmanagement.client.dto.ClientRequest;
import com.malkris.stockmanagement.client.dto.ClientResponse;

import java.util.List;
import java.util.UUID;

public interface ClientService {

    ClientResponse create(
            ClientRequest request
    );

    List<ClientResponse> getAll();

    ClientResponse getById(UUID id);

    ClientResponse update(
            UUID id,
            ClientRequest request
    );

    void delete(UUID id);
}