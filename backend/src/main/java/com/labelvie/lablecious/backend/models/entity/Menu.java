package com.labelvie.lablecious.backend.models.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "menus")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private Date date;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private Set<MenuPlate> menuPlates;


}
