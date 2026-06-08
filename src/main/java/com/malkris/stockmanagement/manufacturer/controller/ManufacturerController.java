package com.malkris.stockmanagement.manufacturer.controller;

import com.malkris.stockmanagement.common.response.ApiResponse;
import com.malkris.stockmanagement.manufacturer.dto.ManufacturerRequest;
import com.malkris.stockmanagement.manufacturer.dto.ManufacturerResponse;
import com.malkris.stockmanagement.manufacturer.service.ManufacturerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/manufacturers")
@RequiredArgsConstructor
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @PostMapping
    public ApiResponse<ManufacturerResponse> create(

            @Valid
            @RequestBody
            ManufacturerRequest request
    ) {

        return ApiResponse.success(
                "Manufacturer created successfully",
                manufacturerService.create(request)
        );
    }

    @GetMapping
    public ApiResponse<List<ManufacturerResponse>> getAll() {

        return ApiResponse.success(
                manufacturerService.getAll()
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<ManufacturerResponse> getById(
            @PathVariable UUID id
    ) {

        return ApiResponse.success(
                manufacturerService.getById(id)
        );
    }

    @PutMapping("/{id}")
    public ApiResponse<ManufacturerResponse> update(

            @PathVariable UUID id,

            @Valid
            @RequestBody
            ManufacturerRequest request
    ) {

        return ApiResponse.success(
                "Manufacturer updated successfully",
                manufacturerService.update(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(
            @PathVariable UUID id
    ) {

        manufacturerService.delete(id);

        return ApiResponse.success(
                "Manufacturer deleted successfully",
                null
        );
    }
}