package com.example.emprego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class candidatoControler4 {

    @FXML
    private Button botaoHome;

    @FXML
    void VoltarInicio(ActionEvent event) {
        HelloApplication.ChangeScene("tela1");
    }

}
