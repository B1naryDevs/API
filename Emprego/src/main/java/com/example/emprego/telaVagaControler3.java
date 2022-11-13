package com.example.emprego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TextField;

public class telaVagaControler3 {

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
    private Button botaoVoltar;

    @FXML
    private ToggleButton botaoSair;

    @FXML
    private Button botaoSelecionar;


    // Definição dos itens da tabela;

    @FXML
    private TableView tabelaCandidatos;

    @FXML
    private TableColumn colunaNome;


    // Definição dos campos da vaga;

    @FXML
    private TextField BairroVaga;

    @FXML
    private TextField CargoVaga;

    @FXML
    private TextField CepVaga;

    @FXML
    private TextField CidadeVaga;

    @FXML
    private TextField ComplVaga;

    @FXML
    private TextField DescricaoVaga;

    @FXML
    private TextField EnderecoVaga;

    @FXML
    private TextField ExpVaga;

    @FXML
    private TextField NumeroVaga;

    @FXML
    private TextField PeriodoVaga;

    @FXML
    private TextField RemotoVaga;

    @FXML
    private TextField SalarioVaga;

    @FXML
    private TextField UfVaga;


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
    void SelecionarCandidato(ActionEvent event) throws Exception {HelloApplication.ChangeScene("telavaga4");}

    @FXML
    void VoltarTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("telavaga2");}

    @FXML
    void SairTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("login");}

}
