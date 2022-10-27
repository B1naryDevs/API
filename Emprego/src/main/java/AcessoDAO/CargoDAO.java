package AcessoDAO;

import ConnectionFA.ConnectionFactory;
import com.example.emprego.Cargo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CargoDAO {


    public void save (Cargo cargo){
        String sql = "INSERT INTO cargo (nome_cargo,setor_cargo) VALUES (?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;


        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1,cargo.getNome());
            pstm.setString(2, cargo.getSetor());

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

    public static List<String> carg(){

        List<String> cargos = new ArrayList<>();
        String sql = "Select nome_cargo from cargo";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        
        try {

            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //objeto para ler os dados do banco
            rset = pstm.executeQuery();

            // laço para percorrer o objeto de acesso ao dados do banco
            while (rset.next()){

                //recuperar os cargos da coluna para uma lista
                cargos.add(rset.getString("nome_cargo"));
                
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        finally {

            try {
                if (rset != null){
                    rset.close();
                }

                if (pstm != null){
                    pstm.close();
                }

                if (conn != null){
                    conn.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        } return cargos;

    }

}
