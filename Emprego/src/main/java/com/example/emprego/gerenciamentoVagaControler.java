package com.example.emprego;

import AcessoDAO.CargoDAO;
import AcessoDAO.FuncionarioDAO;
import AcessoDAO.VagaDAO;
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

public class gerenciamentoVagaControler implements Initializable {

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
    private ToggleButton botaoRemover;

    @FXML
    private ToggleButton botaoEditar;



    // Definindo os itens da tabela

    @FXML
    private TableView tabelaVagas;

    @FXML
    private TableColumn colunaCargo ;

    @FXML
    private TableColumn colunaPeriodo ;

    @FXML
    private TableColumn colunaSalario ;

    @FXML
    private TableColumn colunaExperiencia ;

    @FXML
    private TableColumn colunaDescricao ;

    @FXML
    private TableColumn colunaRemoto ;

    @FXML
    private TableColumn colunaId;

    @FXML
    private TableColumn colunaFuncionario;


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
    void VoltarTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("telavaga");}

    @FXML
    void RemoverVaga(ActionEvent event) throws Exception {}

    @FXML
    void EditarVaga(ActionEvent event) throws Exception {}

    @FXML
    void SairTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("login");}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colunaCargo.setCellValueFactory(new PropertyValueFactory<Vaga,String>("Cargo"));
        colunaPeriodo.setCellValueFactory(new PropertyValueFactory<Vaga,String>("Periodo"));
        colunaSalario.setCellValueFactory(new PropertyValueFactory<Vaga, String>("Salario"));
        colunaExperiencia.setCellValueFactory(new PropertyValueFactory<Vaga,String>("Experiencia"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<Vaga,String>("Descricao"));
        colunaRemoto.setCellValueFactory(new PropertyValueFactory<Vaga,String>("Remoto"));
        colunaId.setCellValueFactory(new PropertyValueFactory<Vaga,String>("Id"));
        colunaFuncionario.setCellValueFactory(new PropertyValueFactory<Vaga,String>("Funcionario"));

        ObservableList<Vaga> vagaList = VagaDAO.Vga();
        tabelaVagas.setItems(vagaList);

    }

}
