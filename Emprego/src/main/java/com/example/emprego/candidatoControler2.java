package com.example.emprego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class candidatoControler2 {

    @FXML
    private Button botaoAvancar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private TextField cargoCandidato;

    @FXML
    private TextField cargosCandidato;

    @FXML
    private TextField descricaoCandidato;

    @FXML
    private TextField empresaCandidato;

    @FXML
    private DatePicker inicioCandidato;

    @FXML
    private TextField pretencaoCandidato;

    @FXML
    private DatePicker terminoCandidato;

    @FXML
    void cadastrarDados2(ActionEvent event) {
        HelloApplication.ChangeScene("tela3");
    }

    @FXML
    void voltarTela(ActionEvent event) {
        HelloApplication.ChangeScene("tela1");
    }

}
