package com.malkris.stockmanagement.manufacturer.service;

import com.malkris.stockmanagement.exception.ResourceNotFoundException;
import com.malkris.stockmanagement.manufacturer.dto.ManufacturerRequest;
import com.malkris.stockmanagement.manufacturer.dto.ManufacturerResponse;
import com.malkris.stockmanagement.manufacturer.entity.Manufacturer;
import com.malkris.stockmanagement.manufacturer.mapper.ManufacturerMapper;
import com.malkris.stockmanagement.manufacturer.repository.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ManufacturerServiceImpl
        implements ManufacturerService {

    private final ManufacturerRepository repository;

    private final ManufacturerMapper mapper;

    @Override
    public ManufacturerResponse create(
            ManufacturerRequest request
    ) {

        Manufacturer manufacturer =
                Manufacturer.builder()
                        .name(request.getName())
                        .contact(request.getContact())
                        .build();

        return mapper.toResponse(
                repository.save(manufacturer)
        );
    }

    @Override
    public List<ManufacturerResponse> getAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public ManufacturerResponse getById(UUID id) {

        Manufacturer manufacturer =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Manufacturer not found"
                                )
                        );

        return mapper.toResponse(manufacturer);
    }

    @Override
    public ManufacturerResponse update(
            UUID id,
            ManufacturerRequest request
    ) {

        Manufacturer manufacturer =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Manufacturer not found"
                                )
                        );

        manufacturer.setName(request.getName());
        manufacturer.setContact(request.getContact());

        return mapper.toResponse(
                repository.save(manufacturer)
        );
    }

    @Override
    public void delete(UUID id) {

        Manufacturer manufacturer =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Manufacturer not found"
                                )
                        );

        repository.delete(manufacturer);
    }
}