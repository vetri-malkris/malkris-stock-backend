package com.malkris.stockmanagement.product.mapper;

import com.malkris.stockmanagement.product.dto.ProductResponse;
import com.malkris.stockmanagement.product.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(
            source = "manufacturer.id",
            target = "manufacturerId"
    )
    @Mapping(
            source = "manufacturer.name",
            target = "manufacturerName"
    )
    ProductResponse toResponse(Product product);
}