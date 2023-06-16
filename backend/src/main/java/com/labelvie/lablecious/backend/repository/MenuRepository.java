package com.labelvie.lablecious.backend.repository;

import com.labelvie.lablecious.backend.models.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByDate(Date date);
}
