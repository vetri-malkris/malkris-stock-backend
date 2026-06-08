package com.malkris.stockmanagement.manufacturer.repository;

import com.malkris.stockmanagement.manufacturer.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ManufacturerRepository
        extends JpaRepository<Manufacturer, UUID> {
}