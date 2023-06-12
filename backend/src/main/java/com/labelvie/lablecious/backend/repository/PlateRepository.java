package com.labelvie.lablecious.backend.repository;

import com.labelvie.lablecious.backend.models.entity.Plate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlateRepository extends JpaRepository<Plate, Long> {
    List<Plate> findByCategoryId(long id);
}
