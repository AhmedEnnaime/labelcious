package com.labelvie.lablecious.backend.services;

import com.labelvie.lablecious.backend.models.dto.OrderDto;
import com.labelvie.lablecious.backend.models.entity.Order;

import java.util.List;

public interface OrderService {

    List<OrderDto> getOrders();

    OrderDto saveOrder(OrderDto order);

    OrderDto updateOrder(OrderDto order, long id);

    OrderDto getOrderById(long id);

    void deleteOrder(long id);

    Order findOrFail(long id);
}
