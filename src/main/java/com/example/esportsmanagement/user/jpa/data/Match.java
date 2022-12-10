package com.example.esportsmanagement.user.jpa.data;

import java.util.ArrayList;

public class Match {
    GameCode gameCode;
    Team teamA;
    Team teamB;
    ArrayList<PlayerInMatch> playersA;
    ArrayList<PlayerInMatch> playersB;
    long gameDuration;

    public Match(GameCode gameCode, Team teamA, Team teamB, ArrayList<PlayerInMatch> playersA, ArrayList<PlayerInMatch> playersB, long gameDuration) {
        this.gameCode = gameCode;
        this.teamA = teamA;
        this.teamB = teamB;
        this.playersA = playersA;
        this.playersB = playersB;
        this.gameDuration = gameDuration;
    }

    public Match(GameCode gameCode, Team teamA, Team teamB, ArrayList<PlayerInMatch> playersA, ArrayList<PlayerInMatch> playersB) {
        this.gameCode = gameCode;
        this.teamA = teamA;
        this.teamB = teamB;
        this.playersA = playersA;
        this.playersB = playersB;
    }

    public Match(GameCode gameCode, Team teamA, Team teamB) {
        this.gameCode = gameCode;
        this.teamA = teamA;
        this.teamB = teamB;
    }

    public Match(GameCode gameCode) {
        this.gameCode = gameCode;
    }

    public Match() {
    }

    public GameCode getTournamentCode() {
        return gameCode;
    }

    public void setTournamentCode(GameCode gameCode) {
        this.gameCode = gameCode;
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public ArrayList<PlayerInMatch> getPlayersA() {
        return playersA;
    }

    public void setPlayersA(ArrayList<PlayerInMatch> playersA) {
        this.playersA = playersA;
    }

    public ArrayList<PlayerInMatch> getPlayersB() {
        return playersB;
    }

    public void setPlayersB(ArrayList<PlayerInMatch> playersB) {
        this.playersB = playersB;
    }

    public long getGameDuration() {
        return gameDuration;
    }

    public void setGameDuration(long gameDuration) {
        this.gameDuration = gameDuration;
    }

    public void addPlayerA(PlayerInMatch player) {
        playersA.add(player);
    }

    public void addPlayerB(PlayerInMatch player) {
        playersB.add(player);
    }

    public void addPlayersA(ArrayList<PlayerInMatch> players) {
        playersA.addAll(players);
    }

    public void addPlayersB(ArrayList<PlayerInMatch> players) {
        playersB.addAll(players);
    }


}
