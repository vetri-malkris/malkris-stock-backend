package com.malkris.stockmanagement.product.service;

import com.malkris.stockmanagement.product.dto.ProductRequest;
import com.malkris.stockmanagement.product.dto.ProductResponse;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    ProductResponse create(
            ProductRequest request
    );

    List<ProductResponse> getAll();

    ProductResponse getById(UUID id);

    ProductResponse update(
            UUID id,
            ProductRequest request
    );

    void delete(UUID id);

    List<ProductResponse> getLowStockProducts();

    List<ProductResponse> getOutOfStockProducts();
}