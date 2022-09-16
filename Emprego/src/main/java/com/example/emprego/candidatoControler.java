package com.example.emprego;

import javafx.fxml.FXML;
import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class candidatoControler {
    @FXML
    private Button botaoAvancar;

    @FXML
    private TextField cpfCandidato;

    @FXML
    private DatePicker dataCandidato;

    @FXML
    private TextField emailCandidato;

    @FXML
    private TextField nomeCandidato;

    @FXML
    private TextField senhaCandidato;

    @FXML
    private TextField telefoneCandidato;

    @FXML
    void cadastrarDados(ActionEvent event) throws FileNotFoundException {
        HelloApplication.ChangeScene("tela2");
    }
}