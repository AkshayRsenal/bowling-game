package com.group.activities.bowling.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public interface IPlayer {
    Long getId();
    String getFirstName();
    String getLastName();
    String getEmail();

    // @Column(name = "first_name")
    // private String firstName;

    // @Column(name = "last_name")
    // private String lastName;

    // @Column(name = "email_id", unique = true)
    // private String email;

    //TODO: implement the Player entity with JPA annotations
}
