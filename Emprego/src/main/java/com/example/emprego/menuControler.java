package com.example.emprego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class menuControler {

    @FXML
    private Button botaoCargo;

    @FXML
    private Button botaoVaga;

    @FXML
    void AvancarCargo(ActionEvent event) { HelloApplication.ChangeScene("cargo");

    }

    @FXML
    void AvancarVaga(ActionEvent event) {
        HelloApplication.ChangeScene("vaga");
    }

}
