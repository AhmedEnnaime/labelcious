package com.labelvie.lablecious.backend.repository;

import com.labelvie.lablecious.backend.models.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
