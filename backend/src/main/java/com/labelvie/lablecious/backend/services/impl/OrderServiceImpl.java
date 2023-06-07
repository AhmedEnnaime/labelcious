package com.labelvie.lablecious.backend.services.impl;

import com.labelvie.lablecious.backend.exceptions.handler.ResourceNotFoundException;
import com.labelvie.lablecious.backend.models.dto.OrderDto;
import com.labelvie.lablecious.backend.models.entity.Order;
import com.labelvie.lablecious.backend.models.entity.OrderPlate;
import com.labelvie.lablecious.backend.repository.OrderRepository;
import com.labelvie.lablecious.backend.services.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderDto> getOrders() {
        List<Order> orders = orderRepository.findAll();
        return OrderDto.fromOrders(orders);
    }

    @Override
    public OrderDto saveOrder(OrderDto orderDto) {
        Order order = new Order();
        updateOrderFromDto(orderDto, order);
        Order savedOrder = orderRepository.save(order);
        return OrderDto.fromOrder(savedOrder);
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto, long id) {
        Order existingOrder = findOrFail(id);
        updateOrderFromDto(orderDto, existingOrder);
        Order updatedOrder = orderRepository.save(existingOrder);
        return OrderDto.fromOrder(updatedOrder);
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

        double total = calculateTotal(orderDto.getPlates());
        order.setTotal(total);

        for (OrderPlate orderPlate : orderDto.getPlates()) {
            orderPlate.setOrder(order);
        }
    }

    private double calculateTotal(List<OrderPlate> orderPlates) {
        double total = 0.0;
        for (OrderPlate orderPlate : orderPlates) {
            double plateTotal = orderPlate.getPlate().getCategory().getPrice() * orderPlate.getQuantity();
            total += plateTotal;
        }
        return total;
    }
}
