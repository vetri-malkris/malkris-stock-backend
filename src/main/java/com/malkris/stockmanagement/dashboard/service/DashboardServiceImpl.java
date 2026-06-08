package com.malkris.stockmanagement.dashboard.service;

import com.malkris.stockmanagement.client.repository.ClientRepository;
import com.malkris.stockmanagement.dashboard.dto.DashboardResponse;
import com.malkris.stockmanagement.manufacturer.repository.ManufacturerRepository;
import com.malkris.stockmanagement.product.entity.Product;
import com.malkris.stockmanagement.product.repository.ProductRepository;
import com.malkris.stockmanagement.transaction.entity.Transaction;
import com.malkris.stockmanagement.transaction.entity.TransactionType;
import com.malkris.stockmanagement.transaction.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl
        implements DashboardService {

    private final ProductRepository productRepository;

    private final ClientRepository clientRepository;

    private final ManufacturerRepository manufacturerRepository;

    private final TransactionRepository transactionRepository;

    @Override
    public DashboardResponse getDashboard() {

        Long totalProducts =
                productRepository.count();

        Long totalClients =
                clientRepository.count();

        Long totalManufacturers =
                manufacturerRepository.count();

        Long lowStockProducts =
                (long) productRepository
                        .findByStockLessThanEqual(10)
                        .size();

        Long outOfStockProducts =
                (long) productRepository
                        .findByStock(0)
                        .size();

        BigDecimal totalRevenue =
                transactionRepository.findAll()
                        .stream()
                        .filter(tx ->
                                tx.getType()
                                        == TransactionType.OUT
                        )
                        .map(Transaction::getAmount)
                        .reduce(
                                BigDecimal.ZERO,
                                BigDecimal::add
                        );

        BigDecimal totalPurchase =
                transactionRepository.findAll()
                        .stream()
                        .filter(tx ->
                                tx.getType()
                                        == TransactionType.IN
                        )
                        .map(Transaction::getAmount)
                        .reduce(
                                BigDecimal.ZERO,
                                BigDecimal::add
                        );

        BigDecimal totalStockValue =
                productRepository.findAll()
                        .stream()
                        .map(product ->
                                product.getCost().multiply(
                                        BigDecimal.valueOf(
                                                product.getStock()
                                        )
                                )
                        )
                        .reduce(
                                BigDecimal.ZERO,
                                BigDecimal::add
                        );

        return DashboardResponse.builder()

                .totalProducts(totalProducts)

                .totalClients(totalClients)

                .totalManufacturers(totalManufacturers)

                .lowStockProducts(lowStockProducts)

                .outOfStockProducts(outOfStockProducts)

                .totalRevenue(totalRevenue)

                .totalPurchase(totalPurchase)

                .totalStockValue(totalStockValue)

                .build();
    }
}