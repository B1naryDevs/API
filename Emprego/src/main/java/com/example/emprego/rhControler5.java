package com.example.emprego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

import java.net.URL;
import java.util.ResourceBundle;

public class rhControler5 implements Initializable {

    // Nomeclatura dos botões e campos


    @FXML
    private Button botaoHome;

    @FXML
    private Button botaoCargos;

    @FXML
    private Button botaoVagas;

    @FXML
    private Button botaoRH;

    @FXML
    private Button botaoRelatorios;

    @FXML
    private Button botaoAprovados;

    @FXML
    private Button botaoReprovados;

    @FXML
    private ToggleButton botaoSair;

    @FXML
    private TextField getCampoNome;

    @FXML
    private TextField getCampoEmail;

    @FXML
    private TextField getCampoTelefone;

    @FXML
    private TextField getCampoCpf;

    @FXML
    private TextField getCampoSenha;

    @FXML
    private TextField getCampoConfirmarSenha;

    @FXML
    private TextField campoteste;


    // Definição das ações dos botões

    @FXML
    void AvancarHome(ActionEvent event) throws Exception {HelloApplication.ChangeScene("home");}

    @FXML
    void AvancarVagas(ActionEvent event) throws Exception{HelloApplication.ChangeScene("vaga");}

    @FXML
    void AvancarCargos(ActionEvent event) throws Exception { HelloApplication.ChangeScene("cargo");}

    @FXML
    void AvancarRH(ActionEvent event) throws Exception {HelloApplication.ChangeScene("rh");}

    @FXML
    void AvancarRelatorios(ActionEvent event) throws Exception {HelloApplication.ChangeScene("");}

    @FXML
    void SairTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("login");}

   @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rhControler4 rh4 = new rhControler4();
        campoteste.setText(rh4.getSecemail());
   }


}
