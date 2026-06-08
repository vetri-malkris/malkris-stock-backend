package com.malkris.stockmanagement.manufacturer.service;

import com.malkris.stockmanagement.manufacturer.dto.ManufacturerRequest;
import com.malkris.stockmanagement.manufacturer.dto.ManufacturerResponse;

import java.util.List;
import java.util.UUID;

public interface ManufacturerService {

    ManufacturerResponse create(
            ManufacturerRequest request
    );

    List<ManufacturerResponse> getAll();

    ManufacturerResponse getById(UUID id);

    ManufacturerResponse update(
            UUID id,
            ManufacturerRequest request
    );

    void delete(UUID id);
}