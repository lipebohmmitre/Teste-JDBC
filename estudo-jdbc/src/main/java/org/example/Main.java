package org.example;

import org.example.conexao.FabricaConexao;
import org.example.criarTabelas.CriacaoTabelaUser;
import org.example.crud.CrudUsuario;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //CriacaoTabelaUser tabelaUser = new CriacaoTabelaUser();
        //tabelaUser.criarTabela();

        CrudUsuario crud = new CrudUsuario();

        //crud.createUser("Pereira Machado");
        //crud.alterUser(1, "Guilherme Ferreira");
        //crud.deleteUser(2);
        //crud.getUsers();

    }
}