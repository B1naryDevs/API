package com.example.emprego;

import AcessoDAO.CandidaturaDAO;
import AcessoDAO.CargoDAO;
import AcessoDAO.VagaDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

public class telaVagaControler2 implements Initializable {

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
    private Button botaoSelecionar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private ToggleButton botaoSair;


    // Definição dos itens da tabela

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
    @FXML
    private TableColumn<Vaga, String> colunaId;

    private static Integer selid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colunaCargo.setCellValueFactory(new PropertyValueFactory<Vaga,String>("Cargo"));
        colunaPeriodo.setCellValueFactory(new PropertyValueFactory<Vaga,String>("Periodo"));
        colunaSalario.setCellValueFactory(new PropertyValueFactory<Vaga, String>("Salario"));
        colunaExperiencia.setCellValueFactory(new PropertyValueFactory<Vaga,String>("Experiencia"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<Vaga,String>("Descricao"));
        colunaRemoto.setCellValueFactory(new PropertyValueFactory<Vaga,String>("Remoto"));
        colunaId.setCellValueFactory(new PropertyValueFactory<Vaga,String>("Id"));

        ObservableList<Vaga> ListaP = VagaDAO.Datauser();
        tabelaVagas.setItems(ListaP);

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
    void SelecionarVaga(ActionEvent event) throws Exception {
        try {
            Vaga selecionado = tabelaVagas.getSelectionModel().getSelectedItem();
            selid = Integer.valueOf(selecionado.getId());
            VagaDAO vagaDao = new VagaDAO();
            vagaDao.Search(selid);

            HelloApplication.ChangeScene("telavaga3");
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("SELECIONE UMA VAGA!");
            alert.showAndWait();
        }
    }

    @FXML
    void VoltarTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("telavaga");}

    @FXML
    void SairTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("login");}

}
