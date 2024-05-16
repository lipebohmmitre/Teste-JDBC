package DAO_Project;

public class Main {

    public static void main(String[] args) {

        String sql = "INSERT INTO users (name) VALUES (?)";
        DAO dao = new DAO();

        System.out.println(dao.incluir(sql, "Ronald McDonald"));
        System.out.println(dao.incluir(sql, "Michal Jackson"));
        System.out.println(dao.incluir(sql, "Fabio Akita"));

        dao.fecharConexao();
    }
}
