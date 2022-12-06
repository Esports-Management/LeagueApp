package Data;

public class PlayerInSeason {
    Player player;
    int gamesPlayed;
    int totalKills;
    int totalDeaths;
    int totalAssists;
    double kda;
    int killParticipation;
    int firstBloods;
    int totalPentaKills;
    double goldPerMinute;
    double minionsPerMinute;
    double visionScorePerMinute;

    public PlayerInSeason() {
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getTotalKills() {
        return totalKills;
    }

    public void setTotalKills(int totalKills) {
        this.totalKills = totalKills;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public int getTotalAssists() {
        return totalAssists;
    }

    public void setTotalAssists(int totalAssists) {
        this.totalAssists = totalAssists;
    }

    public double getKda() {
        return kda;
    }

    public void setKda(double kda) {
        this.kda = kda;
    }

    public int getKillParticipation() {
        return killParticipation;
    }

    public void setKillParticipation(int killParticipation) {
        this.killParticipation = killParticipation;
    }

    public int getFirstBloods() {
        return firstBloods;
    }

    public void setFirstBloods(int firstBloods) {
        this.firstBloods = firstBloods;
    }

    public int getTotalPentaKills() {
        return totalPentaKills;
    }

    public void setTotalPentaKills(int totalPentaKills) {
        this.totalPentaKills = totalPentaKills;
    }

    public double getGoldPerMinute() {
        return goldPerMinute;
    }

    public void setGoldPerMinute(double goldPerMinute) {
        this.goldPerMinute = goldPerMinute;
    }

    public double getMinionsPerMinute() {
        return minionsPerMinute;
    }

    public void setMinionsPerMinute(double minionsPerMinute) {
        this.minionsPerMinute = minionsPerMinute;
    }

    public double getVisionScorePerMinute() {
        return visionScorePerMinute;
    }

    public void setVisionScorePerMinute(double visionScorePerMinute) {
        this.visionScorePerMinute = visionScorePerMinute;
    }
}
