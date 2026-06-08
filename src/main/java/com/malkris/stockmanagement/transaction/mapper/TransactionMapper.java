package com.malkris.stockmanagement.transaction.mapper;

import com.malkris.stockmanagement.transaction.dto.TransactionResponse;
import com.malkris.stockmanagement.transaction.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mapping(
            source = "product.id",
            target = "productId"
    )
    @Mapping(
            source = "product.name",
            target = "productName"
    )
    @Mapping(
            source = "client.id",
            target = "clientId"
    )
    @Mapping(
            source = "client.name",
            target = "clientName"
    )
    @Mapping(
            source = "product.manufacturer.name",
            target = "manufacturerName"
    )
    TransactionResponse toResponse(
            Transaction transaction
    );
}