package com.example.esportsmanagement.user.jpa.data;
import com.example.esportsmanagement.user.jpa.data.Manager;
import com.example.esportsmanagement.user.jpa.data.Player;

import java.util.ArrayList;

public class Team {
    String name;
    Manager manager;
    ArrayList<Player> players;
    int wins;
    int losses;
    int points;
    int currentRanking;

    public Team(String name, Manager manager, ArrayList<Player> players, int wins, int losses, int points, int currentRanking) {
        this.name = name;
        this.manager = manager;
        this.players = players;
        this.wins = wins;
        this.losses = losses;
        this.points = points;
        this.currentRanking = currentRanking;
    }

    public Team(String name, Manager manager, ArrayList<Player> players, int wins, int losses, int points) {
        this.name = name;
        this.manager = manager;
        this.players = players;
        this.wins = wins;
        this.losses = losses;
        this.points = points;
    }

    public Team(String name, Manager manager, ArrayList<Player> players, int wins, int losses) {
        this.name = name;
        this.manager = manager;
        this.players = players;
        this.wins = wins;
        this.losses = losses;
    }

    public Team(String name, Manager manager, ArrayList<Player> players) {
        this.name = name;
        this.manager = manager;
        this.players = players;
    }

    public Team(String name, Manager manager) {
        this.name = name;
        this.manager = manager;
    }

    public Team(String name) {
        this.name = name;
    }

    public Team() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getCurrentRanking() {
        return currentRanking;
    }

    public void setCurrentRanking(int currentRanking) {
        this.currentRanking = currentRanking;
    }

    public String toString() {
        return name;
    }


}
