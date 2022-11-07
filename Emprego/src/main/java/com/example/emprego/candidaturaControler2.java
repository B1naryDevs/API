package com.example.emprego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;

public class candidaturaControler2 {

    @FXML
    private Button botaoCargos;

    @FXML
    private Button botaoHome;

    @FXML
    private Button botaoRH;

    @FXML
    private Button botaoRelatorios;

    @FXML
    private ToggleButton botaoSair;

    @FXML
    private Button botaoVagas;

    @FXML
    void AvancarHome(ActionEvent event) throws Exception {HelloApplication.ChangeScene("home");}

    @FXML
    void AvancarAreaCandidato(ActionEvent event) throws Exception {HelloApplication.ChangeScene("areacandidato");}

    @FXML
    void AvancarVagas(ActionEvent event) throws Exception {HelloApplication.ChangeScene("candidatura");}

    @FXML
    void AvancarSobre(ActionEvent event) throws Exception {HelloApplication.ChangeScene("sobre");}

    @FXML
    void SairTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("login");}

}