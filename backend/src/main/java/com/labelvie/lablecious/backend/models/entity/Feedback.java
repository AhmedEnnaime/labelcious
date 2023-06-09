package com.labelvie.lablecious.backend.models.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "message", nullable = false)
    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "plate_id", nullable = false, referencedColumnName = "id")
    private Plate plate;
}
