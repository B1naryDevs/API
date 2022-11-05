package com.example.emprego;

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
    private Button botaoVoltar;
    
    @FXML
    private Button botaoHome;

    @FXML
    private Button botaoLogin;

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
    private CheckBox campoExperiencia;

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
    private ChoiceBox<String> campoCargoInteresse;

    private String[] setores = {"DESENVOLVEDOR FRONT-END", "DESENVOLVEDOR BACK-END", "ADMINISTRADOR DE BANCO DE DADOS" };

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        campoCargoInteresse.getItems().addAll(setores);

    }

    public void getInteresse(ActionEvent event){
        String cargoSelecionado = campoCargoInteresse.getValue();
        labelCargoInteresse.setText(cargoSelecionado);

    }
    
    @FXML
    void SairTela(ActionEvent event) throws Exception{HelloApplication.ChangeScene("login");}

    @FXML
    void AvancarHome(ActionEvent event) throws Exception{HelloApplication.ChangeScene("candidato");}

    @FXML
    void AvancarLogin(ActionEvent event) throws Exception{HelloApplication.ChangeScene("login");}

    @FXML
    void AvancarTela(ActionEvent event) throws Exception {
        String empresa = campoEmpresa.getText();
        String cargo = campoCargo.getText();
        String cargos = campoCargoInteresse.getValue();
        String inicio = campoInicio.getText();
        String termino = campoTermino.getText();
        String descricao = campoDescricao.getText();
        String pretensao = campoPretensao.getText();

        if (cargos.isEmpty()) {
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
                candidato.setExpEmpresa(empresa);
                candidato.setCargo(cargo);
                candidato.setExpInicio(inicio);
                candidato.setExpTermino(termino);
                candidato.setDescricao(descricao);
                candidato.setCargoInteresse(cargos);
                candidato.setPretSalarial(pretensao);

                HelloApplication.ChangeScene("candidato3");

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("FORMATO DE PRETENSÃO SALARIAL INVÁLIDO!");
                alert.showAndWait();
            }
        }
    }




    public void CheckEmprego (ActionEvent event){

        if (campoExperiencia.isSelected()) {
            campoEmpresa.setVisible(false);
            campoCargo.setVisible(false);
            campoInicio.setVisible(false);
            campoTermino.setVisible(false);
            campoDescricao.setVisible(false);
            labelEmpresa.setVisible(false);
            labelCargo.setVisible(false);
            labelInicio.setVisible(false);
            labelTermino.setVisible(false);
            labelDescricao.setVisible(false);
            botaoAdicionar.setVisible(false);



        } else {
            campoEmpresa.setVisible(true);
            campoCargo.setVisible(true);
            campoInicio.setVisible(true);
            campoTermino.setVisible(true);
            campoDescricao.setVisible(true);
            labelEmpresa.setVisible(true);
            labelCargo.setVisible(true);
            labelInicio.setVisible(true);
            labelTermino.setVisible(true);
            labelDescricao.setVisible(true);
            botaoAdicionar.setVisible(true);
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
