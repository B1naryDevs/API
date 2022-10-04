package com.example.emprego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
        HelloApplication.ChangeScene("menu");
    }
    
    @FXML
    void SairTela(ActionEvent event) { HelloApplication.ChangeScene("candidato2"); }

    //ocultar/mostrar senha
    @FXML
    void mostrarSenha(ActionEvent event){
        if(tgbtMostrarSenha.isSelected()){
            campoSenha2.setText(campoSenha.getText());
            campoSenha2.setVisible(true);
            campoSenha.setVisible(false);
        }else{
            campoSenha.setText(campoSenha2.getText());
            campoSenha.setVisible(true);
            campoSenha2.setVisible(false);
        }
    }
}



