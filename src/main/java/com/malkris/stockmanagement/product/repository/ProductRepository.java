package com.malkris.stockmanagement.product.repository;

import com.malkris.stockmanagement.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository
        extends JpaRepository<Product, UUID> {

    Optional<Product> findBySku(String sku);

    List<Product> findByStockLessThanEqual(Integer stock);

    List<Product> findByStock(Integer stock);

    @Query("""
    SELECT p
    FROM Product p
    LEFT JOIN FETCH p.manufacturer
    """)
    List<Product> findAllWithManufacturer();

    @Query("""
SELECT p
FROM Product p
LEFT JOIN FETCH p.manufacturer
WHERE p.id = :id
""")
    Optional<Product> findByIdWithManufacturer(UUID id);
}