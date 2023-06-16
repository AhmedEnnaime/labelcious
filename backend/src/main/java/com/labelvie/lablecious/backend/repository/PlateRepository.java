package com.labelvie.lablecious.backend.repository;

import com.labelvie.lablecious.backend.models.entity.Plate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlateRepository extends JpaRepository<Plate, Long> {
    List<Plate> findByCategoryId(long id);

}