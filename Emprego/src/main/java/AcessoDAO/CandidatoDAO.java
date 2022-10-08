package AcessoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import ConnectionFA.ConnectionFactory;
import com.example.emprego.Candidato;

public class CandidatoDAO {

    public void savecand (Candidato candidato){
        String sql = "INSERT INTO candidato (nome_candidato, cpf, data_nasc, telefone, pret_salarial) VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, candidato.getNome());
            pstm.setLong(2, candidato.getCpf());
            pstm.setString(3, candidato.getDataNac());
            pstm.setLong(4, candidato.getTelefone());
            pstm.setFloat(5, candidato.getPretSalarial());

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

    public void saveusucand (Candidato candidato){
        String sql = "INSERT INTO usuario (email, senha, cpf_candidato_usu) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, candidato.getEmail());
            pstm.setString(2, candidato.getSenha());
            pstm.setLong(3, candidato.getCpf());


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
