package com.group.activities.bowling.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "employees")
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(name = "first_name")
    // private String firstName;

    // @Column(name = "last_name")
    // private String lastName;

    // @Column(name = "email_id", unique = true)
    // private String email;

    //TODO: implement the Player entity with JPA annotations
}
