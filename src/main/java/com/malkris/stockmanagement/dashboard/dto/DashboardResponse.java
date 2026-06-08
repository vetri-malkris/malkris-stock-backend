package com.malkris.stockmanagement.dashboard.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class DashboardResponse {

    private Long totalProducts;

    private Long totalClients;

    private Long totalManufacturers;

    private Long lowStockProducts;

    private Long outOfStockProducts;

    private BigDecimal totalRevenue;

    private BigDecimal totalPurchase;

    private BigDecimal totalStockValue;
}