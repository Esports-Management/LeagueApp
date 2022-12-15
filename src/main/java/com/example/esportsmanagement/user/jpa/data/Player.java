package com.example.esportsmanagement.user.jpa.data;

import com.example.esportsmanagement.user.jpa.data.user.UserEntity;

import java.util.ArrayList;

public class Player extends UserEntity {
    ArrayList<String> summonerName;
    ArrayList<String> position;
    Team team;
    int gamesPlayed;
    int gamesWon;
    int gamesLost;
    double kda;

    public Player() {
    }

    public ArrayList<String> getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(ArrayList<String> summonerName) {
        this.summonerName = summonerName;
    }

    public ArrayList<String> getPosition() {
        return position;
    }

    public void setPosition(ArrayList<String> position) {
        this.position = position;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    public double getKda() {
        return kda;
    }

    public void setKda(double kda) {
        this.kda = kda;
    }
}
