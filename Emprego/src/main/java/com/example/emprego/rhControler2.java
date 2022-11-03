package com.example.emprego;

import AcessoDAO.FuncionarioDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class rhControler2  {

    // Nomeclatura dos botões e campos
    
    @FXML
    private Button botaoHome;

    @FXML
    private Button botaoCargos;

    @FXML
    private Button botaoVagas;

    @FXML
    private Button botaoRH;

    @FXML
    private Button botaoRelatorios;

    @FXML
    private Button botaoCadastrarFuncionarios;

    @FXML
    private Button botaoVisualizarFuncionarios;

    @FXML
    private ToggleButton botaoSair;

    @FXML
    private ToggleButton tgbtMostrarSenha;

    @FXML
    private ToggleButton tgbtMostrarSenha2;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoCpf;

    @FXML
    private TextField campoEmail;

    @FXML
    private TextField campoTelefone;

    @FXML
    private TextField campoSenha;

    @FXML
    private PasswordField campoSenha2;

    @FXML
    private TextField campoConfirmarSenha;

    @FXML
    private PasswordField campoConfirmarSenha2;


    // Definição das ações dos botões

    @FXML
    void AvancarHome(ActionEvent event) {HelloApplication.ChangeScene("home");}

    @FXML
    void AvancarVagas(ActionEvent event) {HelloApplication.ChangeScene("vaga");}

    @FXML
    void AvancarCargos(ActionEvent event) { HelloApplication.ChangeScene("cargo");}

    @FXML
    void AvancarRH(ActionEvent event) {HelloApplication.ChangeScene("rh");}

    @FXML
    void AvancarRelatorios(ActionEvent event) {HelloApplication.ChangeScene("");}

    @FXML
    void VoltarTela(ActionEvent event) {HelloApplication.ChangeScene("rh");}

    @FXML
    void SairTela(ActionEvent event) {HelloApplication.ChangeScene("login");}

    @FXML
    void CadastrarFuncionario(ActionEvent event){

        //Cifrar Senha
        String senhaMd5 = Md5.getHashMd5(campoSenha.getText());
        //Inserir funcionario no banco
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(campoNome.getText());
        funcionario.setEmail(campoEmail.getText());
        funcionario.setSenha(senhaMd5);
        funcionario.setCpf(Long.parseLong(campoCpf.getText()));
        funcionario.setTelefone(Long.parseLong(campoTelefone.getText()));

        funcionarioDAO.savefunc(funcionario);


        HelloApplication.ChangeScene("rh3");}

    @FXML
    private void mascaraTel() {
        Formatter tff = new Formatter();
        tff.setMask("(##)#####-####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(campoTelefone);
        tff.formatter();
    }

    @FXML
    private void mascaraCpf() {
        Formatter cpf = new Formatter();
        cpf.setMask("###.###.###-##");
        cpf.setCaracteresValidos("0123456789");
        cpf.setTf(campoCpf);
        cpf.formatter();
    }

    //imagem ação
    @FXML
    Image img_MostrarSenha = new Image("file:src/main/resources/imagens/iconMostrar.png",25,25,true,true);
    Image img_OcultarSenha = new Image("file:src/main/resources/imagens/iconApagar.png",25,25,true,true);

    @FXML
    Image img_MostrarSenha2 = new Image("file:src/main/resources/imagens/iconMostrar.png",25,25,true,true);
    Image img_OcultarSenha2 = new Image("file:src/main/resources/imagens/iconApagar.png",25,25,true,true);

    //ocultar/mostrar senha
    @FXML
    void mostrarSenha(ActionEvent event){
        if(tgbtMostrarSenha.isSelected()){
            tgbtMostrarSenha.setGraphic(new ImageView(img_MostrarSenha));
            campoSenha.setText(campoSenha2.getText());
            campoSenha.setVisible(true);
            campoSenha2.setVisible(false);
        }else{
            tgbtMostrarSenha.setGraphic(new ImageView(img_OcultarSenha));
            campoSenha2.setText(campoSenha.getText());
            campoSenha2.setVisible(true);
            campoSenha.setVisible(false);
        }
    }
    @FXML
    void mostrarSenha2(ActionEvent event) {
        if (tgbtMostrarSenha2.isSelected()) {
            tgbtMostrarSenha2.setGraphic(new ImageView(img_MostrarSenha2));
            campoConfirmarSenha.setText(campoConfirmarSenha2.getText());
            campoConfirmarSenha.setVisible(true);
            campoConfirmarSenha2.setVisible(false);
        } else {
            tgbtMostrarSenha2.setGraphic(new ImageView(img_OcultarSenha2));
            campoConfirmarSenha2.setText(campoConfirmarSenha.getText());
            campoConfirmarSenha2.setVisible(true);
            campoConfirmarSenha.setVisible(false);
        }
    }
}

