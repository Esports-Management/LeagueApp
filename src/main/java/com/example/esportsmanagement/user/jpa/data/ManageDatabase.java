package com.example.esportsmanagement.user.jpa.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManageDatabase {

    public static void main(String[] args) {
        Connection connection = connect();
        insertData("Test5", connection);
    }
    public static void insertInto(String table){

    }
    public static Connection connect(){
        Connection connection = null;
        try
        {
            String url = "jdbc:mysql://localhost:3306/Users_db?user=root";
            connection = DriverManager.getConnection(url);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Connection failed");
        }
        return connection;
    }

    public static void insertData(String field, Connection connection){
        String sql = "INSERT INTO test(field)" + "VALUES (?);";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, field);
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
