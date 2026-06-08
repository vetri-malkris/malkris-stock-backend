package com.malkris.stockmanagement.manufacturer.mapper;

import com.malkris.stockmanagement.manufacturer.dto.ManufacturerResponse;
import com.malkris.stockmanagement.manufacturer.entity.Manufacturer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-08T12:04:06+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class ManufacturerMapperImpl implements ManufacturerMapper {

    @Override
    public ManufacturerResponse toResponse(Manufacturer manufacturer) {
        if ( manufacturer == null ) {
            return null;
        }

        ManufacturerResponse.ManufacturerResponseBuilder manufacturerResponse = ManufacturerResponse.builder();

        manufacturerResponse.id( manufacturer.getId() );
        manufacturerResponse.name( manufacturer.getName() );
        manufacturerResponse.contact( manufacturer.getContact() );
        manufacturerResponse.createdAt( manufacturer.getCreatedAt() );

        return manufacturerResponse.build();
    }
}
