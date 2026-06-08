package com.malkris.stockmanagement.client.service;

import com.malkris.stockmanagement.client.dto.ClientRequest;
import com.malkris.stockmanagement.client.dto.ClientResponse;
import com.malkris.stockmanagement.client.entity.Client;
import com.malkris.stockmanagement.client.mapper.ClientMapper;
import com.malkris.stockmanagement.client.repository.ClientRepository;
import com.malkris.stockmanagement.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl
        implements ClientService {

    private final ClientRepository repository;

    private final ClientMapper mapper;

    @Override
    public ClientResponse create(
            ClientRequest request
    ) {

        Client client = Client.builder()
                .name(request.getName())
                .type(request.getType())
                .contact(request.getContact())
                .build();

        return mapper.toResponse(
                repository.save(client)
        );
    }

    @Override
    public List<ClientResponse> getAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public ClientResponse getById(UUID id) {

        Client client =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Client not found"
                                )
                        );

        return mapper.toResponse(client);
    }

    @Override
    public ClientResponse update(
            UUID id,
            ClientRequest request
    ) {

        Client client =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Client not found"
                                )
                        );

        client.setName(request.getName());
        client.setType(request.getType());
        client.setContact(request.getContact());

        return mapper.toResponse(
                repository.save(client)
        );
    }

    @Override
    public void delete(UUID id) {

        Client client =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Client not found"
                                )
                        );

        repository.delete(client);
    }
}