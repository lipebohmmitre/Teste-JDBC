package DAO_Project;

import org.example.conexao.FabricaConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
    private Connection conexao;


    public int incluir(String sql, Object... atributos){
        try {
            PreparedStatement stmt = getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            adicionarAtributosNoStatementPeloTipo(stmt, atributos);

            if(stmt.executeUpdate() > 0){
                ResultSet resultado = stmt.getGeneratedKeys();

                if(resultado.next())
                    return resultado.getInt(1);
            }

            return -1;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void fecharConexao(){
        try {
            getConexao().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            conexao = null;
        }
    }

    private void adicionarAtributosNoStatementPeloTipo(PreparedStatement stmt, Object[] atributos) throws SQLException{
        for(int i = 0; i < atributos.length; i++){
            if(atributos[i] instanceof String)
                stmt.setString((i + 1), (String) atributos[i]);
            else if(atributos[i] instanceof Integer)
                stmt.setInt((i + 1), (Integer) atributos[i]);
        }
    }

    private Connection getConexao(){
        try {
            if(conexao != null && !conexao.isClosed())
                return conexao;
        } catch (SQLException e) {}

        conexao = FabricaConexao.criarConexao();
        return conexao;
    }
}
