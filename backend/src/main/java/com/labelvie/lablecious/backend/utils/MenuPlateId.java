package com.labelvie.lablecious.backend.utils;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class MenuPlateId implements Serializable {

    @Column(name = "menu_id")
    private Long menuId;

    @Column(name = "plate_id")
    private Long plateId;
}
