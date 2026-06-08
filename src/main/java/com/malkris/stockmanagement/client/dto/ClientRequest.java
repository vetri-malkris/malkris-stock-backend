package com.malkris.stockmanagement.client.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private String type;

    private String contact;
}