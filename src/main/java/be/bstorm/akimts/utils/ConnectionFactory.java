package be.bstorm.akimts.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private final static String URL = "jdbc:postgresql://localhost:5432/northwind";
    private final static String USER = "postgres";
    private final static String PSWD = "pass";

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PSWD);
    }

}
