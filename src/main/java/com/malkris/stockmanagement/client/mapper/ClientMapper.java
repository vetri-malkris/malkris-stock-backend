package com.malkris.stockmanagement.client.mapper;

import com.malkris.stockmanagement.client.dto.ClientResponse;
import com.malkris.stockmanagement.client.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientResponse toResponse(Client client);
}