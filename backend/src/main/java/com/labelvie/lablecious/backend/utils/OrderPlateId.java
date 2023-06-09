package com.labelvie.lablecious.backend.utils;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class OrderPlateId implements Serializable {

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "plate_id")
    private Long plateId;

}
