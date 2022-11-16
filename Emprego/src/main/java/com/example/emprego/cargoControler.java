package com.example.emprego;

import AcessoDAO.CargoDAO;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class cargoControler {

    @FXML
    private Button botaoCadastrar;

    @FXML
    private TextField campoCargo2;

    @FXML
    private Button botaoHome;

    @FXML
    private Button botaoVaga;

    @FXML
    private Button botaoCargo;

    @FXML
    private Button botaoRH;

    @FXML
    private Button botaoRelatorio;

    @FXML
    private ToggleButton botaoSair;

    @FXML
    void AvancarHome(ActionEvent event) throws Exception {
        HelloApplication.ChangeScene("homerh");
    }

    @FXML
    void AvancarVaga(ActionEvent event) throws Exception {
        HelloApplication.ChangeScene("telavaga");
    }

    @FXML
    void AvancarCargo(ActionEvent event) throws Exception {
        HelloApplication.ChangeScene("cargo");
    }

    @FXML
    void AvancarRH(ActionEvent event) throws Exception {
        HelloApplication.ChangeScene("rh");
    }

    @FXML
    void AvancarRelatorio(ActionEvent event) throws Exception {
        HelloApplication.ChangeScene("");
    }

    @FXML
    void SairTela(ActionEvent event) throws Exception {
        HelloApplication.ChangeScene("login");
    }

    @FXML
    void CadastrarCargo(ActionEvent event) throws Exception {
        String cargo2 = campoCargo2.getText();
        if (cargo2.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O CARGO!");
            alert.showAndWait();
        }else{

            CargoDAO cargoDAO = new CargoDAO();

            Cargo cargo = new Cargo();
            cargo.setNome(campoCargo2.getText());

            cargoDAO.save(cargo);

            HelloApplication.ChangeScene("cargofinal");
        }
    }
}
