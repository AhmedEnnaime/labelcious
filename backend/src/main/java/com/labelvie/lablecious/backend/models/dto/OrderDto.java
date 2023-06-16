package com.labelvie.lablecious.backend.models.dto;

import com.labelvie.lablecious.backend.models.entity.Order;
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

    public static OrderDto fromOrder(Order order) {


        return OrderDto.builder()
                .id(order.getId())
                .user_id(order.getUser().getId())

                .build();
    }

    public static List<OrderDto> fromOrders(List<Order> orders) {
        return orders.stream()
                .map(OrderDto::fromOrder)
                .collect(Collectors.toList());
    }
}