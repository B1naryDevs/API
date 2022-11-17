package com.example.emprego;

import AcessoDAO.VagaDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class telaVagaControler3 implements Initializable {

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
    private Label BairroVaga;

    @FXML
    private Label CargoVaga;

    @FXML
    private Label CepVaga;

    @FXML
    private Label CidadeVaga;

    @FXML
    private Label ComplVaga;

    @FXML
    private Label DescricaoVaga;

    @FXML
    private Label EnderecoVaga;

    @FXML
    private Label ExpVaga;

    @FXML
    private Label NumeroVaga;

    @FXML
    private Label PeriodoVaga;

    @FXML
    private Label RemotoVaga;

    @FXML
    private Label SalarioVaga;

    @FXML
    private Label UfVaga;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        VagaStatic vagastatic = new VagaStatic();
        CargoVaga.setText(vagastatic.getCargo());
        SalarioVaga.setText(String.valueOf(vagastatic.getSalario()));
        PeriodoVaga.setText(vagastatic.getPeriodo());
        DescricaoVaga.setText(vagastatic.getDescricao());
        ExpVaga.setText(vagastatic.getExperiencia());
        RemotoVaga.setText(vagastatic.getRemoto());
    }


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
