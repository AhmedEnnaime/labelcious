package com.labelvie.lablecious.backend.repository;

import com.labelvie.lablecious.backend.models.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
