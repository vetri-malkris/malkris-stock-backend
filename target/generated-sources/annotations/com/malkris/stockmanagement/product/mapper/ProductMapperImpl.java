package com.malkris.stockmanagement.product.mapper;

import com.malkris.stockmanagement.manufacturer.entity.Manufacturer;
import com.malkris.stockmanagement.product.dto.ProductResponse;
import com.malkris.stockmanagement.product.entity.Product;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-29T16:58:11+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
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
        productResponse.category( product.getCategory() );
        productResponse.cost( product.getCost() );
        productResponse.createdAt( product.getCreatedAt() );
        productResponse.id( product.getId() );
        productResponse.name( product.getName() );
        productResponse.price( product.getPrice() );
        productResponse.sku( product.getSku() );
        productResponse.stock( product.getStock() );

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
