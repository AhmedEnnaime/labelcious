package com.labelvie.lablecious.backend.services.impl;

import com.labelvie.lablecious.backend.models.entity.Order;
import com.labelvie.lablecious.backend.repository.OrderRepository;
import com.labelvie.lablecious.backend.services.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getOrders() {
        return null;
    }

    @Override
    public Order saveOrder(Order order) {
        return null;
    }

    @Override
    public Order updateOrder(Order order, long id) {
        return null;
    }

    @Override
    public Order getOrderById(long id) {
        return null;
    }

    @Override
    public void deleteOrder(long id) {

    }
}
