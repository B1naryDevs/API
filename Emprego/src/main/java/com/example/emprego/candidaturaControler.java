package com.example.emprego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;

public class candidaturaControler {

    // Nomeclatura dos botões

    @FXML
    private Button botaoHome;

    @FXML
    private Button botaoCargo;

    @FXML
    private Button botaoVaga;

    @FXML
    private Button botaoRH;

    @FXML
    private Button botaoRelatorio;

    @FXML
    private MenuButton botaoFiltrar;

    @FXML
    private Accordion accordionVagas;


    // Definição das ações dos botões

    @FXML
    void AvancarHome(ActionEvent event) {HelloApplication.ChangeScene("menu");}

    @FXML
    void AvancarVaga(ActionEvent event) {HelloApplication.ChangeScene("vaga");}

    @FXML
    void AvancarCargo(ActionEvent event) { HelloApplication.ChangeScene("cargo");}

    @FXML
    void AvancarRH(ActionEvent event) {HelloApplication.ChangeScene("rh");}

    @FXML
    void AvancarRelatorio(ActionEvent event) {HelloApplication.ChangeScene("");}

    @FXML
    void SairTela(ActionEvent event) {HelloApplication.ChangeScene("login");}

}
