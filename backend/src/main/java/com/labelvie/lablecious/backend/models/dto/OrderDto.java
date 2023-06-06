package com.labelvie.lablecious.backend.models.dto;

import com.labelvie.lablecious.backend.models.entity.Order;
import com.labelvie.lablecious.backend.models.entity.OrderPlate;
import com.labelvie.lablecious.backend.models.entity.User;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private long id;

    @NotNull(message = "User is required")
    private User user;

    @NotNull(message = "Order cannot be send without plates")
    private List<OrderPlate> plates;

    @NotBlank
    @Min(value = 0, message = "Price must be a positive number")
    private double total;

    public static OrderDto fromOrder(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .user(order.getUser())
                .plates(order.getPlates())
                .total(order.getTotal())
                .build();
    }

    public static List<OrderDto> fromOrders(List<Order> orders) {
        return orders.stream()
                .map(OrderDto::fromOrder)
                .collect(Collectors.toList());
    }
}
