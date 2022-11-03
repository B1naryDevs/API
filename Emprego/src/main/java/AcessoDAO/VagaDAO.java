package AcessoDAO;

import ConnectionFA.ConnectionFactory;
import com.example.emprego.Vaga;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VagaDAO {

    public void save (Vaga vaga){
        String sql = "INSERT INTO vaga (cargo_vaga, empresa_vaga, setor_vaga, periodo, experiencia, salario, descricao_vaga, endereco_vaga, cidade_vaga, remoto, status_vaga) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;


        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, vaga.getCargo());
            pstm.setString(2, vaga.getEmpresa_vaga());
            pstm.setString(3, vaga.getSetor_vaga());
            pstm.setString(4, vaga.getPeriodo());
            pstm.setString(5, vaga.getExperiencia());
            pstm.setFloat(6,vaga.getSalario());
            pstm.setString(7, vaga.getDescricao());
            pstm.setString(8, vaga.getEndereco());
            pstm.setString(9, vaga.getCidade());
            pstm.setString(10, vaga.getRemoto());
            pstm.setString(11, vaga.getStatus_vaga());

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

    public static ObservableList<Vaga> Datauser(){

        Connection conn = null;
        ResultSet rset = null;

        ObservableList<Vaga> list = FXCollections.observableArrayList();

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            PreparedStatement ps = conn.prepareStatement("select cargo_vaga, periodo, salario, experiencia, descricao_vaga, remoto, id_vaga from vaga order by salario asc");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add((new Vaga(rs.getString("cargo_vaga"), rs.getString("periodo"), rs.getFloat("salario"), rs.getString("experiencia"), rs.getString("descricao_vaga"), rs.getString("remoto"), rs.getInt("id_vaga"))));
            }

        }catch (Exception e){

            e.printStackTrace();

        }

        return list;

    }

}
