package Data;

import java.util.ArrayList;

public class TeamInMatch {
    Team team;
    ArrayList<Champion> bans;
    boolean win;

    public TeamInMatch(Team team, ArrayList<Champion> bans, boolean win) {
        this.team = team;
        this.bans = bans;
        this.win = win;
    }

    public TeamInMatch(Team team, ArrayList<Champion> bans) {
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

    public ArrayList<Champion> getBans() {
        return bans;
    }

    public void setBans(ArrayList<Champion> bans) {
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
