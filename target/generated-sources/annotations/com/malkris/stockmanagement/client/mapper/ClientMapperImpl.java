package com.malkris.stockmanagement.client.mapper;

import com.malkris.stockmanagement.client.dto.ClientResponse;
import com.malkris.stockmanagement.client.entity.Client;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-29T16:58:11+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientResponse toResponse(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientResponse.ClientResponseBuilder clientResponse = ClientResponse.builder();

        clientResponse.contact( client.getContact() );
        clientResponse.createdAt( client.getCreatedAt() );
        clientResponse.id( client.getId() );
        clientResponse.name( client.getName() );
        clientResponse.type( client.getType() );

        return clientResponse.build();
    }
}
