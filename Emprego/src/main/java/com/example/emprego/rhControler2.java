package com.example.emprego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class rhControler2  {

    // Nomeclatura dos botões e campos
    
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
    private Button botaoCadastrarFuncionarios;

    @FXML
    private Button botaoVisualizarFuncionarios;

    @FXML
    private ToggleButton botaoSair;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoCpf;

    @FXML
    private TextField campoEmail;

    @FXML
    private TextField campoSenha;

    @FXML
    private TextField campoTelefone;

    @FXML
    private TextField campoConfirmarSenha;


    // Definição das ações dos botões

    @FXML
    void AvancarHome(ActionEvent event) {HelloApplication.ChangeScene("menu");}

    @FXML
    void AvancarVagas(ActionEvent event) {HelloApplication.ChangeScene("vaga");}

    @FXML
    void AvancarCargos(ActionEvent event) { HelloApplication.ChangeScene("cargo");}

    @FXML
    void AvancarRH(ActionEvent event) {HelloApplication.ChangeScene("rh");}

    @FXML
    void AvancarRelatorios(ActionEvent event) {HelloApplication.ChangeScene("");}

    @FXML
    void CadastrarFuncionario(ActionEvent event) {HelloApplication.ChangeScene("rh3");}

    @FXML
    void VoltarTela(ActionEvent event) {HelloApplication.ChangeScene("rh");}

    @FXML
    void SairTela(ActionEvent event) {HelloApplication.ChangeScene("login");}

}

