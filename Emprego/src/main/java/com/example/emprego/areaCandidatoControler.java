package com.example.emprego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

public class areaCandidatoControler {

    // Nomeclatura dos botões

    @FXML
    private Button botaoHome;

    @FXML
    private Button botaoVagas;

    @FXML
    private Button botaoSobre;

    @FXML
    private Button botaoSalvar;

    @FXML
    private Button botaoAcompanhar;

    @FXML
    private ToggleButton botaoSair;

    // Definição dos campos

    @FXML
    private TextField campoCpf;

    @FXML
    private TextField campoEmail;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoTelefone;

    @FXML
    private TextField campoData;

    // Definição das ações dos botões

    @FXML
    void AvancarHome(ActionEvent event) {HelloApplication.ChangeScene("menu");}

    @FXML
    void AvancarAreaCandidato(ActionEvent event) {HelloApplication.ChangeScene("areacandidato");}

    @FXML
    void AvancarVagas(ActionEvent event) {HelloApplication.ChangeScene("vaga");}

    @FXML
    void AvancarProcessoSeletivo(ActionEvent event) {HelloApplication.ChangeScene("processoseletivo");}

    @FXML
    void AvancarSobre(ActionEvent event) {HelloApplication.ChangeScene("");}

    @FXML
    void SairTela(ActionEvent event) {HelloApplication.ChangeScene("login");}

}

