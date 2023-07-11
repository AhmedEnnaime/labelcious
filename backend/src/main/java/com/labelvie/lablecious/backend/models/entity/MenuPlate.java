package com.labelvie.lablecious.backend.models.entity;

import com.labelvie.lablecious.backend.utils.MenuPlateId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@Table(name = "menu_plate")
@NoArgsConstructor
public class MenuPlate implements Serializable {

    @EmbeddedId
    private MenuPlateId id;

    @ManyToOne
    @MapsId("menuId")
    private Menu menu;

    @ManyToOne
    @MapsId("plateId")
    private Plate plate;

    private int quantity;

    public MenuPlate(Menu menu, Plate plate) {
        this.id = new MenuPlateId(menu.getId(), plate.getId());
        this.menu = menu;
        this.plate = plate;
    }


}
