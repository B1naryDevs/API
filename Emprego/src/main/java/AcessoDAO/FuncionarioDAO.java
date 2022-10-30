package AcessoDAO;

import ConnectionFA.ConnectionFactory;
import com.example.emprego.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class FuncionarioDAO {

    public static ObservableList<Funcionario> Datauser(){

        Connection conn = null;
        ResultSet rset = null;

        ObservableList<Funcionario> list = FXCollections.observableArrayList();

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            PreparedStatement ps = conn.prepareStatement("select nome_func, email, telefone from funcionario");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add((new Funcionario(rs.getString("nome_func"), rs.getString("email"), rs.getLong("telefone"))));
            }

        }catch (Exception e){

            e.printStackTrace();

        }

        return list;

    }

}
