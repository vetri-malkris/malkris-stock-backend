package com.malkris.stockmanagement.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class ProductRequest {

    @NotBlank(message = "Product name is required")
    private String name;

    @NotBlank(message = "Category is required")
    private String category;

    @NotNull(message = "Stock is required")
    private Integer stock;

    @NotNull(message = "Price is required")
    private BigDecimal price;

    @NotNull(message = "Cost is required")
    private BigDecimal cost;

    @NotNull(message = "Manufacturer is required")
    private UUID manufacturerId;
}