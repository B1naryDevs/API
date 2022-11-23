package com.example.emprego;

import AcessoDAO.FuncionarioDAO;
import AcessoDAO.VagaDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Optional;
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

    @FXML
    private TableColumn<Vaga, String> colunaFuncionario;

    @FXML
    private TableColumn<Vaga, String> colunaStatus;

    static int id_vaga;


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
    void RemoverVaga(ActionEvent event) throws Exception {

        //Coleta de identificador da vaga

        Vaga vg = tabelaVagas.getSelectionModel().getSelectedItem();

        id_vaga = vg.getId();

        try{

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("AVISO");
            alert.setHeaderText("VOCÊ REALMENTE DESEJA APAGAR ESSA VAGA");
            ButtonType cancelButton = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getDialogPane().getButtonTypes().add(cancelButton);

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {

                //CÓDIGO AQUI ABAIXO

                VagaDAO vagaDAO = new VagaDAO();
                vagaDAO.deletevaga(id_vaga);

                //POP-UP DE AVISO DE DELETE DA VAGA

                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setHeaderText("VAGA DELETADA COM SUCESSO ");
                alert2.showAndWait();

                tabela();

            }

        }catch (Exception e){

            Alert alert3 = new Alert(Alert.AlertType.ERROR);
            alert3.setHeaderText("ERRO AO TENTAR EXCLUIR");
            alert3.showAndWait();

        }

    }

    @FXML
    void EditarVaga(ActionEvent event) throws Exception {

        Vaga vg = tabelaVagas.getSelectionModel().getSelectedItem();
        id_vaga = vg.getId();

        HelloApplication.ChangeScene("gerenciamentovaga2");
    }

    @FXML
    void SairTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("login");}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tabela();

    }

    void tabela(){

        try {


            Usuario usuario = new Usuario();
            //captura de email
            String email = usuario.getEmail();

            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

            if (email.equals("Adm@gmail.com")) {

                colunaCargo.setCellValueFactory(new PropertyValueFactory<Vaga, String>("Cargo"));
                colunaPeriodo.setCellValueFactory(new PropertyValueFactory<Vaga, String>("Periodo"));
                colunaSalario.setCellValueFactory(new PropertyValueFactory<Vaga, String>("Salario"));
                colunaExperiencia.setCellValueFactory(new PropertyValueFactory<Vaga, String>("Experiencia"));
                colunaDescricao.setCellValueFactory(new PropertyValueFactory<Vaga, String>("Descricao"));
                colunaRemoto.setCellValueFactory(new PropertyValueFactory<Vaga, String>("Remoto"));
                colunaId.setCellValueFactory(new PropertyValueFactory<Vaga, String>("Id"));
                colunaFuncionario.setCellValueFactory(new PropertyValueFactory<Vaga, String>("Funcionario"));
                colunaStatus.setCellValueFactory(new PropertyValueFactory<Vaga, String>("status_vaga"));

                ObservableList<Vaga> vagaList = VagaDAO.Vga();
                tabelaVagas.setItems(vagaList);

            } else {

                //VISUALIZAR VAGAS PUBLICADAS APENAS PELO FUNCIONARIO

                long cpf = 0L;

                for (Funcionario rh: funcionarioDAO.Func(email)){

                    cpf = rh.getCpf();

                }

                colunaCargo.setCellValueFactory(new PropertyValueFactory<Vaga, String>("Cargo"));
                colunaPeriodo.setCellValueFactory(new PropertyValueFactory<Vaga, String>("Periodo"));
                colunaSalario.setCellValueFactory(new PropertyValueFactory<Vaga, String>("Salario"));
                colunaExperiencia.setCellValueFactory(new PropertyValueFactory<Vaga, String>("Experiencia"));
                colunaDescricao.setCellValueFactory(new PropertyValueFactory<Vaga, String>("Descricao"));
                colunaRemoto.setCellValueFactory(new PropertyValueFactory<Vaga, String>("Remoto"));
                colunaId.setCellValueFactory(new PropertyValueFactory<Vaga, String>("Id"));
                colunaFuncionario.setCellValueFactory(new PropertyValueFactory<Vaga, String>("Funcionario"));
                colunaStatus.setCellValueFactory(new PropertyValueFactory<Vaga, String>("status_vaga"));

                ObservableList<Vaga> vagaList = VagaDAO.VgaFilt(cpf);
                tabelaVagas.setItems(vagaList);

            }

        }catch (Exception e){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("ERRO AO TENTAR ABRIR O GERENCIAMENTO");
            alert.showAndWait();

        }

    }

}
