package AcessoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ConnectionFA.ConnectionFactory;
import com.example.emprego.Candidato;

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
        String sql = "INSERT INTO usuario (email, senha, cpf_usu) VALUES (?, ?, ?)";
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

}
