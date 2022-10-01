package com.example.emprego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginControler {

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoEntrar;

    @FXML
    private TextField campoEmail;

    @FXML
    private PasswordField campoSenha;

    @FXML
    void cadastrarLogin(ActionEvent event) {
        HelloApplication.ChangeScene("candidato");
    }

    @FXML
    void entrarLogin(ActionEvent event) {
        HelloApplication.ChangeScene("menu");
    }

}
