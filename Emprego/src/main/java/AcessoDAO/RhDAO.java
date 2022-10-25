package AcessoDAO;

import ConnectionFA.ConnectionFactory;
import com.example.emprego.Candidato;
import com.example.emprego.RH;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RhDAO {

    Connection conn = null;

    public  static  Connection ConnectDb(){

        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/api");
            JOptionPane.showMessageDialog(null, "Conexão Estabelecida");
            return coon;

        }catch (Exception e){

            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public static ObservableList<RH> getDatauser(){

        Connection conn = ConnectDb();

        ObservableList<RH> list = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = conn.prepareStatement("select nome_func, email, empresa from funcionario");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add((new RH(rs.getString("nome_func"), rs.getString("email"), rs.getString("empresa"))));
            }
        }catch (Exception e){

        }

        return list;

    }

}
