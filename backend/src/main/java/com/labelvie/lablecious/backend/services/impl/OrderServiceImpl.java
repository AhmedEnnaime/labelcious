package com.labelvie.lablecious.backend.services.impl;

import com.labelvie.lablecious.backend.exceptions.handler.ResourceNotFoundException;
import com.labelvie.lablecious.backend.models.dto.OrderDto;
import com.labelvie.lablecious.backend.models.dto.OrderPlateDto;
import com.labelvie.lablecious.backend.models.entity.Order;
import com.labelvie.lablecious.backend.models.entity.OrderPlate;
import com.labelvie.lablecious.backend.models.entity.Plate;
import com.labelvie.lablecious.backend.models.entity.User;
import com.labelvie.lablecious.backend.repository.OrderPlateRepository;
import com.labelvie.lablecious.backend.repository.OrderRepository;
import com.labelvie.lablecious.backend.repository.PlateRepository;
import com.labelvie.lablecious.backend.repository.UserRepository;
import com.labelvie.lablecious.backend.services.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final PlateRepository plateRepository;

    private final OrderPlateRepository orderPlateRepository;

    private final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PlateRepository plateRepository, OrderPlateRepository orderPlateRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.plateRepository = plateRepository;
        this.orderPlateRepository = orderPlateRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<OrderDto> getOrders() {
        List<Order> orders = orderRepository.findAll();
        return OrderDto.fromOrders(orders);
    }

//    @Override
//    public OrderDto saveOrder(OrderDto orderDto) {
//        Order order = new Order();
//        User user = new User();
//        user.setId(orderDto.getUser_id());
//        order.setUser(user);
//        double total = calculateTotal(orderDto.getPlates());
//        order.setTotal(total);
////        order.setId(1);
////        System.out.println(order);
////        System.exit(1);
//
//
//        List<OrderPlate> orderPlates = new ArrayList<>();
////        System.out.println(order);
////        System.exit(1);
//        for (OrderPlateDto orderPlateDto : orderDto.getPlates()) {
//            OrderPlate orderPlate = new OrderPlate();
//
//            orderPlate.setOrder(order);
//
//            orderPlate.setPlate(plateRepository.findById(orderPlateDto.getPlateId()).orElse(null));
//
//            orderPlate.setQuantity(orderPlateDto.getQuantity());
//
//            orderPlates.add(orderPlate);
//
//        }
//
//        order.setPlates(orderPlates);
//
//        Order savedOrder = orderRepository.save(order);
//        return OrderDto.fromOrder(savedOrder);
//    }




//    @Override
//    public OrderDto updateOrder(OrderDto orderDto, long id) {
//        Order existingOrder = findOrFail(id);
//        updateOrderFromDto(orderDto, existingOrder);
//        Order updatedOrder = orderRepository.save(existingOrder);
//        return OrderDto.fromOrder(updatedOrder);
//    }

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
        return orderRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("The Order with id " + id + " does not exist"));
    }

    private void updateOrderFromDto(OrderDto orderDto, Order order) {
//        User user = new User();
//        user.setId(orderDto.getUser_id());
//        order.setUser(user);
//
//        double total = calculateTotal(orderDto.getPlates());
//        order.setTotal(total);

    }

    private double calculateTotal(List<OrderPlateDto> orderPlateDtos) {
        double total = 0.0;
        for (OrderPlateDto orderPlateDto : orderPlateDtos) {
            Plate plate = plateRepository.findById(orderPlateDto.getPlateId())
                    .orElseThrow(() -> new ResourceNotFoundException("Plate not found with ID: " + orderPlateDto.getPlateId()));
            double plateTotal = plate.getCategory().getPrice() * orderPlateDto.getQuantity();
            total += plateTotal;
        }
        return total;
    }

}

