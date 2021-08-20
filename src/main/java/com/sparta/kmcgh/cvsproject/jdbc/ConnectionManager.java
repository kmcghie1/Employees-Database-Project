package com.sparta.kmcgh.cvsproject.jdbc;

import com.sparta.kmcgh.util.PropertiesLoader;

import java.sql.*;

public class ConnectionManager {
    private static Connection connection;
    public static Connection connectToDB(){
        String url = PropertiesLoader.getProperties().getProperty("url");
        String username = PropertiesLoader.getProperties().getProperty("userName");
        String password = PropertiesLoader.getProperties().getProperty("password");


        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
