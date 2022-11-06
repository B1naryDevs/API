package AcessoDAO;

import ConnectionFA.ConnectionFactory;
import com.example.emprego.Candidato;
import com.example.emprego.Candidatura;
import com.example.emprego.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CandidaturaDAO {

    public void save (Candidatura candidatura, Usuario usuario){
        String sql = "INSERT INTO candidatura (empresa_candidatura, cargo_candidatura, cpf_candidatura, cod_vaga, data_cand, status_cand) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, candidatura.getEmpresa());
            pstm.setString(2, candidatura.getCargo());
            Candidato candidato = new Candidato();
            pstm.setLong(3, usuario.getCpf());
            pstm.setInt(4, candidatura.getCodigo());
            pstm.setString(5, candidatura.getData());
            pstm.setString(6, candidatura.getStatus());

            pstm.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (pstm!=null){
                    pstm.close();
                }

                if (conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
