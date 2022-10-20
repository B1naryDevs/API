package com.example.emprego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.scene.control.ToggleButton;

public class candidatoControler4 {

    @FXML
    private Button botaoHome;
    
    @FXML
    private Button botaoAvancar;

    @FXML
    private Button botaoLogin;

    @FXML
    private ToggleButton botaoSair;

    @FXML
    void SairTela(ActionEvent event) {HelloApplication.ChangeScene("login");}

    @FXML
    void AvancarLogin(ActionEvent event) {HelloApplication.ChangeScene("login");}


    @FXML
    void VoltarInicio(ActionEvent event) throws FileNotFoundException {
        Candidato candidato = new Candidato(null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);;
        HelloApplication.ChangeScene("candidato");
    }
}
