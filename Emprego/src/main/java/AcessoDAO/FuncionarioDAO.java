package AcessoDAO;

import ConnectionFA.ConnectionFactory;
import com.example.emprego.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.example.emprego.rhControler4.*;


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

    public List<Funcionario> Func()

    {
        String email = secemail;
        String sql = "Select * from funcionario where email = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        List<Funcionario> funclist = new ArrayList<Funcionario>();

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, email);
            //objeto para ler os dados do banco
            rset = pstm.executeQuery();


            // laço para percorrer o objeto de acesso ao dados do banco
            while (rset.next()) {

                Funcionario funciona = new Funcionario();
                funciona.setNome(rset.getString("nome_func"));
                funciona.setEmpresa(rset.getString("empresa"));
                funciona.setTelefone(rset.getLong("telefone"));
                funciona.setCpf(rset.getLong("cpf"));
                funciona.setEmail(rset.getString("email"));
                funciona.setAcesso(rset.getString("funcao"));

                funclist.add(funciona);

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

        return funclist;

    }

}
