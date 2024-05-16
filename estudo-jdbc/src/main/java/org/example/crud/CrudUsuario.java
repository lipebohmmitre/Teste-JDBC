package org.example.crud;

import org.example.conexao.FabricaConexao;
import org.example.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CrudUsuario {
    private Connection conexao;
    private final String[] SQL = new String[]{
            "INSERT INTO users (name) VALUES (?)",
            "UPDATE users SET name = ? WHERE id = ?",
            "DELETE FROM users WHERE id = ?",
            "SELECT * FROM users"
    };

    public CrudUsuario(){
        this.conexao = FabricaConexao.criarConexao();
    }


    public void getUsers(){
        try {
            PreparedStatement stmt = conexao.prepareStatement(SQL[3]);
            ResultSet result = stmt.executeQuery();

            List<User> userList = new ArrayList<>();

            while(result.next())
                userList.add(new User(result.getInt("id"), result.getString("name")));

            for(User u : userList)
                System.out.println(String.format("Id Usuário: %s / Nome Usuário: %s", u.getId(), u.getName()));

            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createUser(String name){
        try {
            PreparedStatement stmt = conexao.prepareStatement(SQL[0]);
            stmt.setString(1, name);
            stmt.execute();

            System.out.println(String.format("Usuário: %s foi inserido com sucesso", name));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterUser(int id, String name){
        try {
            PreparedStatement stmt = conexao.prepareStatement(SQL[1]);
            stmt.setInt(2, id);
            stmt.setString(1, name);
            stmt.execute();

            System.out.println(String.format("O Usuário: %s, com o Id: %s", name, id));

            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(int id){
        try {
            PreparedStatement stmt = conexao.prepareStatement(SQL[2]);
            stmt.setInt(1, id);
            stmt.execute();

            System.out.println("Usuário deletado!");

            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
