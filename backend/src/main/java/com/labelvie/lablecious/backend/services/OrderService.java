package com.labelvie.lablecious.backend.services;

import com.labelvie.lablecious.backend.models.dto.OrderDto;
import com.labelvie.lablecious.backend.models.entity.Order;

import java.util.List;

public interface OrderService {

    List<OrderDto> getOrders();

//    OrderDto saveOrder(OrderDto orderDto);

//    OrderDto updateOrder(OrderDto orderDto, long id);

    OrderDto getOrderById(long id);

    void deleteOrder(long id);

    Order findOrFail(long id);
}
