package com.labelvie.lablecious.backend.models.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "plates")
public class Plate{

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
    @JoinColumn(name = "category_id", nullable = false, referencedColumnName = "id")
    private Category category;

    @OneToMany(mappedBy = "plate", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "plate", cascade = CascadeType.ALL)
    private Set<MenuPlate> menuPlates;

}


