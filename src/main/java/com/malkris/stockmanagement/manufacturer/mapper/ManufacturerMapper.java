package com.malkris.stockmanagement.manufacturer.mapper;

import com.malkris.stockmanagement.manufacturer.dto.ManufacturerResponse;
import com.malkris.stockmanagement.manufacturer.entity.Manufacturer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManufacturerMapper {

    ManufacturerResponse toResponse(
            Manufacturer manufacturer
    );
}