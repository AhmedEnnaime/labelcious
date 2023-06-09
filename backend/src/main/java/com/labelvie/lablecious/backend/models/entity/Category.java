package com.labelvie.lablecious.backend.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String  name;

    @Column
    private String description;

    @Column(name = "price", nullable = false)
    private double price;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Plate> plates;

}
