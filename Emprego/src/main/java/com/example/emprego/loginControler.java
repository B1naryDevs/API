package com.example.emprego;

import AcessoDAO.CandidatoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ToggleButton;

import javax.swing.*;

public class loginControler {

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoEntrar;

    @FXML
    private ToggleButton botaoSair;

    @FXML
    private TextField campoEmail;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private TextField campoSenha2;

    @FXML
    private ToggleButton tgbtMostrarSenha;

    @FXML
    void cadastrarLogin(ActionEvent event) {
        HelloApplication.ChangeScene("candidato");
    }

    @FXML
    void entrarLogin(ActionEvent event) {

        //validação de campos em branco

        if (campoEmail.getText() == "" || campoSenha.getText() == ""){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("campo vazio !");
            alert.showAndWait();

        } else {

            // conexão com banco

            CandidatoDAO dao = new CandidatoDAO();
            if( dao.checklogin(campoEmail.getText(), campoSenha.getText())){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Bem Vindo !");
                alert.showAndWait();
                HelloApplication.ChangeScene("menu");

            } else{

                // USUARIO NÃO ENCONTRADO
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("E-mail ou Senha incorretos !");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void SairTela(ActionEvent event) { HelloApplication.ChangeScene("menu"); }

    //imagem ação
    @FXML
    Image img_MostrarSenha = new Image("file:src/main/resources/imagens/iconMostrar.png",25,25,true,true);
    Image img_OcultarSenha = new Image("file:src/main/resources/imagens/iconApagar.png",25,25,true,true);


    //ocultar/mostrar senha
    @FXML
    void mostrarSenha(ActionEvent event){
        if(tgbtMostrarSenha.isSelected()){
            tgbtMostrarSenha.setGraphic(new ImageView(img_MostrarSenha));
            campoSenha2.setText(campoSenha.getText());
            campoSenha2.setVisible(true);
            campoSenha.setVisible(false);
        }else{
            tgbtMostrarSenha.setGraphic(new ImageView(img_OcultarSenha));
            campoSenha.setText(campoSenha2.getText());
            campoSenha.setVisible(true);
            campoSenha2.setVisible(false);
        }
    }
}



