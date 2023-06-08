package com.labelvie.lablecious.backend.services;

import com.labelvie.lablecious.backend.models.dto.OrderDto;
import com.labelvie.lablecious.backend.models.dto.OrderPlateDto;

import java.util.List;

public interface OrderPlateService {

    List<OrderPlateDto> getOrdersPlates();

    OrderPlateDto saveOrderPlate(OrderPlateDto orderPlateDto);
}
