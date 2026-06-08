package com.malkris.stockmanagement.manufacturer.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
public class ManufacturerResponse {

    private UUID id;

    private String name;

    private String contact;

    private LocalDateTime createdAt;
}