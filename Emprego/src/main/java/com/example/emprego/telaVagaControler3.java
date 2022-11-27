package com.example.emprego;

import AcessoDAO.CandidatoDAO;
import AcessoDAO.VagaDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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

    @FXML
    private ToggleButton tgbtModo;

    @FXML
    private AnchorPane anchor;

    @FXML
    private ImageView imgModo;


    // Definição dos itens da tabela;

    @FXML
    private TableView<CandidatoTabela> tabelaCandidatos;

    @FXML
    private TableColumn<CandidatoTabela , String> colunaNome;

    @FXML
    private TableColumn<CandidatoTabela , String> colunaTelefone;

    @FXML
    private TableColumn<CandidatoTabela , String> colunaCpf;


    // Definição dos campos da vaga;

    @FXML
    private Label CargoVaga;

    @FXML
    private Label DescricaoVaga;

    @FXML
    private Label EnderecoVaga;

    @FXML
    private Label ExpVaga;

    @FXML
    private Label PeriodoVaga;

    @FXML
    private Label RemotoVaga;

    @FXML
    private Label SalarioVaga;

    public static long selcpf;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Tema tema = new Tema();
        if (tema.getLuz() == false) {
            Image image = new Image("file:src/main/resources/imagens/Lua.png", 25, 25, true, true);
            anchor.getStylesheets().add("file:src/main/resources/styles/ModoEscuro.css");
            imgModo.setImage(image);
        } else {
            Image image = new Image("file:src/main/resources/imagens/Sol.png", 25, 25, true, true);
            anchor.getStylesheets().add("file:src/main/resources/styles/ModoClaro.css");
            imgModo.setImage(image);
        }

        VagaStatic vagastatic = new VagaStatic();
        CargoVaga.setText(vagastatic.getCargo());
        SalarioVaga.setText(String.valueOf(vagastatic.getSalario()));
        PeriodoVaga.setText(vagastatic.getPeriodo());
        DescricaoVaga.setText(vagastatic.getDescricao());
        ExpVaga.setText(vagastatic.getExperiencia());
        RemotoVaga.setText(vagastatic.getRemoto());
        EnderecoVaga.setText(vagastatic.getEndereco());

        colunaNome.setCellValueFactory(new PropertyValueFactory<CandidatoTabela,String>("Nome"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<CandidatoTabela,String>("Telefone"));
        colunaCpf.setCellValueFactory(new PropertyValueFactory<CandidatoTabela,String>("Cpf"));

        ObservableList<CandidatoTabela> ListaP = CandidatoDAO.Datauser(vagastatic.getId());
        tabelaCandidatos.setItems(ListaP);
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
    void SelecionarCandidato(ActionEvent event) throws Exception {
        try {
            CandidatoTabela selecionado = tabelaCandidatos.getSelectionModel().getSelectedItem();
            selcpf = Long.valueOf(selecionado.getCpf());
            CandidatoDAO candidatoDAO = new CandidatoDAO();
            candidatoDAO.Search(selcpf);
            candidatoDAO.Search2(selcpf);

            HelloApplication.ChangeScene("telavaga4");
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("SELECIONE UM CANDIDATO!");
            alert.showAndWait();
        }
    }

    @FXML
    void VoltarTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("telavaga2");}

    @FXML
    void SairTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("login");}

    public void alterarModo(ActionEvent event) {
        Tema tema = new Tema();
        if (tema.getLuz() == false) {
            Image image = new Image("file:src/main/resources/imagens/Sol.png", 25, 25, true, true);
            anchor.getStylesheets().add("file:src/main/resources/styles/ModoClaro.css");
            anchor.getStylesheets().remove("file:src/main/resources/styles/ModoEscuro.css");
            imgModo.setImage(image);
            tema.setLuz(true);
        } else {
            Image image = new Image("file:src/main/resources/imagens/Lua.png", 25, 25, true, true);
            anchor.getStylesheets().add("file:src/main/resources/styles/ModoEscuro.css");
            anchor.getStylesheets().remove("file:src/main/resources/styles/ModoClaro.css");
            imgModo.setImage(image);
            tema.setLuz(false);
        }
    }
}
