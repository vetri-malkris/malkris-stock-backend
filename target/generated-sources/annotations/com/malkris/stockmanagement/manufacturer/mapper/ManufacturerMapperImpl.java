package com.malkris.stockmanagement.manufacturer.mapper;

import com.malkris.stockmanagement.manufacturer.dto.ManufacturerResponse;
import com.malkris.stockmanagement.manufacturer.entity.Manufacturer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-29T16:58:11+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class ManufacturerMapperImpl implements ManufacturerMapper {

    @Override
    public ManufacturerResponse toResponse(Manufacturer manufacturer) {
        if ( manufacturer == null ) {
            return null;
        }

        ManufacturerResponse.ManufacturerResponseBuilder manufacturerResponse = ManufacturerResponse.builder();

        manufacturerResponse.contact( manufacturer.getContact() );
        manufacturerResponse.createdAt( manufacturer.getCreatedAt() );
        manufacturerResponse.id( manufacturer.getId() );
        manufacturerResponse.name( manufacturer.getName() );

        return manufacturerResponse.build();
    }
}
