package com.example.emprego;


import AcessoDAO.FuncionarioDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class rhControler4 implements Initializable {

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

    @FXML
    private Button botaoSelecionar;


    // Definindo os itens da tabela

    @FXML
    private TableView<Funcionario> tabelaFuncionarios;

    @FXML
    private TableColumn<Funcionario, String> colunaNome ;

    @FXML
    private TableColumn<Funcionario, String>  colunaEmail;

    @FXML
    private TableColumn<Funcionario, String>  colunaTelefone;

    ObservableList <Funcionario> ListaM;

    public static String getSecemail() {
        return secemail;
    }

    public static String secemail;


    // Definição das ações dos botões

    @FXML
    void AvancarHome(ActionEvent event) throws Exception {HelloApplication.ChangeScene("homerh");}

    @FXML
    void Selecionar(ActionEvent event) throws Exception{

        Funcionario selecionado = tabelaFuncionarios.getSelectionModel().getSelectedItem();
        secemail = String.valueOf(selecionado.getEmail());

        HelloApplication.ChangeScene("rh5");
    }

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colunaNome.setCellValueFactory(new PropertyValueFactory<Funcionario,String>("Nome"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<Funcionario,String>("Email"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<Funcionario,String>("Telefone"));

        ObservableList<Funcionario> ListaM = FuncionarioDAO.Datauser();
        tabelaFuncionarios.setItems(ListaM);

    }
}

