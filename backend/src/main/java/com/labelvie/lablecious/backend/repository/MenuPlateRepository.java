package com.labelvie.lablecious.backend.repository;

import com.labelvie.lablecious.backend.models.entity.MenuPlate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuPlateRepository extends JpaRepository<MenuPlate, Long> {
}
