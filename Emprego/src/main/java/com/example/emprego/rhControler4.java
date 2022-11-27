package com.example.emprego;


import AcessoDAO.FuncionarioDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
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
    private ToggleButton botaoRemover;

    @FXML
    private ToggleButton botaoEditar;

    @FXML
    private Button botaoRelatorio;

    @FXML
    private ToggleButton tgbtModo;

    @FXML
    private AnchorPane anchor;

    @FXML
    private ImageView imgModo;

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

    public static Long getSeccpf() {
        return seccpf;
    }

    public static Long seccpf;


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
    void TelaRelatorios(ActionEvent event) throws Exception {
        HelloApplication.ChangeScene("relatorio");
    }

    @FXML
    void RemoverFunc(ActionEvent event) throws Exception {

        try{

            Usuario emg = new Usuario();
            emg.getEmail();

            if (emg.getEmail().equals("Adm@gmail.com")){

                Funcionario selecionado = tabelaFuncionarios.getSelectionModel().getSelectedItem();
                secemail = String.valueOf(selecionado.getEmail());
                String nome =  String.valueOf(selecionado.getNome());

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("AVISO");
                alert.setHeaderText("VOCÊ REALMENTE DESEJA REMOVER\n" + nome + " ?");
                ButtonType cancelButton = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.getDialogPane().getButtonTypes().add(cancelButton);

                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK){

                    vg_func();

                    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                    Funcionario funcionario = new Funcionario();
                    funcionario.setEmail(secemail);
                    funcionarioDAO.deletefunc(funcionario);



                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setHeaderText("USUARIO DELETADO COM SUCESSO");
                    alert2.showAndWait();

                    colunaNome.setCellValueFactory(new PropertyValueFactory<Funcionario,String>("Nome"));
                    colunaEmail.setCellValueFactory(new PropertyValueFactory<Funcionario,String>("Email"));
                    colunaTelefone.setCellValueFactory(new PropertyValueFactory<Funcionario,String>("Telefone"));

                }

                ObservableList<Funcionario> ListaM = FuncionarioDAO.Datauser();
                tabelaFuncionarios.setItems(ListaM);

            }else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("ACESSO NEGADO!");
                alert.showAndWait();

            }


        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("SELECIONE UM COLABORADOR !");
            alert.showAndWait();
        }

    }

    @FXML
    void Edit(ActionEvent event) throws Exception {

        try {

            Funcionario selecionado = tabelaFuncionarios.getSelectionModel().getSelectedItem();
            secemail = String.valueOf(selecionado.getEmail());
            seccpf = Long.valueOf(selecionado.getCpf());

            Usuario emg = new Usuario();
            emg.getEmail();

            if (emg.getEmail().equals("Adm@gmail.com")){

                HelloApplication.ChangeScene("rh5");
            }

            else{

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("ACESSO NEGADO!");
                alert.showAndWait();

            }

        }catch (Exception e){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("SELECIONE UM USUÁRIO");
            alert.showAndWait();

        }



    }

    @FXML
    void SairTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("login");}

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

        colunaNome.setCellValueFactory(new PropertyValueFactory<Funcionario,String>("Nome"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<Funcionario,String>("Email"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<Funcionario,String>("Telefone"));

        ObservableList<Funcionario> ListaM = FuncionarioDAO.Datauser();
        tabelaFuncionarios.setItems(ListaM);

    }
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

    void vg_func(){

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        long cpf = 0L;
        Funcionario selecionado = tabelaFuncionarios.getSelectionModel().getSelectedItem();
        String eml = String.valueOf(selecionado.getEmail());

        for (Funcionario rh : funcionarioDAO.Func(eml)){
            cpf = rh.getCpf();
        }

        funcionarioDAO.deletevg(cpf);

    }

}

