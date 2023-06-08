package com.labelvie.lablecious.backend.repository;

import com.labelvie.lablecious.backend.models.entity.OrderPlate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderPlateRepository extends JpaRepository<OrderPlate, Long> {
}
