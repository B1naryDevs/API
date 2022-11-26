package AcessoDAO;

import ConnectionFA.ConnectionFactory;
import com.example.emprego.Funcionario;
import com.example.emprego.FuncionarioUsuario;
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

    public List<Funcionario> Func( String email)

    {
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
                funciona.setTelefone(rset.getLong("telefone"));
                funciona.setCpf(rset.getLong("cpf"));
                funciona.setEmail(rset.getString("email"));
                funciona.setSenha(rset.getString("senha"));

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

    public List<FuncionarioUsuario> Usua( String email)

    {
        String sql = "Select * from funcionario where email = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        List<FuncionarioUsuario> funclist = new ArrayList<FuncionarioUsuario>();

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, email);
            //objeto para ler os dados do banco
            rset = pstm.executeQuery();


            // laço para percorrer o objeto de acesso ao dados do banco
            while (rset.next()) {

                FuncionarioUsuario funcionariousuario = new FuncionarioUsuario();
                funcionariousuario.setNome(rset.getString("nome_func"));
                funcionariousuario.setTelefone(rset.getLong("telefone"));
                funcionariousuario.setCpf(rset.getLong("cpf"));
                funcionariousuario.setEmail(rset.getString("email"));
                funcionariousuario.setSenha(rset.getString("senha"));

                funclist.add(funcionariousuario);

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

public void savefunc(Funcionario func){
    String sql = "INSERT INTO funcionario (nome_func, email, senha, cpf, telefone) VALUES (?, ?, ?, ?, ?)";
    Connection conn = null;
    PreparedStatement pstm = null;

    try{
        conn = ConnectionFactory.createConnectionToMySQL();
        pstm = (PreparedStatement) conn.prepareStatement(sql);

        pstm.setString(1, func.getNome());
        pstm.setString(2, func.getEmail());
        pstm.setString(3, func.getSenha());
        pstm.setLong(4, func.getCpf());
        pstm.setLong(5, func.getTelefone());

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

    public void updfunc(Funcionario func){

        String sql = "UPDATE funcionario SET nome_func = ?, email = ?, senha = ?, telefone = ? WHERE cpf = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, func.getNome());
            pstm.setString(2, func.getEmail());
            pstm.setString(3, func.getSenha());
            pstm.setLong(4, func.getTelefone());
            pstm.setLong(5, func.getCpf());

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

    public void updfuncse(Funcionario func){

        String sql = "UPDATE funcionario SET nome_func = ?, email = ?, telefone = ? WHERE cpf = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, func.getNome());
            pstm.setString(2, func.getEmail());
            pstm.setLong(3, func.getTelefone());
            pstm.setLong(4, func.getCpf());

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

    public void deletefunc(Funcionario func){

        String sql = "DELETE FROM funcionario WHERE email = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, func.getEmail());

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


    public boolean checklogin (String email, String senha){

        String sql = "Select email, senha from funcionario where email = ? and senha = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        boolean check = false;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, email);
            pstm.setString(2,senha);
            rs = pstm.executeQuery();

            if (rs.next()){
                check = true;
            }


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

        return check;
    }


    public void deletevg(long cp){

        String sql = "DELETE FROM vaga WHERE funcionario_cpf = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setLong(1, cp);

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
