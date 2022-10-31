package AcessoDAO;

import ConnectionFA.ConnectionFactory;
import com.example.emprego.Vaga;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class VagasDAO {

    public static ObservableList<Vaga> Datauser(){

        Connection conn = null;
        ResultSet rset = null;

        ObservableList<Vaga> list = FXCollections.observableArrayList();

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            PreparedStatement ps = conn.prepareStatement("select cargo_vaga, periodo, salario, experiencia, descricao_vaga, remoto from vaga order by salario asc");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add((new Vaga(rs.getString("cargo_vaga"), rs.getString("periodo"), rs.getFloat("salario"), rs.getString("experiencia"), rs.getString("descricao_vaga"), rs.getString("remoto"))));
            }

        }catch (Exception e){

            e.printStackTrace();

        }

        return list;

    }

}
