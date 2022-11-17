package com.example.emprego;

import AcessoDAO.CandidatoDAO;
import AcessoDAO.CargoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.beans.BeanProperty;
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
import javafx.scene.control.ChoiceBox;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.ToggleButton;

public class candidatoControler2 implements Initializable {


    @FXML
    private Button botaoAvancar;
    @FXML
    private Button botaoAdicionar;

    @FXML
    private ToggleButton botaoSair;

    @FXML
    private Label labelEmpresa;

    @FXML
    private Label labelCargo;

    @FXML
    private Label labelInicio;

    @FXML
    private Label labelTermino;

    @FXML
    private Label labelDescricao;

    @FXML
    private Label labelCargoInteresse;

    @FXML
    private CheckBox campoAtual;

    @FXML
    private TextField campoCargo;

    @FXML
    private TextField campoPretensao;

    @FXML
    private TextField campoDescricao;

    @FXML
    private TextField campoEmpresa;

    @FXML
    private TextField campoInicio;

    @FXML
    private TextField campoTermino;

    @FXML
    public ChoiceBox<String> campoCargoInteresse;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        // laço para percorrer a lista e adicionar os componentes
        for (String c : CargoDAO.carg()){

            //adicionar cargos
            campoCargoInteresse.getItems().add(c);

        }

    }

    public void getInteresse(ActionEvent event){
        String cargoSelecionado = campoCargoInteresse.getValue();
        labelCargoInteresse.setText(cargoSelecionado);

    }
    
    @FXML
    void SairTela(ActionEvent event) throws Exception{HelloApplication.ChangeScene("login");}
    @FXML
    void AvancarTela(ActionEvent event) throws Exception {
        String cargos = campoCargoInteresse.getValue();
        String pretensao = campoPretensao.getText();

        if (cargos==null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O CARGO DE INTERESSE!");
            alert.showAndWait();
        } else if (pretensao.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA A PRETENSÃO SALARIAL!");
            alert.showAndWait();
        } else {
            // Validacao pretensão salarial, mínimo 3 digitos
            String PRETENSAO_REGEX = "\\d{3,}";
            Pattern PRETENSAO_PATTERN = Pattern.compile(PRETENSAO_REGEX);
            if (PRETENSAO_PATTERN.matcher(pretensao).matches()) {
                Candidato candidato = new Candidato();
                candidato.setCargoInteresse(cargos);
                candidato.setPretSalarial(pretensao);

                CandidatoDAO candidatoDAO = new CandidatoDAO();
                candidatoDAO.updateprefcand(candidato);

                HelloApplication.ChangeScene("candidato3");

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("FORMATO DE PRETENSÃO SALARIAL INVÁLIDO!");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void AdicionarExp(ActionEvent event) throws Exception {
        String empresa = campoEmpresa.getText();
        String cargo = campoCargo.getText();
        String inicio = campoInicio.getText();
        String termino = campoTermino.getText();
        String descricao = campoDescricao.getText();

        if (empresa.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA A EMPRESA!");
            alert.showAndWait();
        } else if (cargo.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O CARGO OCUPADO!");
            alert.showAndWait();
        } else if (inicio.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O INÍCIO!");
            alert.showAndWait();
        } else if (!campoAtual.isSelected() && termino.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O TÉRMINO!");
            alert.showAndWait();
        } else if (descricao.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA A DESCRIÇÃO!");
            alert.showAndWait();
        } else {
            //Validação de data
            String DATE_REGEX = "^\\d{2}/\\d{2}/\\d{4}$";
            Pattern DATE_PATTERN = Pattern.compile(DATE_REGEX);
            if (DATE_PATTERN.matcher(inicio).matches()) {
                if (campoAtual.isSelected() || DATE_PATTERN.matcher(termino).matches()) {
                    Candidato candidato = new Candidato();
                    candidato.setExpEmpresa(empresa);
                    candidato.setCargo(cargo);
                    candidato.setExpInicio(inicio);
                    candidato.setExpTermino(termino);
                    candidato.setDescricao(descricao);
                    if(campoAtual.isSelected()){
                        candidato.setCargoAtual("Sim");
                    } else {
                        candidato.setCargoAtual("Não");
                    }

                    CandidatoDAO candidatoDAO = new CandidatoDAO();
                    candidatoDAO.saveexpcand(candidato);

                    campoEmpresa.setText("");
                    campoCargo.setText("");
                    campoInicio.setText("");
                    campoTermino.setText("");
                    campoDescricao.setText("");
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("FORMATO DE DATA(TÉRMINO) INVÁLIDO!");
                    alert.showAndWait();
                }
            } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("FORMATO DE DATA(INÍCIO) INVÁLIDO!");
            alert.showAndWait();
        }
        }
    }

    public void CheckEmprego (ActionEvent event){

        if (campoAtual.isSelected()) {
            campoTermino.setVisible(false);
            labelTermino.setVisible(false);



        } else {
            campoTermino.setVisible(true);
            labelTermino.setVisible(true);
        }
    }



    @FXML
    void VoltarTela(ActionEvent event)throws Exception {
        HelloApplication.ChangeScene("candidato");
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

}
