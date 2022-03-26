package com.br.Maintenance.maintenance.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Factory {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/managerM";
    private static final String USER = "root";
    private static final String PASS = "Feagri@019";

    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);

        }catch (ClassNotFoundException | SQLException exception) {
            throw new RuntimeException("Erro: ", exception);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement pst) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro: ", exception);
        }
    }

}