package com.malkris.stockmanagement.product.controller;

import com.malkris.stockmanagement.common.response.ApiResponse;
import com.malkris.stockmanagement.product.dto.ProductRequest;
import com.malkris.stockmanagement.product.dto.ProductResponse;
import com.malkris.stockmanagement.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ApiResponse<ProductResponse> create(

            @Valid
            @RequestBody
            ProductRequest request
    ) {

        return ApiResponse.success(
                "Product created successfully",
                productService.create(request)
        );
    }

    @GetMapping
    public ApiResponse<List<ProductResponse>> getAll() {

        return ApiResponse.success(
                productService.getAll()
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<ProductResponse> getById(
            @PathVariable UUID id
    ) {

        return ApiResponse.success(
                productService.getById(id)
        );
    }

    @PutMapping("/{id}")
    public ApiResponse<ProductResponse> update(

            @PathVariable UUID id,

            @Valid
            @RequestBody
            ProductRequest request
    ) {

        return ApiResponse.success(
                "Product updated successfully",
                productService.update(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(
            @PathVariable UUID id
    ) {

        productService.delete(id);

        return ApiResponse.success(
                "Product deleted successfully",
                null
        );
    }

    @GetMapping("/low-stock")
    public ApiResponse<List<ProductResponse>>
    getLowStockProducts() {

        return ApiResponse.success(
                productService.getLowStockProducts()
        );
    }

    @GetMapping("/out-of-stock")
    public ApiResponse<List<ProductResponse>>
    getOutOfStockProducts() {

        return ApiResponse.success(
                productService.getOutOfStockProducts()
        );
    }
}