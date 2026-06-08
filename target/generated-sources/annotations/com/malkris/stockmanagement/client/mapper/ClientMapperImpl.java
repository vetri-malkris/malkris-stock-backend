package com.malkris.stockmanagement.client.mapper;

import com.malkris.stockmanagement.client.dto.ClientResponse;
import com.malkris.stockmanagement.client.entity.Client;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-08T12:04:06+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientResponse toResponse(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientResponse.ClientResponseBuilder clientResponse = ClientResponse.builder();

        clientResponse.id( client.getId() );
        clientResponse.name( client.getName() );
        clientResponse.type( client.getType() );
        clientResponse.contact( client.getContact() );
        clientResponse.createdAt( client.getCreatedAt() );

        return clientResponse.build();
    }
}
