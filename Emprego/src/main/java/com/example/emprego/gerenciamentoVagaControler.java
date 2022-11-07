package com.example.emprego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;

public class gerenciamentoVagaControler {

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
    private ToggleButton botaoSair;

    // Definindo os itens da tabela

    @FXML
    private TableView tabelaGerenciamentoVagas;

    @FXML
    private TableColumn colunaGerCargo ;

    @FXML
    private TableColumn colunaGerPeriodo ;

    @FXML
    private TableColumn colunaGerSalario ;

    @FXML
    private TableColumn colunaGerExperiencia ;

    @FXML
    private TableColumn colunaGerDescricao ;

    @FXML
    private TableColumn colunaGerRemoto ;


    // Definição das ações dos botões

    @FXML
    void AvancarHome(ActionEvent event) throws Exception {HelloApplication.ChangeScene("homerh");}

    @FXML
    void AvancarVagas(ActionEvent event) throws Exception {HelloApplication.ChangeScene("vaga");}

    @FXML
    void AvancarCargos(ActionEvent event) throws Exception { HelloApplication.ChangeScene("cargo");}

    @FXML
    void AvancarRH(ActionEvent event) throws Exception {HelloApplication.ChangeScene("rh");}

    @FXML
    void AvancarRelatorios(ActionEvent event) throws Exception {HelloApplication.ChangeScene("");}

    @FXML
    void SairTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("login");}


}
