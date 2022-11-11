package com.example.emprego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;

public class telaVagaControler {

    //Nomeclatura dos botões

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
    private Button botaoCadastrarVagas;

    @FXML
    private Button botaoGerenciarVagas;

    @FXML
    private Button botaoAvaliar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private ToggleButton botaoSair;

    // Definição das ações dos botões

    @FXML
    void AvancarHome(ActionEvent event) throws Exception {HelloApplication.ChangeScene("homerh");}

    @FXML
    void AvancarVagas(ActionEvent event) throws Exception {HelloApplication.ChangeScene("telavaga");}

    @FXML
    void AvancarCargos(ActionEvent event) throws Exception { HelloApplication.ChangeScene("cargo");}

    @FXML
    void AvancarRH(ActionEvent event) throws Exception {HelloApplication.ChangeScene("rh");}

    @FXML
    void AvancarRelatorios(ActionEvent event) throws Exception {HelloApplication.ChangeScene("");}

    @FXML
    void AvaliarCandidaturas(ActionEvent event) throws Exception {HelloApplication.ChangeScene("telavaga2");}

    @FXML
    void CadastrarVagas(ActionEvent event) throws Exception {HelloApplication.ChangeScene("vaga");}

    @FXML
    void GerenciarVagas(ActionEvent event) throws Exception {HelloApplication.ChangeScene("gerenciamentovaga");}

    @FXML
    void VoltarTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("homerh");}

    @FXML
    void SairTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("login");}

}

