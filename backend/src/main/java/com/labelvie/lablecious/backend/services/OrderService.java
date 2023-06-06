package com.labelvie.lablecious.backend.services;

import com.labelvie.lablecious.backend.models.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> getOrders();

    Order saveOrder(Order order);

    Order updateOrder(Order order, long id);

    Order getOrderById(long id);

    void deleteOrder(long id);
}
