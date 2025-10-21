package com.group.activities.bowling.entity;

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
