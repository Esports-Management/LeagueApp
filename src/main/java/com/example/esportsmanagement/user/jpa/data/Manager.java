package com.example.esportsmanagement.user.jpa.data;

import com.example.esportsmanagement.user.jpa.data.user.UserEntity;

public class Manager extends UserEntity {
    Team team;


    public Manager() {
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

}
