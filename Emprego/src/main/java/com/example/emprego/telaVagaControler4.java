package com.example.emprego;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class telaVagaControler4  {

    // Definições dos campos do candidato

    @FXML
    private TextField CpfCandidato;

    @FXML
    private TextField DataCandidato;

    @FXML
    private TextField EmailCandidato;

    @FXML
    private TextField NomeCandidato;

    @FXML
    private TextField TelefoneCandidato;

    @FXML
    private TextField CargoCandidato;

    @FXML
    private TextField CompetenciaCandidato;

    @FXML
    private TextField CursoCandidato;

    @FXML
    private TextField DescricaoCandidato;

    @FXML
    private TextField EmpresaCandidato;

    @FXML
    private TextField ExpInicio;

    @FXML
    private TextField ExpTermino;

    @FXML
    private TextField FormacaoInicio;

    @FXML
    private TextField FormacaoTermino;

    @FXML
    private TextField InglesCandidato;

    @FXML
    private TextField InstituicaoCandidato;



    // Definição dos campos da vaga;

    @FXML
    private TextField BairroVaga2;

    @FXML
    private TextField CargoVaga2;

    @FXML
    private TextField CepVaga2;

    @FXML
    private TextField CidadeVaga2;

    @FXML
    private TextField ComplVaga2;

    @FXML
    private TextField DescricaoVaga2;

    @FXML
    private TextField EnderecoVaga2;

    @FXML
    private TextField ExpVaga2;

    @FXML
    private TextField NumeroVaga2;

    @FXML
    private TextField PeriodoVaga2;

    @FXML
    private TextField RemotoVaga2;

    @FXML
    private TextField SalarioVaga2;

    @FXML
    private TextField UfVaga2;

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
    private AnchorPane pane1;

    @FXML
    private AnchorPane pane2;

    @FXML
    private AnchorPane pane3;


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
}
