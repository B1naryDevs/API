package com.example.emprego;

import AcessoDAO.VagaDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class candidaturaControler implements Initializable{

    // Nomeclatura dos botões

    @FXML
    private Button botaoHome;

    @FXML
    private Button botaoCargo;

    @FXML
    private Button botaoVaga;

    @FXML
    private Button botaoRH;

    @FXML
    private Button botaoRelatorio;

    @FXML
    private Button botaoCandidatar;

    @FXML
    private MenuButton botaoFiltrar;

    // Definindo os itens da tabela

    @FXML
    private TableView<Vaga> tabelaVagas;
    @FXML
    private TableColumn<Vaga, String> colunaCargo ;
    @FXML
    private TableColumn<Vaga, String> colunaPeriodo ;
    @FXML
    private TableColumn<Vaga, String> colunaSalario ;
    @FXML
    private TableColumn<Vaga, String> colunaExperiencia ;
    @FXML
    private TableColumn<Vaga, String> colunaDescricao ;
    @FXML
    private TableColumn<Vaga, String> colunaRemoto ;

    public static String selcargo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colunaCargo.setCellValueFactory(new PropertyValueFactory<Vaga,String>("Cargo"));
        colunaPeriodo.setCellValueFactory(new PropertyValueFactory<Vaga,String>("Periodo"));
        colunaSalario.setCellValueFactory(new PropertyValueFactory<Vaga, String>("Salario"));
        colunaExperiencia.setCellValueFactory(new PropertyValueFactory<Vaga,String>("Experiencia"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<Vaga,String>("Descricao"));
        colunaRemoto.setCellValueFactory(new PropertyValueFactory<Vaga,String>("Remoto"));

        ObservableList<Vaga> ListaP = VagaDAO.Datauser();
        tabelaVagas.setItems(ListaP);

    }

    // Definição das ações dos botões

    @FXML
    void AvancarHome(ActionEvent event) {HelloApplication.ChangeScene("menu");}

    @FXML
    void AvancarVaga(ActionEvent event) {HelloApplication.ChangeScene("vaga");}

    @FXML
    void AvancarCargo(ActionEvent event) { HelloApplication.ChangeScene("cargo");}

    @FXML
    void AvancarRH(ActionEvent event) {HelloApplication.ChangeScene("rh");}

    @FXML
    void AvancarRelatorio(ActionEvent event) {HelloApplication.ChangeScene("");}

    @FXML
    void SairTela(ActionEvent event) {HelloApplication.ChangeScene("login");}

    @FXML
    void Candidatar(ActionEvent event) {

        Vaga selecionado = tabelaVagas.getSelectionModel().getSelectedItem();
        selcargo = String.valueOf(selecionado.getCargo());

        HelloApplication.ChangeScene("candidatura2");
    }

}
