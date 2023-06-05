package com.labelvie.lablecious.backend.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "plates")
public class Plate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String  description;

    @Column
    private String image;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_id", nullable = false, referencedColumnName = "id")
    private Category category;

    @OneToMany(mappedBy = "plate", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "plate")
    private List<MenuPlate> menus;

    @OneToMany(mappedBy = "plate", cascade = CascadeType.ALL)
    private List<OrderPlate> orders;
}
