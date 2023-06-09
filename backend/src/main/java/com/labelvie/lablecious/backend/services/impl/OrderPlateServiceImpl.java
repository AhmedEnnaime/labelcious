package com.labelvie.lablecious.backend.services.impl;

import com.labelvie.lablecious.backend.exceptions.handler.ResourceNotFoundException;
import com.labelvie.lablecious.backend.models.dto.OrderDto;
import com.labelvie.lablecious.backend.models.dto.OrderPlateDto;
import com.labelvie.lablecious.backend.models.entity.Order;
import com.labelvie.lablecious.backend.models.entity.OrderPlate;
import com.labelvie.lablecious.backend.models.entity.Plate;
import com.labelvie.lablecious.backend.repository.OrderPlateRepository;
import com.labelvie.lablecious.backend.repository.PlateRepository;
import com.labelvie.lablecious.backend.services.OrderPlateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderPlateServiceImpl implements OrderPlateService {

    private final OrderPlateRepository orderPlateRepository;

    private final PlateRepository plateRepository;

    public OrderPlateServiceImpl(OrderPlateRepository orderPlateRepository, PlateRepository plateRepository) {
        this.orderPlateRepository = orderPlateRepository;
        this.plateRepository = plateRepository;
    }

    @Override
    public List<OrderPlateDto> getOrdersPlates() {
        return null;
    }

    @Override
    public OrderPlateDto saveOrderPlate(OrderPlateDto orderPlateDto) {
        OrderPlate orderPlate = new OrderPlate();

        return null;
    }

    public void updateOrderPlateFromDto(OrderDto orderDto, Order order) {

        List<OrderPlateDto> orderPlateDtos = orderDto.getPlates();

        for (OrderPlateDto orderPlateDto : orderPlateDtos) {
            Plate plate = plateRepository.findById(orderPlateDto.getPlateId())
                    .orElseThrow(() -> new ResourceNotFoundException("Plate not found with ID: " + orderPlateDto.getPlateId()));

//            System.out.println(plate);
//            System.exit(0);
            OrderPlate orderPlate = new OrderPlate();
            orderPlate.setOrder(order);
            orderPlate.setPlate(plate);
            orderPlate.setQuantity(orderPlateDto.getQuantity());

        }

    }
}
