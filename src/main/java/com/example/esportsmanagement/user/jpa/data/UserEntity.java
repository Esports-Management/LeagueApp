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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
