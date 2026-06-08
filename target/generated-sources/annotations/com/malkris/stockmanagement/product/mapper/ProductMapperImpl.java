package com.malkris.stockmanagement.product.mapper;

import com.malkris.stockmanagement.manufacturer.entity.Manufacturer;
import com.malkris.stockmanagement.product.dto.ProductResponse;
import com.malkris.stockmanagement.product.entity.Product;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-08T12:04:07+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductResponse toResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponse.ProductResponseBuilder productResponse = ProductResponse.builder();

        productResponse.manufacturerId( productManufacturerId( product ) );
        productResponse.manufacturerName( productManufacturerName( product ) );
        productResponse.id( product.getId() );
        productResponse.sku( product.getSku() );
        productResponse.name( product.getName() );
        productResponse.category( product.getCategory() );
        productResponse.stock( product.getStock() );
        productResponse.price( product.getPrice() );
        productResponse.cost( product.getCost() );
        productResponse.createdAt( product.getCreatedAt() );

        return productResponse.build();
    }

    private UUID productManufacturerId(Product product) {
        if ( product == null ) {
            return null;
        }
        Manufacturer manufacturer = product.getManufacturer();
        if ( manufacturer == null ) {
            return null;
        }
        UUID id = manufacturer.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String productManufacturerName(Product product) {
        if ( product == null ) {
            return null;
        }
        Manufacturer manufacturer = product.getManufacturer();
        if ( manufacturer == null ) {
            return null;
        }
        String name = manufacturer.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
