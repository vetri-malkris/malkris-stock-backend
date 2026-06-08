package com.malkris.stockmanagement.transaction.service;

import com.malkris.stockmanagement.client.entity.Client;
import com.malkris.stockmanagement.client.repository.ClientRepository;
import com.malkris.stockmanagement.exception.BadRequestException;
import com.malkris.stockmanagement.exception.ResourceNotFoundException;
import com.malkris.stockmanagement.product.entity.Product;
import com.malkris.stockmanagement.product.repository.ProductRepository;
import com.malkris.stockmanagement.transaction.dto.TransactionRequest;
import com.malkris.stockmanagement.transaction.dto.TransactionResponse;
import com.malkris.stockmanagement.transaction.entity.Transaction;
import com.malkris.stockmanagement.transaction.entity.TransactionType;
import com.malkris.stockmanagement.transaction.mapper.TransactionMapper;
import com.malkris.stockmanagement.transaction.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl
        implements TransactionService {

    private final TransactionRepository repository;

    private final ProductRepository productRepository;

    private final ClientRepository clientRepository;

    private final TransactionMapper mapper;

    @Override
    public TransactionResponse create(
            TransactionRequest request
    ) {

        Product product =
                productRepository.findById(
                        request.getProductId()
                ).orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found"
                        )
                );

        Client client = null;

        if (request.getClientId() != null) {

            client = clientRepository.findById(
                    request.getClientId()
            ).orElseThrow(() ->
                    new ResourceNotFoundException(
                            "Client not found"
                    )
            );
        }

        if (
                request.getType() == TransactionType.OUT
                        &&
                        product.getStock() < request.getQuantity()
        ) {

            throw new BadRequestException(
                    "Insufficient stock"
            );
        }

        if (request.getType() == TransactionType.IN) {

            product.setStock(
                    product.getStock()
                            + request.getQuantity()
            );

        } else {

            product.setStock(
                    product.getStock()
                            - request.getQuantity()
            );
        }

        productRepository.save(product);

        BigDecimal amount;

        if (request.getType() == TransactionType.IN) {

            amount = product.getCost()
                    .multiply(
                            BigDecimal.valueOf(
                                    request.getQuantity()
                            )
                    );

        } else {

            amount = product.getPrice()
                    .multiply(
                            BigDecimal.valueOf(
                                    request.getQuantity()
                            )
                    );
        }

        Transaction transaction =
                Transaction.builder()

                        .type(request.getType())

                        .product(product)

                        .client(client)

                        .quantity(request.getQuantity())

                        .amount(amount)

                        .build();

        Transaction savedTransaction =
                repository.save(transaction);

        Product refreshedProduct =
                productRepository.findByIdWithManufacturer(
                        product.getId()
                ).orElseThrow();

        savedTransaction.setProduct(
                refreshedProduct
        );

        return mapper.toResponse(
                savedTransaction
        );
    }

    @Override
    public List<TransactionResponse> getAll() {

        return repository
                .findAllWithRelations()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public BigDecimal getTotalRevenue() {

        return repository.findAll()
                .stream()
                .filter(tx ->
                        tx.getType() == TransactionType.OUT
                )
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public BigDecimal getTotalPurchase() {

        return repository.findAll()
                .stream()
                .filter(tx ->
                        tx.getType() == TransactionType.IN
                )
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}