package com.main;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.sql.*;

public class DBWorker {
    private final String URL = "jdbc:mysql://localhost:3306/mydbtest?autoReconnect=true&useSSL=false";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";
    public Connection connection;

    public DBWorker() {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("DB Connected!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void executeInstall(String query){
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ResultSet executeGet(String query) throws SQLException {
        Statement statement;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet res = statement.executeQuery(query);
        return res;
    }
}