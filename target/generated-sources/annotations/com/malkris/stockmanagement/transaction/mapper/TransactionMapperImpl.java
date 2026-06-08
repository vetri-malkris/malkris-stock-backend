package com.malkris.stockmanagement.transaction.mapper;

import com.malkris.stockmanagement.client.entity.Client;
import com.malkris.stockmanagement.manufacturer.entity.Manufacturer;
import com.malkris.stockmanagement.product.entity.Product;
import com.malkris.stockmanagement.transaction.dto.TransactionResponse;
import com.malkris.stockmanagement.transaction.entity.Transaction;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-03T19:59:20+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public TransactionResponse toResponse(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        TransactionResponse.TransactionResponseBuilder transactionResponse = TransactionResponse.builder();

        transactionResponse.productId( transactionProductId( transaction ) );
        transactionResponse.productName( transactionProductName( transaction ) );
        transactionResponse.clientId( transactionClientId( transaction ) );
        transactionResponse.clientName( transactionClientName( transaction ) );
        transactionResponse.manufacturerName( transactionProductManufacturerName( transaction ) );
        transactionResponse.id( transaction.getId() );
        transactionResponse.type( transaction.getType() );
        transactionResponse.quantity( transaction.getQuantity() );
        transactionResponse.amount( transaction.getAmount() );
        transactionResponse.createdAt( transaction.getCreatedAt() );

        return transactionResponse.build();
    }

    private UUID transactionProductId(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }
        Product product = transaction.getProduct();
        if ( product == null ) {
            return null;
        }
        UUID id = product.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String transactionProductName(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }
        Product product = transaction.getProduct();
        if ( product == null ) {
            return null;
        }
        String name = product.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private UUID transactionClientId(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }
        Client client = transaction.getClient();
        if ( client == null ) {
            return null;
        }
        UUID id = client.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String transactionClientName(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }
        Client client = transaction.getClient();
        if ( client == null ) {
            return null;
        }
        String name = client.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String transactionProductManufacturerName(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }
        Product product = transaction.getProduct();
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
