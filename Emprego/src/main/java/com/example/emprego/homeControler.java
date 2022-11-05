package com.example.emprego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;

public class homeControler {

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
    void AvancarHome(ActionEvent event) throws Exception {HelloApplication.ChangeScene("home");}

    @FXML
    void AvancarAreaCandidato(ActionEvent event) throws Exception {HelloApplication.ChangeScene("areacandidato");}

    @FXML
    void AvancarVagas(ActionEvent event) throws Exception {HelloApplication.ChangeScene("vaga");}

    @FXML
    void AvancarSobre(ActionEvent event) throws Exception {HelloApplication.ChangeScene("sobre");}

    @FXML
    void SairTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("login");}

}
