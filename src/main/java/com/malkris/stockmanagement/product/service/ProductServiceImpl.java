package com.malkris.stockmanagement.product.service;

import com.malkris.stockmanagement.exception.ResourceNotFoundException;
import com.malkris.stockmanagement.manufacturer.entity.Manufacturer;
import com.malkris.stockmanagement.manufacturer.repository.ManufacturerRepository;
import com.malkris.stockmanagement.product.dto.ProductRequest;
import com.malkris.stockmanagement.product.dto.ProductResponse;
import com.malkris.stockmanagement.product.entity.Product;
import com.malkris.stockmanagement.product.mapper.ProductMapper;
import com.malkris.stockmanagement.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl
        implements ProductService {

    private final ProductRepository repository;

    private final ManufacturerRepository manufacturerRepository;

    private final ProductMapper mapper;

    @Override
    public ProductResponse create(
            ProductRequest request
    ) {

        Manufacturer manufacturer =
                manufacturerRepository.findById(
                        request.getManufacturerId()
                ).orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Manufacturer not found"
                        )
                );

        Product product = Product.builder()

                .sku(generateSku(
                        request.getName(),
                        manufacturer.getName()
                ))

                .name(request.getName())

                .category(request.getCategory())

                .stock(request.getStock())

                .price(request.getPrice())

                .cost(request.getCost())

                .manufacturer(manufacturer)

                .build();

        return mapper.toResponse(
                repository.save(product)
        );
    }

    @Override
    public List<ProductResponse> getAll() {

        return repository
                .findAllWithManufacturer()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public ProductResponse getById(UUID id) {

        Product product =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Product not found"
                                )
                        );

        return mapper.toResponse(product);
    }

    @Override
    public ProductResponse update(
            UUID id,
            ProductRequest request
    ) {

        Product product =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Product not found"
                                )
                        );

        Manufacturer manufacturer =
                manufacturerRepository.findById(
                        request.getManufacturerId()
                ).orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Manufacturer not found"
                        )
                );

        product.setName(request.getName());
        product.setCategory(request.getCategory());
        product.setStock(request.getStock());
        product.setPrice(request.getPrice());
        product.setCost(request.getCost());
        product.setManufacturer(manufacturer);

        return mapper.toResponse(
                repository.save(product)
        );
    }

    @Override
    public void delete(UUID id) {

        Product product =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Product not found"
                                )
                        );

        repository.delete(product);
    }

    @Override
    public List<ProductResponse> getLowStockProducts() {

        return repository.findByStockLessThanEqual(10)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<ProductResponse> getOutOfStockProducts() {

        return repository.findByStock(0)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    private String generateSku(
            String productName,
            String manufacturerName
    ) {

        String manufacturerPrefix =
                manufacturerName
                        .replaceAll("[^A-Za-z]", "")
                        .toUpperCase()
                        .substring(0, Math.min(3,
                                manufacturerName.length()));

        String productPrefix =
                productName
                        .replaceAll("[^A-Za-z]", "")
                        .toUpperCase()
                        .substring(0, Math.min(3,
                                productName.length()));

        int random =
                (int) (Math.random() * 9000) + 1000;

        return manufacturerPrefix
                + "-"
                + productPrefix
                + "-"
                + random;
    }
}