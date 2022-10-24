package com.example.emprego;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class rhControler4  {

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
    private Button botaoSobre;

    @FXML
    private ToggleButton botaoSair;

    @FXML
    private Button botaoSelecionar;


    // Definindo os itens da tabela

    @FXML
    private TableView<RH> tabelaFuncionarios;

    @FXML
    private TableColumn<Object, Object> colunaNome ;

    @FXML
    private TableColumn<Object, Object> colunaEmail;

    @FXML
    private TableColumn<Object, Object> colunaEmpresa;

    private List<RH> listRh = new ArrayList<>();
    private ObservableList<RH> observablerh;


    // Definição das ações dos botões

    @FXML
    void AvancarHome(ActionEvent event) {HelloApplication.ChangeScene("menu");}

    @FXML
    void Selecionar (ActionEvent event) {

        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colunaEmpresa.setCellValueFactory(new PropertyValueFactory<>("empresa"));

        RH func = new RH();
        RH.setNome("Wallace");
        RH.setEmail("Legal");
        RH.setEmpresa("Show");

        listRh.add(func);

        String ter = "";

        observablerh = FXCollections.observableArrayList(listRh);
        tabelaFuncionarios.setItems(observablerh);

        selec("www");

    }

    void selec (String full) {

    }

    @FXML
    void AvancarVagas(ActionEvent event) {HelloApplication.ChangeScene("vaga");}

    @FXML
    void AvancarCargos(ActionEvent event) { HelloApplication.ChangeScene("cargo");}

    @FXML
    void AvancarRH(ActionEvent event) {HelloApplication.ChangeScene("rh");}

    @FXML
    void AvancarSobre(ActionEvent event) {HelloApplication.ChangeScene("");}

    @FXML
    void AvancarRelatorios(ActionEvent event) {HelloApplication.ChangeScene("");}

    @FXML
    void SairTela(ActionEvent event) {HelloApplication.ChangeScene("login");}
}

