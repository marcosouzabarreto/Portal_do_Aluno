package databaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    public List<Aluno> buscar(Aluno c) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id_aluno, nome_aluno, password_aluno ");
        sql.append("FROM tabela_aluno ");
        sql.append("WHERE nome_aluno LIKE ? ");
        sql.append("ORDER BY nome_aluno ");

        Connection conn = ConexaoMySQL.abrir();

        PreparedStatement comando = conn.prepareStatement(sql.toString());
        comando.setString(1, "%" + c.getNomealuno()+ "%");

        ResultSet resultado = comando.executeQuery();

        List<Aluno> lista = new ArrayList<Aluno>();

        while (resultado.next()) {

            Aluno linha = new Aluno();
            linha.setIdaluno(resultado.getInt("cod_aluno"));
            linha.setNomealuno(resultado.getString("nome_aluno"));
            linha.setPasswordaluno(resultado.getString("password_aluno"));
            linha.setEmailaluno(resultado.getString("email_aluno"));

            lista.add(linha);
        }

        resultado.close();
        comando.close();
        conn.close();

        return lista;
    }

    public void criar(String username, String email, char[] password) {
        // Create student in database
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE aluno");
        sql.append("id_aluno INT NOT NULL AUTO_INCREMENT, ");
        sql.append(" email VARCHAR(80) NOT NULL,");
        sql.append(" senha INT(20) NOT NULL,  ");
        sql.append("PRIMARY KEY(id_aluno)\n");
    }

}
