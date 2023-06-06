package com.labelvie.lablecious.backend.models.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
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

/*
INSERT INTO categories (name, description, price) VALUES ('Entrées', 'Les entrées sont des plats qui sont servis avant le plat principal.', 5.00);

 */

/*
docker compose: (remove the container and the image) and start again
docker-compose down


docker-compose up --build

 */