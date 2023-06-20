package com.labelvie.lablecious.backend.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    private long id;

    @Column(name = "fname", nullable = false)
    private String firstName;

    @Column(name = "lname", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(name = "img", nullable = true)
    private String image;

    @Column(name = "num", nullable = true)
    private String number;

    @Column(name = "job", nullable = true)
    private String job;

    @Column(name = "role", nullable = false)
    private int role;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    @JsonBackReference
//    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;
}
