package com.example.esportsmanagement.user.jpa.data;
import java.sql.*;
import com.example.esportsmanagement.web.controller.match.config;

public class ManageDatabase {

    public static void createPlayerTable() throws SQLException {
        Connection connection = connect();
        createPlayerStatsTable(connection);
        createPlayersInTable(connection);
        updateStats(connection);
        if(connection != null) {
            connection.close();
            System.out.println("Disconnected from the database");
        }
    }
    public static Connection connect(){
        Connection connection = null;
        try
        {
            String url = config.getUrl();
            connection = DriverManager.getConnection(url);
            System.out.println("Connected to the database");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Connection failed");
        }
        return connection;
    }
    public static ResultSet getData(Connection connection){
        String sql = "SELECT * FROM match_statistics";
        ResultSet results;
        try{
            Statement statement = connection.createStatement();
            results = statement.executeQuery(sql);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
        return results;
    }
    public static void createPlayerStatsTable(Connection connection){
        String sql = "DROP TABLE player_statistics";
        try{
            Statement statement = connection.createStatement();
            statement.execute(sql);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        sql = "CREATE TABLE player_statistics (" +
                "username VARCHAR(255) PRIMARY KEY," +
                " games_played INT," +
                " kills INT," +
                " deaths INT," +
                " assists INT," +
                " kda DECIMAL(10,1)," +
                " first_blood_kill INT," +
                " penta_kills INT" +
                ")";
        try{
            Statement statement = connection.createStatement();
            statement.execute(sql);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void createPlayersInTable(Connection connection){
        ResultSet results = getData(connection);
        String sql;
        try {
            Statement statement = connection.createStatement();
            while (results.next()) {
                sql = "INSERT IGNORE INTO player_statistics (username) VALUES (\"" + results.getString("summoner_name") + "\")";
                statement.execute(sql);
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void updateStats(Connection connection){
        String sql;
        ResultSet statistics;
        ResultSet results = getData(connection);
        try {
            sql = "SELECT * FROM player_statistics";
            Statement statement = connection.createStatement();
            statistics = statement.executeQuery(sql);
            while(results.next()){
                updateStatsByColumn(connection, statement, results, "games_played");
                updateStatsByColumn(connection, statement, results, "kills");
                updateStatsByColumn(connection, statement, results, "deaths");
                updateStatsByColumn(connection, statement, results, "assists");
                updateStatsByColumn(connection, statement, results, "first_blood_kill");
                updateStatsByColumn(connection, statement, results, "penta_kills");
                updateKda(connection, statement, results);
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void updateStatsByColumn(Connection connection, Statement statement, ResultSet results, String column) {
        int tempInt = 0;
        try {
            String sql = "SELECT " + column + " FROM player_statistics WHERE username = \"" + results.getString("summoner_name") + "\"";
            ResultSet tempRS = statement.executeQuery(sql);
            tempRS.next();
            if(column == "games_played"){
                tempInt = tempRS.getInt(column) + 1;
            }
            else{
                tempInt = tempRS.getInt(column) + results.getInt(column);
            }
            sql = "UPDATE player_statistics SET " + column + " = " + tempInt + " WHERE username = \"" + results.getString("summoner_name") + "\"";
            statement.execute(sql);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void updateKda(Connection connection, Statement statement, ResultSet results) {
        double tempDouble = 0;
        try {
            String sql = "SELECT * FROM player_statistics WHERE username = \"" + results.getString("summoner_name") + "\"";
            ResultSet tempRs = statement.executeQuery(sql);
            tempRs.next();
            int deaths = tempRs.getInt("deaths");
            if (deaths == 0){
                deaths = 1;
            }
            tempDouble = (tempRs.getInt("kills") + tempRs.getInt("assists")) /(double)deaths;
            sql = "UPDATE player_statistics SET kda = " + tempDouble + " WHERE username = \"" + results.getString("summoner_name") + "\"";
            statement.execute(sql);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
