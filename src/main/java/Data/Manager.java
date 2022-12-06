package Data;

public class Manager extends User{
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
