package com.example.emprego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class candidatoControler2 {

    @FXML
    private Button botaoAvancar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private TextField campoCargo;

    @FXML
    private TextField campoCargos;

    @FXML
    private TextField campoPretensao;

    @FXML
    private TextField campoDescricao;

    @FXML
    private TextField campoEmpresa;

    @FXML
    private DatePicker campoInicio;

    @FXML
    private DatePicker campoTermino;

    @FXML
    void AvancarTela(ActionEvent event) throws FileNotFoundException {
        String empresa = campoEmpresa.getText();
        String cargo = campoCargo.getText();
        LocalDate inicioinicial = campoInicio.getValue();
        LocalDate terminoinicial = campoTermino.getValue();
        String inicio = String.valueOf(inicioinicial);
        String termino = String.valueOf(terminoinicial);
        String descricao = campoDescricao.getText();
        String cargos = campoCargos.getText();
        String pretensao = campoPretensao.getText();

        Candidato candidato = new Candidato();
        candidato.setExpEmpresa(empresa);
        candidato.setCargo(cargo);
        candidato.setExpInicio(inicio);
        candidato.setExpTermino(termino);
        candidato.setDescricao(descricao);
        candidato.setCargoInteresse(cargos);
        candidato.setPretSalarial(pretensao);

        HelloApplication.ChangeScene("candidato3");
    }

    @FXML
    void VoltarTela(ActionEvent event) {
        HelloApplication.ChangeScene("candidato");
    }

}
