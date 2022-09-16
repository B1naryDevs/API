package com.example.emprego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class candidatoControler3 {

    @FXML
    private Button botaoAvancar3;

    @FXML
    private Button botaoVoltar2;

    @FXML
    private TextField competenciaCandidato;

    @FXML
    private TextField cursoCandidato;

    @FXML
    private TextField idiomaCandidato;

    @FXML
    private DatePicker inicioCandidato2;

    @FXML
    private TextField intituicaoCandidato;

    @FXML
    private DatePicker terminoCandidato2;

    @FXML
    void cadastrarDados3(ActionEvent event) {
        HelloApplication.ChangeScene("tela4");
    }

    @FXML
    void voltarTela2(ActionEvent event) {
        HelloApplication.ChangeScene("tela2");
    }

}

