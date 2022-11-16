package AcessoDAO;

import ConnectionFA.ConnectionFactory;
import com.example.emprego.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CandidaturaDAO {

    public void save (Candidatura candidatura, Usuario usuario){
        String sql = "INSERT INTO candidatura (cargo_candidatura, cpf_candidatura, cod_vaga, data_cand, status_cand, funcionario_cpf) VALUES ( ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, candidatura.getCargo());
            pstm.setLong(2, usuario.getCpf());
            pstm.setInt(3, candidatura.getCodigo());
            pstm.setString(4, candidatura.getData());
            pstm.setString(5, candidatura.getStatus());
            VagaStatic vagastatic = new VagaStatic();
            pstm.setString(6, String.valueOf(vagastatic.getFuncionario()));

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

    public static ObservableList<Candidatura> Datauser(){

        Connection conn = null;
        ResultSet rset = null;

        ObservableList<Candidatura> list = FXCollections.observableArrayList();

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            Usuario usuario = new Usuario();
            PreparedStatement ps = conn.prepareStatement("select cargo_candidatura, data_cand, status_cand from candidatura where cpf_candidatura = ? order by data_cand asc");
            ps.setString(1, String.valueOf(usuario.getCpf()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add((new Candidatura(rs.getString("cargo_candidatura"), rs.getString("data_cand"), rs.getString("status_cand"))));
                }
        }catch (Exception e){

            e.printStackTrace();

        }

        return list;

    }
}
