package com.example.emprego;

import AcessoDAO.CandidatoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import javafx.scene.control.ToggleButton;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;


public class candidatoControler3 implements Initializable{

    @FXML
    private Button botaoFinalizar;

    @FXML
    private Button botaoVoltar;
    
    @FXML
    private Button botaoHome;

    @FXML
    private Button botaoLogin;

    @FXML
    private ToggleButton botaoSair;

    @FXML
    private Label labelIngles;

    @FXML
    private ChoiceBox<String> campoIngles;

    private String[] nivel = {"BÁSICO", "INTERMEDIÁRIO", "AVANÇADO", "FLUENTE" };

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        campoIngles.getItems().addAll(nivel);

    }
    public void getNivel(ActionEvent event) throws Exception{
        String NivelSelecionado = campoIngles.getValue();
        labelIngles.setText(NivelSelecionado);

    }

    @FXML
    void SairTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("login");}

    @FXML
    void AvancarHome(ActionEvent event) throws Exception {HelloApplication.ChangeScene("candidato");}

    @FXML
    void AvancarLogin(ActionEvent event) throws Exception {HelloApplication.ChangeScene("login");}

    @FXML
    private TextField campoCompetencia;

    @FXML
    private TextField campoCurso;

    @FXML
    private TextField campoInicio;

    @FXML
    private TextField campoInstituicao;

    @FXML
    private TextField campoTermino;

    @FXML
    void FinalizarCadastro(ActionEvent event) throws Exception{
        String competencia = campoCompetencia.getText();
        String idioma = campoIngles.getValue();
        String instituicao = campoInstituicao.getText();
        String inicio = campoInicio.getText();
        String termino = campoTermino.getText();
        String curso = campoCurso.getText();

        if (competencia.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA A COMPETENCIA!");
            alert.showAndWait();
        } else if (idioma.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O IDIOMA!");
            alert.showAndWait();
        } else if (instituicao.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA A INSTITUIÇÃO!");
            alert.showAndWait();
        } else if (inicio.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA A DATA DE INICIO!");
            alert.showAndWait();
        } else if (termino.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA A DATA DE TERMINO!");
            alert.showAndWait();
        } else if (curso.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O CURSO!");
            alert.showAndWait();
        } else {
            // Validação data inicio
            String INICIO_REGEX = "^\\d{2}/\\d{2}/\\d{4}$";
            Pattern INICIO_PATTERN = Pattern.compile(INICIO_REGEX);
            if (INICIO_PATTERN.matcher(inicio).matches()) {
                // Validação data termino
                String TERMINO_REGEX = "^\\d{2}/\\d{2}/\\d{4}$";
                Pattern TERMINO_PATTERN = Pattern.compile(TERMINO_REGEX);
                if (TERMINO_PATTERN.matcher(termino).matches()) {
                    Candidato candidato = new Candidato();
                    candidato.setCompetencia(competencia);
                    candidato.setIdioma(idioma);
                    candidato.setInstituicao(instituicao);
                    candidato.setCursoInicio(inicio);
                    candidato.setCursoTermino(termino);
                    candidato.setCurso(curso);

                    String nome = candidato.getNome();
                    long cpf = candidato.getCpf();
                    String data = candidato.getDataNac();
                    String email = candidato.getEmail();
                    String senha = candidato.getSenha();
                    long telefone = candidato.getTelefone();
                    String empresa = candidato.getExpEmpresa();
                    String cargo = candidato.getCargo();
                    String expinicio = candidato.getExpInicio();
                    String exptermino = candidato.getExpTermino();
                    String descricao = candidato.getDescricao();
                    String cargos = candidato.getCargoInteresse();
                    String pretensao = String.valueOf(candidato.getPretSalarial());

                    float sal = Float.valueOf(pretensao);

                    CandidatoDAO candidatoDAO = new CandidatoDAO();

                    Candidato candidatobanc = new Candidato();
                    candidatobanc.setNome(nome);
                    candidatobanc.setCpf(cpf);
                    candidatobanc.setDataNac(data);
                    candidatobanc.setTelefone(telefone);
                    candidatobanc.setPretSalarial(String.valueOf(sal));

                    candidatoDAO.savecand(candidatobanc);

                    CandidatoDAO candidatoUsuDAO = new CandidatoDAO();
                    Candidato candusu = new Candidato();

                    candusu.setEmail(email);
                    candusu.setSenha(senha);
                    candusu.setCpf(cpf);

                    candidatoUsuDAO.saveusucand(candusu);

                    HelloApplication.ChangeScene("candidatofinal");
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("FORMATO DE DATA INVÁLIDO!");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("FORMATO DE DATA INVÁLIDO!");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void mascaraData() {
        Formatter data = new Formatter();
        data.setMask("##/##/####");
        data.setCaracteresValidos("0123456789");
        data.setTf(campoInicio);
        data.formatter();
    }

    @FXML
    private void mascaraData2() {
        Formatter data = new Formatter();
        data.setMask("##/##/####");
        data.setCaracteresValidos("0123456789");
        data.setTf(campoTermino);
        data.formatter();
    }

    @FXML
    void VoltarTela(ActionEvent event) throws Exception {
        HelloApplication.ChangeScene("candidato2");
    }
}
