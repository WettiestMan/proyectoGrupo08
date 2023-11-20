package com.grupo06.Connector;

import com.grupo06.Config.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    public Connection getConnection(String databaseName) {
        try {
            Connection connection = DriverManager.getConnection(Config.URL + databaseName,
                    Config.USERNAME, Config.PASSWORD);

            return connection;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}
