package com.labelvie.lablecious.backend.services.impl;

import com.labelvie.lablecious.backend.models.dto.OrderDto;
import com.labelvie.lablecious.backend.models.entity.Order;
import com.labelvie.lablecious.backend.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {


    @Override
    public List<OrderDto> getOrders() {
        return null;
    }

    @Override
    public OrderDto getOrderById(long id) {
        return null;
    }

    @Override
    public void deleteOrder(long id) {

    }

    @Override
    public Order findOrFail(long id) {
        return null;
    }
}

