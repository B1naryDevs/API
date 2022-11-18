package AcessoDAO;

import ConnectionFA.ConnectionFactory;
import com.example.emprego.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VagaDAO {

    public void save (Vaga vaga){
        String sql = "INSERT INTO vaga (cargo_vaga, funcionario_cpf, periodo, experiencia, salario, descricao_vaga, endereco_vaga, cidade_vaga, remoto, status_vaga) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;


        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, vaga.getCargo());
            FuncionarioUsuario funcionariousuario = new FuncionarioUsuario();
            pstm.setString(2, String.valueOf(funcionariousuario.getCpf()));
            pstm.setString(3, vaga.getPeriodo());
            pstm.setString(4, vaga.getExperiencia());
            pstm.setFloat(5,vaga.getSalario());
            pstm.setString(6, vaga.getDescricao());
            pstm.setString(7, vaga.getEndereco());
            pstm.setString(8, vaga.getCidade());
            pstm.setString(9, vaga.getRemoto());
            pstm.setString(10, vaga.getStatus_vaga());

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
            FiltroVagas filtroVagas = new FiltroVagas();
            if(filtroVagas.getFiltro()!=null) {
                PreparedStatement ps = conn.prepareStatement("select cargo_vaga, funcionario_cpf, periodo, salario, experiencia, descricao_vaga, remoto, id_vaga from vaga where cargo_vaga = ? order by salario asc");
                ps.setString(1, filtroVagas.getFiltro());
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    list.add((new Vaga(rs.getString("cargo_vaga"), rs.getLong("funcionario_cpf"), rs.getString("periodo"), rs.getFloat("salario"), rs.getString("experiencia"), rs.getString("descricao_vaga"), rs.getString("remoto"), rs.getInt("id_vaga"))));
                }
            }else{
                PreparedStatement ps = conn.prepareStatement("select cargo_vaga, funcionario_cpf, periodo, salario, experiencia, descricao_vaga, remoto, id_vaga from vaga order by salario asc");
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    list.add((new Vaga(rs.getString("cargo_vaga"), rs.getLong("funcionario_cpf"), rs.getString("periodo"), rs.getFloat("salario"), rs.getString("experiencia"), rs.getString("descricao_vaga"), rs.getString("remoto"), rs.getInt("id_vaga"))));
                }
            }
        }catch (Exception e){

            e.printStackTrace();

        }

        return list;

    }

    public List<VagaStatic> Search(Integer id)

    {
        String sql = "Select * from vaga where id_vaga = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        List<VagaStatic> funclist = new ArrayList<VagaStatic>();

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, String.valueOf(id));
            //objeto para ler os dados do banco
            rset = pstm.executeQuery();


            // laço para percorrer o objeto de acesso ao dados do banco
            while (rset.next()) {

                VagaStatic vagastatic = new VagaStatic();
                vagastatic.setId(rset.getInt("id_vaga"));
                vagastatic.setFuncionario(rset.getLong("funcionario_cpf"));
                vagastatic.setCargo(rset.getString("cargo_vaga"));
                vagastatic.setSalario(rset.getFloat("salario"));
                vagastatic.setPeriodo(rset.getString("periodo"));
                vagastatic.setDescricao(rset.getString("descricao_vaga"));
                vagastatic.setExperiencia(rset.getString("experiencia"));
                vagastatic.setRemoto(rset.getString("remoto"));
                vagastatic.setEndereco(rset.getString("endereco_vaga"));

                funclist.add(vagastatic);

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


    //SELECT UNIVERSAL DE VAGAS
    public static ObservableList<Vaga> Vga(){

        Connection conn = null;
        ResultSet rset = null;

        ObservableList<Vaga> vagalist = FXCollections.observableArrayList();

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            PreparedStatement ps = conn.prepareStatement("select * from vaga");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                vagalist.add((new Vaga(rs.getString("cargo_vaga"), rs.getLong("funcionario_cpf"), rs.getString("periodo"), rs.getFloat("salario"), rs.getString("experiencia"), rs.getString("descricao_vaga"), rs.getString("remoto"), rs.getInt("id_vaga"))));
            }

        }catch (Exception e){

            e.printStackTrace();

        }

        return vagalist;

    }

    public static ObservableList<Vaga> VgaFilt(long cpf) {

        Connection conn = null;
        ResultSet rset = null;

        ObservableList<Vaga> vagalist = FXCollections.observableArrayList();

        try {

            conn = ConnectionFactory.createConnectionToMySQL();
            PreparedStatement ps = conn.prepareStatement("select * from vaga where funcionario_cpf = ?");
            ps.setLong(1, cpf);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                vagalist.add((new Vaga(rs.getString("cargo_vaga"), rs.getLong("funcionario_cpf"), rs.getString("periodo"), rs.getFloat("salario"), rs.getString("experiencia"), rs.getString("descricao_vaga"), rs.getString("remoto"), rs.getInt("id_vaga"))));
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return vagalist;
    }

}
