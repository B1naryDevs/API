package com.example.emprego;

import AcessoDAO.CandidaturaDAO;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class processoSeletivoControler  implements Initializable {


    // Nomeclatura dos botões

    @FXML
    private Button botaoHome;

    @FXML
    private Button botaoAreaCandidato;

    @FXML
    private Button botaoVagas;

    @FXML
    private Button botaoSobre;

    @FXML
    private Button botaoVoltar;


    @FXML
    private ToggleButton botaoSair;

    @FXML
    private TableView<Candidatura> tabelaCandidaturas;
    @FXML
    private TableColumn<Candidatura, String> colunaCargo ;
    @FXML
    private TableColumn<Candidatura, String> colunaData ;
    @FXML
    private TableColumn<Candidatura, String> colunaStatus ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colunaCargo.setCellValueFactory(new PropertyValueFactory<Candidatura,String>("Cargo"));
        colunaData.setCellValueFactory(new PropertyValueFactory<Candidatura,String>("Data"));
        colunaStatus.setCellValueFactory(new PropertyValueFactory<Candidatura, String>("Status"));

        ObservableList<Candidatura> ListaP = CandidaturaDAO.Datauser();
        tabelaCandidaturas.setItems(ListaP);

    }


    // Definição das ações dos botões

    @FXML
    void AvancarHome(ActionEvent event) throws Exception {HelloApplication.ChangeScene("home");}

    @FXML
    void AvancarAreaCandidato(ActionEvent event) throws Exception {HelloApplication.ChangeScene("areacandidato");}

    @FXML
    void VoltarAreaCandidato(ActionEvent event) throws Exception {HelloApplication.ChangeScene("areacandidato");}

    @FXML
    void AvancarVagas(ActionEvent event) throws Exception {HelloApplication.ChangeScene("candidatura");}

    @FXML
    void AvancarSobre(ActionEvent event) throws Exception {HelloApplication.ChangeScene("sobre");}

    @FXML
    void SairTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("login");}

}


