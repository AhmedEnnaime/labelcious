package com.labelvie.lablecious.backend.models.dto;

import com.labelvie.lablecious.backend.models.entity.Order;
import com.labelvie.lablecious.backend.models.entity.OrderPlate;
import com.labelvie.lablecious.backend.models.entity.User;
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
    private Long user_id;

    @NotNull(message = "Order cannot be sent without plates")
    private List<OrderPlateDto> plates;

    public static OrderDto fromOrder(Order order) {
        List<OrderPlateDto> orderPlateDtos = order.getPlates().stream()
                .map(OrderPlateDto::fromOrderPlate)
                .collect(Collectors.toList());

        return OrderDto.builder()
                .id(order.getId())
                .user_id(order.getUser().getId())
                .plates(orderPlateDtos)
                .build();
    }

    public static List<OrderDto> fromOrders(List<Order> orders) {
        return orders.stream()
                .map(OrderDto::fromOrder)
                .collect(Collectors.toList());
    }
}