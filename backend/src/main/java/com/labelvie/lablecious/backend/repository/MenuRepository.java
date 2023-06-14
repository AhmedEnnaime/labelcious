package com.labelvie.lablecious.backend.repository;

import com.labelvie.lablecious.backend.models.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
}
