package com.example.emprego;

import AcessoDAO.CandidaturaDAO;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class telaVagaControler4  implements  Initializable{

    // Definição dos dados pessoais do candidato

    @FXML
    private Label CpfCandidato;

    @FXML
    private Label DataCandidato;

    @FXML
    private Label EmailCandidato;

    @FXML
    private Label NomeCandidato;

    @FXML
    private Label TelefoneCandidato;


    // Definição dos dados de formação do candidato

    @FXML
    private Label CompetenciaCandidato;

    @FXML
    private Label CursoCandidato;

    @FXML
    private Label FormacaoInicio;

    @FXML
    private Label FormacaoTermino;

    @FXML
    private Label InglesCandidato;

    @FXML
    private Label InstituicaoCandidato;


    // Definição dos dados profissionais do candidato

    @FXML
    private Label CargoCandidato;

    @FXML
    private Label DescricaoCandidato;

    @FXML
    private Label EmpresaCandidato;

    @FXML
    private Label ExpInicio;

    @FXML
    private Label ExpTermino;

    @FXML
    private Label CargoInteresse;

    @FXML
    private Label PretensaoSalarial;


    // Definição dos campos da vaga;

    @FXML
    private Label CargoVaga2;

    @FXML
    private Label DescricaoVaga2;

    @FXML
    private Label ExpVaga2;

    @FXML
    private Label PeriodoVaga2;

    @FXML
    private Label RemotoVaga2;

    @FXML
    private Label SalarioVaga2;

    @FXML
    private Label EnderecoVaga2;


    // Definição dos botões

    @FXML
    private Button botaoCargo;

    @FXML
    private Button botaoHome;

    @FXML
    private Button botaoRH;

    @FXML
    private Button botaoRelatorios;

    @FXML
    private ToggleButton botaoSair;

    @FXML
    private ToggleButton botaoNext;

    @FXML
    private ToggleButton botaoBack;

    @FXML
    private Button botaoVagas;

    @FXML
    private Button botaoVoltar;

    @FXML
    private Button botaoAprovar;

    @FXML
    private Button botaoReprovar;


    @FXML
    private AnchorPane anchor;

    @FXML
    private ImageView imgModo;

    @FXML
    private AnchorPane pane1;

    @FXML
    private AnchorPane pane2;

    @FXML
    private AnchorPane pane3;

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
        CargoVaga2.setText(vagastatic.getCargo());
        SalarioVaga2.setText(String.valueOf(vagastatic.getSalario()));
        PeriodoVaga2.setText(vagastatic.getPeriodo());
        DescricaoVaga2.setText(vagastatic.getDescricao());
        ExpVaga2.setText(vagastatic.getExperiencia());
        RemotoVaga2.setText(vagastatic.getRemoto());

        Candidato candidato = new Candidato();
        NomeCandidato.setText(candidato.getNome());
        CpfCandidato.setText(String.valueOf(candidato.getCpf()));
        EmailCandidato.setText(candidato.getEmail());
        DataCandidato.setText(candidato.getDataNac());
        TelefoneCandidato.setText(String.valueOf(candidato.getTelefone()));

        InstituicaoCandidato.setText(candidato.getInstituicao());
        CursoCandidato.setText(candidato.getCurso());
        FormacaoInicio.setText(candidato.getCursoInicio());
        FormacaoTermino.setText(candidato.getCursoTermino());
        CompetenciaCandidato.setText(candidato.getCompetencia());
        InglesCandidato.setText(candidato.getIdioma());

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
    void AvancarRelatorios(ActionEvent event) throws Exception {HelloApplication.ChangeScene("rh4");}

    @FXML
    void AprovarCandidato(ActionEvent event) throws Exception {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("CANDIDATO APROVADO!");
        alert.showAndWait();
        HelloApplication.ChangeScene("telavaga3");
        VagaStatic vagaStatic = new VagaStatic();
        Candidato candidato = new Candidato();
        CandidaturaDAO candidaturaDAO = new CandidaturaDAO();
        candidaturaDAO.aprovcand(candidato.getCpf(),vagaStatic.getId());
    }

    @FXML
    void ReprovarCandidato(ActionEvent event) throws Exception {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("CANDIDATO REPROVADO!");
        alert.showAndWait();
        VagaStatic vagaStatic = new VagaStatic();
        Candidato candidato = new Candidato();
        CandidaturaDAO candidaturaDAO = new CandidaturaDAO();
        candidaturaDAO.reprovcand(candidato.getCpf(),vagaStatic.getId());
        HelloApplication.ChangeScene("telavaga3");
    }

    @FXML
    void VoltarTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("telavaga3");}

    @FXML
    void SairTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("login");}


    int show = 0;

    @FXML
    void next (ActionEvent event) {
        if (show == 0) {
            pane1.setVisible(false);
            pane2.setVisible(true);
            pane3.setVisible(false);
            show += 1;
        }else if(show == 1) {
            pane1.setVisible(false);
            pane2.setVisible(false);
            pane3.setVisible(true);
            show += 1;
        }else if(show == 2) {
            pane1.setVisible(true);
            pane2.setVisible(false);
            pane3.setVisible(false);
            show -= 2 ;
        }
    }

    @FXML
    void back (ActionEvent event) {
        if (show == 2) {
            pane1.setVisible(false);
            pane2.setVisible(true);
            pane3.setVisible(false);
            show -= 1;
        }else if(show == 1){
            pane1.setVisible(true);
            pane2.setVisible(false);
            pane3.setVisible(false);
            show -= 1;
        }else if (show == 0) {
            pane1.setVisible(false);
            pane2.setVisible(false);
            pane3.setVisible(true);
            show += 2;
        }
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
}
