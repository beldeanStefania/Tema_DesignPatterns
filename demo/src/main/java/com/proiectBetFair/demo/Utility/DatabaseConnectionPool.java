package com.proiectBetFair.demo.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionPool {
    private static DatabaseConnectionPool instance;
    private String jdbcUrl;
    private String username;
    private String password;

    // Assume a pool of connections
    private static final int MAX_CONNECTIONS = 1;
    private Connection[] connections;
    private boolean[] inUse;

    // Private constructor to prevent instantiation
    private DatabaseConnectionPool() {
        // Initialize connection pool here
        initializeConnectionPool();
    }

    public static synchronized DatabaseConnectionPool getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionPool();
        }
        return instance;
    }

    private void initializeConnectionPool() {
        // Load database properties from your configuration
        jdbcUrl = "jdbc:postgresql://localhost:5432/employees";
        username = "postgres";
        password = "postgres";

        // Initialize the connection pool
        connections = new Connection[MAX_CONNECTIONS];
        inUse = new boolean[MAX_CONNECTIONS];

        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            try {
                connections[i] = DriverManager.getConnection(jdbcUrl, username, password);
                inUse[i] = false;
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle exception (e.g., log it or throw a runtime exception)
            }
        }
    }

    public synchronized Connection getConnection() throws SQLException {
        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            if (!inUse[i]) {
                inUse[i] = true;
                return connections[i];
            }
        }
        throw new SQLException("No available connections in the pool");
    }

    public synchronized void releaseConnection(Connection connection) {
        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            if (connections[i] == connection) {
                inUse[i] = false;
                break;
            }
        }
    }
}
