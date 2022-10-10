package AcessoDAO;

import ConnectionFA.ConnectionFactory;
import com.example.emprego.Cargo;
import com.example.emprego.Vaga;

import java.sql.Connection;
import java.sql.PreparedStatement;

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

}
