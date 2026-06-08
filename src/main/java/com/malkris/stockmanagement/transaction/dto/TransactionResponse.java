package com.malkris.stockmanagement.transaction.dto;

import com.malkris.stockmanagement.transaction.entity.TransactionType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
public class TransactionResponse {

    private UUID id;

    private TransactionType type;

    private UUID productId;

    private String productName;

    private UUID clientId;

    private String clientName;

    private Integer quantity;

    private BigDecimal amount;

    private String manufacturerName;

    private LocalDateTime createdAt;
}