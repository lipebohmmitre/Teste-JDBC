package org.example.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

    public static Connection criarConexao(){
        final String URL = "jdbc:mysql://localhost:3306/teste_jdbc?verifyServerCertificate=false&useSSL=true";
        final String USER = "root";
        final String PASSWORD = "root";

        try {
            Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado ao Banco de Dados!");

            return conexao;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
