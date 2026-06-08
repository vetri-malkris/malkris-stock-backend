package com.malkris.stockmanagement.transaction.service;

import com.malkris.stockmanagement.transaction.dto.TransactionRequest;
import com.malkris.stockmanagement.transaction.dto.TransactionResponse;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {

    TransactionResponse create(
            TransactionRequest request
    );

    List<TransactionResponse> getAll();

    BigDecimal getTotalRevenue();

    BigDecimal getTotalPurchase();
}