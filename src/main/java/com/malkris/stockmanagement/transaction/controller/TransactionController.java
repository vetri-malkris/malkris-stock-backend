package com.malkris.stockmanagement.transaction.controller;

import com.malkris.stockmanagement.common.response.ApiResponse;
import com.malkris.stockmanagement.transaction.dto.TransactionRequest;
import com.malkris.stockmanagement.transaction.dto.TransactionResponse;
import com.malkris.stockmanagement.transaction.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ApiResponse<TransactionResponse> create(

            @Valid
            @RequestBody
            TransactionRequest request
    ) {

        return ApiResponse.success(
                "Transaction created successfully",
                transactionService.create(request)
        );
    }

    @GetMapping
    public ApiResponse<List<TransactionResponse>> getAll() {

        return ApiResponse.success(
                transactionService.getAll()
        );
    }

    @GetMapping("/revenue")
    public ApiResponse<BigDecimal> getRevenue() {

        return ApiResponse.success(
                transactionService.getTotalRevenue()
        );
    }

    @GetMapping("/purchase")
    public ApiResponse<BigDecimal> getPurchase() {

        return ApiResponse.success(
                transactionService.getTotalPurchase()
        );
    }
}