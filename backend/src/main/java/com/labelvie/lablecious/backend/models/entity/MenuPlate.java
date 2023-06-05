package com.labelvie.lablecious.backend.models.entity;

import com.labelvie.lablecious.backend.utils.MenuPlateId;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "menu_plate")
public class MenuPlate {

    @EmbeddedId
    private MenuPlateId id;

    @ManyToOne
    @MapsId("menuId")
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @ManyToOne
    @MapsId("plateId")
    @JoinColumn(name = "plate_id")
    private Plate plate;

    private int quantity;

}
