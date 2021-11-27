package databaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class professorDAO {

    public List<professor> buscar(professor c) throws Exception {

        String sql = "SELECT id_professor, nome_professor, password_professor " +
                "FROM tabela_professor " +
                "WHERE nome_professor LIKE ? " +
                "ORDER BY nome_professor ";

        Connection conn = ConexaoMySQL.abrir();

        PreparedStatement comando = conn.prepareStatement(sql);
        comando.setString(1, "%" + c.getNomeprofessor()+ "%");

        ResultSet resultado2 = comando.executeQuery();

        List<professor> lista = new ArrayList<professor>();

        while (resultado2.next()) {

            professor linha = new professor();
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
}
