package AcessoDAO;

import ConnectionFA.ConnectionFactory;
import com.example.emprego.RH;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class RhDAO {

    public static ObservableList<RH> Datauser(){

        String sql = "select nome_func, email, empresa from funcionario";
        Connection conn = null;
        ResultSet rset = null;

        ObservableList<RH> list = FXCollections.observableArrayList();

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            PreparedStatement ps = conn.prepareStatement("select nome_func, email, empresa from funcionario");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add((new RH(rs.getString("nome_func"), rs.getString("email"), rs.getString("empresa"))));
            }

        }catch (Exception e){

            e.printStackTrace();

        }

        return list;

    }

}
