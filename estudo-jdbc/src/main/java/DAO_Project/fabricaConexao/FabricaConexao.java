package DAO_Project.fabricaConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

    public static Connection criarConexao(){
        final String URL = "jdbc:mysql://localhost:3306/curso_java?verifyServerCertificate=false&useSSL=true";
        final String USER = "root";
        final String PASSWORD = "root";

        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
