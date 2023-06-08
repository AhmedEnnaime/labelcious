package com.labelvie.lablecious.backend.models.entity;

import com.labelvie.lablecious.backend.utils.OrderPlateId;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "order_plate")
@NoArgsConstructor
public class OrderPlate {

    @EmbeddedId
    private OrderPlateId id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @MapsId("plateId")
    @JoinColumn(name = "plate_id")
    private Plate plate;

    private int quantity;
}
