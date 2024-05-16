package org.example.criarTabelas;

import org.example.conexao.FabricaConexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriacaoTabelaUser {
    private Connection conexao;
    final private String SQL = """
                CREATE TABLE IF NOT EXISTS users (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(80) NOT NULL
                )
            """;

    public CriacaoTabelaUser(){
        this.conexao = FabricaConexao.criarConexao();
    }

    public void criarTabela(){
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();
            stmt.execute(SQL);

            System.out.println("Tabela Criada com Sucesso!");

            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
