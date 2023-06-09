package com.labelvie.lablecious.backend.models.dto;

import com.labelvie.lablecious.backend.models.entity.OrderPlate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderPlateDto {

    private Long orderId;
    private Long plateId;
    private int quantity;

    public static OrderPlateDto fromOrderPlate(OrderPlate orderPlate) {
        return OrderPlateDto.builder()
                .orderId(orderPlate.getOrder().getId())
                .plateId(orderPlate.getPlate().getId())
                .quantity(orderPlate.getQuantity())
                .build();
    }
}
