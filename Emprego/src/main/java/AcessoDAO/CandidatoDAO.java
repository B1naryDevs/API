package AcessoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ConnectionFA.ConnectionFactory;
import com.example.emprego.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;

public class CandidatoDAO {

    public void savecand (Candidato candidato){
        String sql = "INSERT INTO candidato (nome_candidato, cpf, data_nasc, telefone) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, candidato.getNome());
            pstm.setLong(2, candidato.getCpf());
            pstm.setString(3, candidato.getDataNac());
            pstm.setLong(4, candidato.getTelefone());

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

    public void saveusucand (Candidato candidato){
        String sql = "INSERT INTO usuario (email, senha, cpf_candidato_usu) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, candidato.getEmail());
            pstm.setString(2, candidato.getSenha());
            pstm.setLong(3, candidato.getCpf());

            System.out.println("hello");


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

    public void saveexpcand (Candidato candidato){
        String sql = "INSERT INTO experiencia_profissional (cpf_candidato_exp, cargo_exercido, inicio_exp, termino_exp, cargo_atual, desc_atividades) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, String.valueOf(candidato.getCpf()));
            pstm.setString(2, candidato.getCargo());
            pstm.setString(3, candidato.getExpInicio());
            pstm.setString(4, candidato.getExpTermino());
            pstm.setString(5, candidato.getCargoAtual());
            pstm.setString(6, candidato.getDescricao());

            System.out.println("hello");


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

    public void updateprefcand (Candidato candidato){
        String sql = "UPDATE candidato set pret_salarial = ?, pret_cargo = ? where cpf = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, String.valueOf(candidato.getPretSalarial()));
            pstm.setString(2, candidato.getCargoInteresse());
            pstm.setLong(3, candidato.getCpf());

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

    public void updateformcand (Candidato candidato){
        String sql = "UPDATE candidato set nome_comp = ?, instituicao = ?, inicio_curso = ?, termino_curso = ?, nivel = ?, curso = ? where cpf = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, candidato.getCompetencia());
            pstm.setString(2, candidato.getInstituicao());
            pstm.setString(3, candidato.getCursoInicio());
            pstm.setString(4, candidato.getCursoTermino());
            pstm.setString(5, candidato.getIdioma());
            pstm.setString(6, candidato.getCurso());
            pstm.setLong(7, candidato.getCpf());

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

        String sql = "Select email, senha from usuario where email = ? and senha = ?";
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

    public static List<Candidato> Cand()

    {
        String sql = "Select * from candidato where cpf = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Usuario usuario = new Usuario();

        List<Candidato> candlist = new ArrayList<Candidato>();

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, String.valueOf(Usuario.getCpf()));
            //objeto para ler os dados do banco
            rset = pstm.executeQuery();


            // laço para percorrer o objeto de acesso ao dados do banco
            while (rset.next()) {

                Candidato candidato = new Candidato();
                candidato.setNome(rset.getString("nome_candidato"));
                candidato.setDataNac(rset.getString("data_nasc"));
                candidato.setTelefone(rset.getLong("telefone"));

                candlist.add(candidato);

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

        return candlist;

    }

    public void updatecand (Candidato candidato,Long cpf){
        String sql = "UPDATE candidato set nome_candidato = ?, data_nasc = ?, telefone = ? where cpf = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, candidato.getNome());
            pstm.setString(2, candidato.getDataNac());
            pstm.setLong(3, candidato.getTelefone());
            pstm.setLong(4, cpf);

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

    public static ObservableList<CandidatoTabela> Datauser(Integer vaga){

        Connection conn = null;
        ResultSet rs = null;

        ObservableList<CandidatoTabela> list = FXCollections.observableArrayList();

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
                PreparedStatement ps = conn.prepareStatement("select * from candidato join candidatura where candidatura.cpf_candidatura = candidato.cpf and candidatura.cod_vaga = ? and candidatura.status_cand = 'Em andamento'");
                ps.setString(1, String.valueOf(vaga));
                rs = ps.executeQuery();
                while (rs.next()){
                    list.add((new CandidatoTabela(rs.getString("nome_candidato"), rs.getLong("telefone") , rs.getLong("cpf"))));
                }
        }catch (Exception e){

            e.printStackTrace();

        }

        return list;

    }

    public List<Candidato> Search(long cpf)

    {
        String sql = "Select * from candidato where cpf = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        List<Candidato> funclist = new ArrayList<Candidato>();

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, String.valueOf(cpf));
            //objeto para ler os dados do banco
            rset = pstm.executeQuery();


            // laço para percorrer o objeto de acesso ao dados do banco
            while (rset.next()) {

                Candidato candidato = new Candidato();
                candidato.setNome(rset.getString("nome_candidato"));
                candidato.setCpf(rset.getLong("cpf"));
                candidato.setDataNac(rset.getString("data_nasc"));
                candidato.setTelefone(rset.getLong("telefone"));
                candidato.setPretSalarial(rset.getString("pret_salarial"));
                candidato.setCargoInteresse(rset.getString("pret_cargo"));
                candidato.setCompetencia(rset.getString("nome_comp"));
                candidato.setInstituicao(rset.getString("instituicao"));
                candidato.setCursoInicio(rset.getString("inicio_curso"));
                candidato.setCursoTermino(rset.getString("termino_curso"));
                candidato.setIdioma(rset.getString("nivel"));
                candidato.setCurso(rset.getString("curso"));

                funclist.add(candidato);

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

    public List<Candidato> Search2(long cpf)

    {
        String sql = "Select email from usuario where cpf_candidato_usu = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        List<Candidato> funclist = new ArrayList<Candidato>();

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, String.valueOf(cpf));
            //objeto para ler os dados do banco
            rset = pstm.executeQuery();


            // laço para percorrer o objeto de acesso ao dados do banco
            while (rset.next()) {

                Candidato candidato = new Candidato();
                candidato.setEmail(rset.getString("email"));

                funclist.add(candidato);

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
