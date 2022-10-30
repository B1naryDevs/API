package com.example.emprego;


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
import java.sql.SQLException;
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
    private Button botaoSobre;

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


    // Definição das ações dos botões

    @FXML
    void AvancarHome(ActionEvent event) {HelloApplication.ChangeScene("menu");}

    @FXML
    void Selecionar (ActionEvent event) throws SQLException {

    }

    void selec (String full) {

    }

    //@FXML
    //void Selecionar(ActionEvent event) {HelloApplication.ChangeScene("rh5");}

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colunaNome.setCellValueFactory(new PropertyValueFactory<Funcionario,String>("Nome"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<Funcionario,String>("Email"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<Funcionario,String>("Telefone"));

        ObservableList<Funcionario> ListaM = FuncionarioDAO.Datauser();
        tabelaFuncionarios.setItems(ListaM);

    }
}
