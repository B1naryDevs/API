package com.example.emprego;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class rhControler3 {

    // Nomeclatura dos botões

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
    private Button botaoSobre;

    @FXML
    private ToggleButton botaoSair;


    // Definição das ações dos botões

    @FXML
    void AvancarHome(ActionEvent event) {HelloApplication.ChangeScene("menu");}

    @FXML
    void AvancarVagas(ActionEvent event) {HelloApplication.ChangeScene("vaga");}

    @FXML
    void AvancarCargos(ActionEvent event) { HelloApplication.ChangeScene("cargo");}

    @FXML
    void AvancarRH(ActionEvent event) {HelloApplication.ChangeScene("rh");}

    @FXML
    void AvancarSobre(ActionEvent event) {HelloApplication.ChangeScene("");}

    @FXML
    void AvancarRelatorios(ActionEvent event) {HelloApplication.ChangeScene("");}

    @FXML
    void SairTela(ActionEvent event) {HelloApplication.ChangeScene("login");}
}
