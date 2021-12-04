package databaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {

    public List<Professor> buscar(Professor c) throws Exception {

        String sql = new StringBuilder().append("SELECT id_professor, nome_professor, password_professor ").append("FROM tabela_professor ").append("WHERE nome_professor LIKE ? ").append("ORDER BY nome_professor ").toString();

        Connection conn = ConexaoMySQL.abrir();

        PreparedStatement comando = conn.prepareStatement(sql);
        comando.setString(1, "%" + c.getNomeprofessor()+ "%");

        ResultSet resultado2 = comando.executeQuery();

        List<Professor> lista = new ArrayList<Professor>();

        while (resultado2.next()) {

            Professor linha = new Professor();
            linha.setIdprofessor(resultado2.getInt("cod_professor"));
            linha.setNomeprofessor(resultado2.getString("nome_professor"));
            linha.setPasswordprofessor(resultado2.getString("password_professor"));
            linha.setEmailprofessor(resultado2.getString("email_aluno"));

            lista.add(linha);
        }

        resultado2.close();
        comando.close();
        conn.close();

        return lista;
    }

    public void criar(String username, String email, char[] password) {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE professor");
        sql.append("id_professor INT NOT NULL AUTO_INCREMENT, ");
        sql.append(" email VARCHAR(80) NOT NULL,");
        sql.append(" senha INT(20) NOT NULL,  ");
        sql.append("PRIMARY KEY(id_professor)");
    }
}
