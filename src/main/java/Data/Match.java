package Data;

import java.util.ArrayList;

public class Match {
    TournamentCode tournamentCode;
    Team teamA;
    Team teamB;
    ArrayList<Player> playersA;
    ArrayList<Player> playersB;
    long gameDuration;

    public Match(TournamentCode tournamentCode, Team teamA, Team teamB, ArrayList<Player> playersA, ArrayList<Player> playersB, long gameDuration) {
        this.tournamentCode = tournamentCode;
        this.teamA = teamA;
        this.teamB = teamB;
        this.playersA = playersA;
        this.playersB = playersB;
        this.gameDuration = gameDuration;
    }

    public Match(TournamentCode tournamentCode, Team teamA, Team teamB, ArrayList<Player> playersA, ArrayList<Player> playersB) {
        this.tournamentCode = tournamentCode;
        this.teamA = teamA;
        this.teamB = teamB;
        this.playersA = playersA;
        this.playersB = playersB;
    }

    public Match(TournamentCode tournamentCode, Team teamA, Team teamB) {
        this.tournamentCode = tournamentCode;
        this.teamA = teamA;
        this.teamB = teamB;
    }

    public Match(TournamentCode tournamentCode) {
        this.tournamentCode = tournamentCode;
    }

    public Match() {
    }

    public TournamentCode getTournamentCode() {
        return tournamentCode;
    }

    public void setTournamentCode(TournamentCode tournamentCode) {
        this.tournamentCode = tournamentCode;
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

    public ArrayList<Player> getPlayersA() {
        return playersA;
    }

    public void setPlayersA(ArrayList<Player> playersA) {
        this.playersA = playersA;
    }

    public ArrayList<Player> getPlayersB() {
        return playersB;
    }

    public void setPlayersB(ArrayList<Player> playersB) {
        this.playersB = playersB;
    }

    public long getGameDuration() {
        return gameDuration;
    }

    public void setGameDuration(long gameDuration) {
        this.gameDuration = gameDuration;
    }

    public void addPlayerA(Player player) {
        playersA.add(player);
    }

    public void addPlayerB(Player player) {
        playersB.add(player);
    }

    public void addPlayersA(ArrayList<Player> players) {
        playersA.addAll(players);
    }

    public void addPlayersB(ArrayList<Player> players) {
        playersB.addAll(players);
    }


}
