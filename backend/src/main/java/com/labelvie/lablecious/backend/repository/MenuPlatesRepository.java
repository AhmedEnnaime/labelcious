package com.labelvie.lablecious.backend.repository;

import com.labelvie.lablecious.backend.models.entity.Menu;
import com.labelvie.lablecious.backend.models.entity.MenuPlates;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuPlatesRepository extends JpaRepository<MenuPlates, Long> {
    List<MenuPlates> findByMenu(Menu menu);
    void deleteByMenu(Menu menu);

}
