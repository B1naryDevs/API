package com.example.emprego;

import AcessoDAO.CandidatoDAO;
import AcessoDAO.FuncionarioDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class relatorioControler2 implements Initializable{

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

    // Definição dos itens da tabela

    @FXML
    private TableView<Funcionario> tabelaRelatorios;

    @FXML
    private TableColumn<Funcionario, String> colunaFuncionario;

    @FXML
    private TableColumn<Funcionario, Integer> colunaVagas;

    @FXML
    private TableColumn<Funcionario, Integer> colunaAprovados;

    @FXML
    private TableColumn<Funcionario, Integer> colunaReprovados;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colunaFuncionario.setCellValueFactory(new PropertyValueFactory<Funcionario,String>("Nome"));
        colunaVagas.setCellValueFactory(new PropertyValueFactory<Funcionario,Integer>("Vagas"));
        colunaAprovados.setCellValueFactory(new PropertyValueFactory<Funcionario,Integer>("Aprovados"));
        colunaReprovados.setCellValueFactory(new PropertyValueFactory<Funcionario,Integer>("Reprovados"));

        rhControler4 rhControler4 = new rhControler4();
        ObservableList<Funcionario> ListaP = FuncionarioDAO.Datafunc2(rhControler4);
        tabelaRelatorios.setItems(ListaP);
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
    void AvancarRelatorios(ActionEvent event) throws Exception {HelloApplication.ChangeScene("relatorio");}

    @FXML
    void VoltarTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("telavaga");}

    @FXML
    void SairTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("login");}

}
