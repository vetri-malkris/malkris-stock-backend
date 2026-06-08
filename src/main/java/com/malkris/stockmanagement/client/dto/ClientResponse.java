package com.malkris.stockmanagement.client.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
public class ClientResponse {

    private UUID id;

    private String name;

    private String type;

    private String contact;

    private LocalDateTime createdAt;
}