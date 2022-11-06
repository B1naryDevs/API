package AcessoDAO;

import ConnectionFA.ConnectionFactory;
import com.example.emprego.Candidato;
import com.example.emprego.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    public static List<Usuario> Usua(String email)

    {
        String sql = "Select * from usuario where email = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        List<Usuario> usualist = new ArrayList<Usuario>();

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, email);
            //objeto para ler os dados do banco
            rset = pstm.executeQuery();


            // laço para percorrer o objeto de acesso ao dados do banco
            while (rset.next()) {

                Usuario usuario = new Usuario();
                usuario.setCpf(rset.getLong("cpf_candidato_usu"));
                usuario.setEmail(rset.getString("email"));

                usualist.add(usuario);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return usualist;

    }

    public void updateusu (Usuario usuario, Long cpf){
        String sql = "UPDATE usuario set email = ? where cpf_candidato_usu = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, usuario.getEmail());
            pstm.setString(2, String.valueOf(cpf));

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
