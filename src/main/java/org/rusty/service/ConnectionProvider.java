package org.rusty.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionProvider {

    private static volatile ConnectionProvider instance;

    private static final String DB_USER_NAME = "postgres";
    private static final String DB_USER_PASSWORD = "postgres";
    private static final String DB_HOST = "jdbc:postgresql://127.0.0.1:5432/aston_hw_servlet";

    Properties connectionProperties;

    private ConnectionProvider() {
        connectionProperties = new Properties();
        connectionProperties.put("user", DB_USER_NAME);
        connectionProperties.put("password", DB_USER_PASSWORD);
    }

    public static ConnectionProvider getInstance() {
        if (instance == null) {
            synchronized (ConnectionProvider.class) {
                if (instance == null) {
                    instance = new ConnectionProvider();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_HOST, connectionProperties);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
