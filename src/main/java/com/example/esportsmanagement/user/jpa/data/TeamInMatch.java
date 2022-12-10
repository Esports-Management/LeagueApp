package com.example.esportsmanagement.user.jpa.data;

import com.example.esportsmanagement.user.jpa.data.Team;

import java.util.ArrayList;

public class TeamInMatch {
    Team team;
    ArrayList<String> bans;
    boolean win;

    public TeamInMatch(Team team, ArrayList<String> bans, boolean win) {
        this.team = team;
        this.bans = bans;
        this.win = win;
    }

    public TeamInMatch(Team team, ArrayList<String> bans) {
        this.team = team;
        this.bans = bans;
    }

    public TeamInMatch(Team team) {
        this.team = team;
    }

    public TeamInMatch() {
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public ArrayList<String> getBans() {
        return bans;
    }

    public void setBans(ArrayList<String> bans) {
        this.bans = bans;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public String toString() {
        return team.getName();
    }


}
