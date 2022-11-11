package com.example.emprego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;

public class telaVagaControler2 {

    // Nomeclatura dos botões

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
    private Button botaoVisualizarVagas;

    @FXML
    private ToggleButton botaoSair;

    @FXML
    private Button botaoVisualizar;


    // Definição dos itens da tabela

    @FXML
    private TableView tabelaVagas;

    @FXML
    private TableColumn colunaCargo;

    @FXML
    private TableColumn colunaPeriodo;

    @FXML
    private TableColumn colunaSalario;

    @FXML
    private TableColumn colunaExperiencia;

    @FXML
    private TableColumn colunaDescricao;

    @FXML
    private TableColumn colunaRemoto;


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
    void VisualizarVaga(ActionEvent event) throws Exception {HelloApplication.ChangeScene("telavaga3");}

    @FXML
    void SairTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("login");}

}
