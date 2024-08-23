package com.codewithprem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/ajava";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "p@ssword";
    private static final String DRIVER = "org.postgresql.Driver";
    private static Connection connection;

    private DbConnection() {
        // private constructor to prevent instantiation
    }

    public static Connection getConnection() {
        if (connection == null) {
            synchronized (DbConnection.class) {
                if (connection == null) {
                    try {
                        Class.forName(DRIVER);
                        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }

}
