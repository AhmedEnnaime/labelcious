package com.labelvie.lablecious.backend.controllers;

import com.labelvie.lablecious.backend.models.dto.OrderDto;
import com.labelvie.lablecious.backend.models.dto.OrderPlateDto;
import com.labelvie.lablecious.backend.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getOrders() {
        List<OrderDto> orders = orderService.getOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("id") long id) {
        OrderDto order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrderById(@PathVariable("id") long id) {
        orderService.deleteOrder(id);
        return new  ResponseEntity<String> ("Order deleted successfully", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderDto> saveOrder(@Valid @RequestBody OrderDto orderDto) {
        OrderDto savedOrder = orderService.saveOrder(orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }

    @PutMapping("{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable long id, @Valid @RequestBody OrderDto orderDto) {
        OrderDto updatedOrder = orderService.updateOrder(orderDto, id);
        return ResponseEntity.ok(updatedOrder);
    }

}
