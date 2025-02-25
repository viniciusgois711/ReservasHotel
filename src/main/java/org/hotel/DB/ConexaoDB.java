package org.hotel.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    private static final String url = "jdbc:postgresql://localhost:5432/hotel";
    private static final String usuario = "postgres";
    private static final String senha = "0009";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, usuario, senha);
    }
}
