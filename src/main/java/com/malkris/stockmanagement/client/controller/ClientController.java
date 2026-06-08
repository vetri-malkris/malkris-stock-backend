package com.malkris.stockmanagement.client.controller;

import com.malkris.stockmanagement.client.dto.ClientRequest;
import com.malkris.stockmanagement.client.dto.ClientResponse;
import com.malkris.stockmanagement.client.service.ClientService;
import com.malkris.stockmanagement.common.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ApiResponse<ClientResponse> create(

            @Valid
            @RequestBody
            ClientRequest request
    ) {

        return ApiResponse.success(
                "Client created successfully",
                clientService.create(request)
        );
    }

    @GetMapping
    public ApiResponse<List<ClientResponse>> getAll() {

        return ApiResponse.success(
                clientService.getAll()
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<ClientResponse> getById(
            @PathVariable UUID id
    ) {

        return ApiResponse.success(
                clientService.getById(id)
        );
    }

    @PutMapping("/{id}")
    public ApiResponse<ClientResponse> update(

            @PathVariable UUID id,

            @Valid
            @RequestBody
            ClientRequest request
    ) {

        return ApiResponse.success(
                "Client updated successfully",
                clientService.update(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(
            @PathVariable UUID id
    ) {

        clientService.delete(id);

        return ApiResponse.success(
                "Client deleted successfully",
                null
        );
    }
}