package com.labelvie.lablecious.backend.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "menu_plates")
public class MenuPlates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "plate_id", nullable = false, referencedColumnName = "id")
    private Plate plate;

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false, referencedColumnName = "id")
    private Menu menu;
}
