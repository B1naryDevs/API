package com.example.emprego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;

public class sobreNosControler {

    //Nomeclatura dos botões

    @FXML
    private Button botaoHome;

    @FXML
    private Button botaoAreaCandidato;

    @FXML
    private Button botaoVagas;

    @FXML
    private Button botaoSobre;

    @FXML
    private ToggleButton botaoSair;


    // Definição das ações dos botões

    @FXML
    void AvancarHome(ActionEvent event) {HelloApplication.ChangeScene("home");}

    @FXML
    void AvancarAreaCandidato(ActionEvent event) {HelloApplication.ChangeScene("areacandidato");}

    @FXML
    void AvancarVagas(ActionEvent event) {HelloApplication.ChangeScene("vaga");}

    @FXML
    void AvancarSobre(ActionEvent event) {HelloApplication.ChangeScene("sobre");}

    @FXML
    void SairTela(ActionEvent event) {HelloApplication.ChangeScene("login");}

}
