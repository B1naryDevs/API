package com.example.emprego;

import AcessoDAO.CandidaturaDAO;
import AcessoDAO.CargoDAO;
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
import java.util.Calendar;
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
    private ChoiceBox<String> campoFiltrar;

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

    public static Integer selid;
    public static String selcargo;

    public static long selfuncionario;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for (String c : CargoDAO.carg()){

            //adicionar cargos
            campoFiltrar.getItems().add(c);

        }

        colunaCargo.setCellValueFactory(new PropertyValueFactory<Vaga,String>("Cargo"));
        colunaPeriodo.setCellValueFactory(new PropertyValueFactory<Vaga,String>("Periodo"));
        colunaSalario.setCellValueFactory(new PropertyValueFactory<Vaga, String>("Salario"));
        colunaExperiencia.setCellValueFactory(new PropertyValueFactory<Vaga,String>("Experiencia"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<Vaga,String>("Descricao"));
        colunaRemoto.setCellValueFactory(new PropertyValueFactory<Vaga,String>("Remoto"));
        colunaId.setCellValueFactory(new PropertyValueFactory<Vaga,String>("Id"));
        colunaFuncionario.setCellValueFactory(new PropertyValueFactory<Vaga,String>("Funcionario"));

        ObservableList<Vaga> ListaP = VagaDAO.Datauser();
        tabelaVagas.setItems(ListaP);

    }

    // Definição das ações dos botões

    @FXML
    void AvancarHome(ActionEvent event) throws Exception {HelloApplication.ChangeScene("home");}

    @FXML
    void AvancarAreaCandidato(ActionEvent event) throws Exception {HelloApplication.ChangeScene("areacandidato");}

    @FXML
    void AvancarVagas(ActionEvent event) throws Exception {HelloApplication.ChangeScene("candidatura");}

    @FXML
    void AvancarSobre(ActionEvent event) throws Exception {HelloApplication.ChangeScene("sobre");}

    @FXML
    void SairTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("login");}


    @FXML
    void Candidatar(ActionEvent event) throws Exception {

        try {
            Vaga selecionado = tabelaVagas.getSelectionModel().getSelectedItem();
            selid = Integer.valueOf(selecionado.getId());
            selcargo = String.valueOf(selecionado.getCargo());
            selfuncionario = Long.valueOf(selecionado.getFuncionario());
            String data = (Calendar.getInstance().get(Calendar.YEAR) + "-" + (Calendar.getInstance().get(Calendar.MONTH) + 1) + "-" + Calendar.getInstance().get(Calendar.DATE));
            CandidaturaDAO candidaturaDAO = new CandidaturaDAO();
            Candidatura candidatura = new Candidatura(selcargo, selid, data, "Em andamento", selfuncionario);
            Usuario usuario = new Usuario();
            candidaturaDAO.save(candidatura,usuario);

            HelloApplication.ChangeScene("candidatura2");
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("SELECIONE UMA VAGA!");
            alert.showAndWait();
        }
    }

    @FXML
    void Filtrar(ActionEvent event) throws Exception {

        try {
            String filtro = campoFiltrar.getValue();

            if(filtro==null){
                FiltroVagas filtrovagas = new FiltroVagas();
                filtrovagas.setFiltro(null);
            }else{
                FiltroVagas filtrovagas = new FiltroVagas();
                filtrovagas.setFiltro(filtro);
            }
            HelloApplication.ChangeScene("candidatura");
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("SELECIONE UM FILTRO!");
            alert.showAndWait();
        }
    }

}
