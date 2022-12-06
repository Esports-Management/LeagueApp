package com.example.esportsmanagement.user.jpa.data;

import jakarta.persistence.*;


@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String nickName;
    @Column(unique = true)
    private String email;
    private String password;

    public UserEntity() {
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
