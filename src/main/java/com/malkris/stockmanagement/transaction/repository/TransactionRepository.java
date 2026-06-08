package com.malkris.stockmanagement.transaction.repository;

import com.malkris.stockmanagement.transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository
        extends JpaRepository<Transaction, UUID> {

    @Query("""
    SELECT t
    FROM Transaction t
    LEFT JOIN FETCH t.product p
    LEFT JOIN FETCH p.manufacturer m
    LEFT JOIN FETCH t.client c
    ORDER BY t.createdAt DESC
""")
    List<Transaction> findAllWithRelations();
}