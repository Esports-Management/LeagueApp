package com.example.esportsmanagement.user.jpa.data;

import jakarta.persistence.*;

@Embeddable
public class UserRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

}
