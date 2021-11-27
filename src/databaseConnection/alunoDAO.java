package databaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class alunoDAO {

    public List<aluno> buscar(aluno c) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id_aluno, nome_aluno, password_aluno ");
        sql.append("FROM tabela_aluno ");
        sql.append("WHERE nome_aluno LIKE ? ");
        sql.append("ORDER BY nome_aluno ");

        Connection conn = ConexaoMySQL.abrir();

        PreparedStatement comando = conn.prepareStatement(sql.toString());
        comando.setString(1, "%" + c.getNomealuno()+ "%");

        ResultSet resultado = comando.executeQuery();

        List<aluno> lista = new ArrayList<aluno>();

        while (resultado.next()) {

            aluno linha = new aluno();
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

}
