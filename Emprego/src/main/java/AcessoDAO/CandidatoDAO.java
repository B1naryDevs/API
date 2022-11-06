package AcessoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ConnectionFA.ConnectionFactory;
import com.example.emprego.Candidato;
import com.example.emprego.Usuario;

import javax.swing.*;

public class CandidatoDAO {

    public void savecand (Candidato candidato){
        String sql = "INSERT INTO candidato (nome_candidato, cpf, data_nasc, telefone, pret_salarial) VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, candidato.getNome());
            pstm.setLong(2, candidato.getCpf());
            pstm.setString(3, candidato.getDataNac());
            pstm.setLong(4, candidato.getTelefone());
            pstm.setFloat(5, candidato.getPretSalarial());

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

}
