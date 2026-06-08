package com.malkris.stockmanagement.product.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
public class ProductResponse {

    private UUID id;

    private String sku;

    private String name;

    private String category;

    private Integer stock;

    private BigDecimal price;

    private BigDecimal cost;

    private UUID manufacturerId;

    private String manufacturerName;

    private LocalDateTime createdAt;
}