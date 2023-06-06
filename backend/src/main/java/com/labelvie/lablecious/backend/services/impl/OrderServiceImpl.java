package com.labelvie.lablecious.backend.services.impl;

import com.labelvie.lablecious.backend.exceptions.handler.ResourceNotFoundException;
import com.labelvie.lablecious.backend.models.dto.OrderDto;
import com.labelvie.lablecious.backend.models.entity.Order;
import com.labelvie.lablecious.backend.repository.OrderRepository;
import com.labelvie.lablecious.backend.services.OrderService;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderDto> getOrders() {
        List<Order> orders = orderRepository.findAll();
        return OrderDto.fromOrders(orders);
    }

    @Override
    public OrderDto saveOrder(OrderDto order) {
        return null;
    }

    @Override
    public OrderDto updateOrder(OrderDto order, long id) {
        return null;
    }

    @Override
    public OrderDto getOrderById(long id) {
        return OrderDto.fromOrder(this.findOrFail(id));
    }

    @Override
    public void deleteOrder(long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        optionalOrder.ifPresent(order -> orderRepository.delete(order));
    }

    @Override
    public Order findOrFail(long id) {
        return orderRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("The Order with id " + id + " does not exist"));
    }

    private void updateOrderFromDto(OrderDto orderDto, Order order) {
        order.setUser(orderDto.getUser());
        order.setPlates(orderDto.getPlates());
        order.setTotal(orderDto.getTotal());
    }
}
