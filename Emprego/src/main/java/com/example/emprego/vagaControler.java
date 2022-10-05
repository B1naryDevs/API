package com.example.emprego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class vagaControler {

    @FXML
    private Label labelCep;

    @FXML
    private Label labelEndereco;

    @FXML
    private Label labelBairro;

    @FXML
    private Label labelCidade;

    @FXML
    private Label labelEstado;

    @FXML
    private Label labelNumero;

    @FXML
    private Label labelComplemento;

    @FXML
    private Button botaoFinalizar;

    @FXML
    private TextField campoBairro;

    @FXML
    private TextField campoCargo;

    @FXML
    private TextField campoCep;

    @FXML
    private TextField campoCidade;

    @FXML
    private TextField campoComplemento;

    @FXML
    private TextField campoDescricao;

    @FXML
    private TextField campoEndereco;

    @FXML
    private TextField campoEstado;

    @FXML
    private TextField campoExperiencia;


    @FXML
    private TextField campoNumero;

    @FXML
    private TextField campoPeriodo;

    @FXML
    private TextField campoSalario;

    @FXML
    private CheckBox campoRemoto;

    @FXML
    private Button botaoHome;

    @FXML
    private Button botaoVaga;

    @FXML
    private Button botaoCargo;

    @FXML
    private Button botaoRH;

    @FXML
    private Button botaoRelatorio;

    @FXML
    private ToggleButton botaoSair;

    @FXML
    void AvancarHome(ActionEvent event) {HelloApplication.ChangeScene("menu");}

    @FXML
    void AvancarVaga(ActionEvent event) {HelloApplication.ChangeScene("vaga");}

    @FXML
    void AvancarCargo(ActionEvent event) { HelloApplication.ChangeScene("cargo");}

    @FXML
    void AvancarRH(ActionEvent event) {HelloApplication.ChangeScene("");}

    @FXML
    void AvancarRelatorio(ActionEvent event) {HelloApplication.ChangeScene("");}

    @FXML
    void SairTela(ActionEvent event) {HelloApplication.ChangeScene("login");}

    @FXML
    private void mascaraCep() {
        Formatter cep = new Formatter();
        cep.setMask("#####-###");
        cep.setCaracteresValidos("0123456789");
        cep.setTf(campoCep);
        cep.formatter();
    }
    @FXML
    void finalizarVaga(ActionEvent event) {
        String cargo = campoCargo.getText();
        String salario = campoSalario.getText();
        String experiencia = campoExperiencia.getText();
        String descricao = campoDescricao.getText();
        String periodo = campoPeriodo.getText();
    }

    public void CheckBox (ActionEvent event){

            if (campoRemoto.isSelected()) {
                campoCep.setVisible(false);
                campoCidade.setVisible(false);
                campoComplemento.setVisible(false);
                campoEndereco.setVisible(false);
                campoEstado.setVisible(false);
                campoNumero.setVisible(false);
                campoBairro.setVisible(false);
                labelBairro.setVisible(false);
                labelCep.setVisible(false);
                labelCidade.setVisible(false);
                labelComplemento.setVisible(false);
                labelEndereco.setVisible(false);
                labelNumero.setVisible(false);
                labelEstado.setVisible(false);
            } else {
                campoCep.setVisible(true);
                campoCidade.setVisible(true);
                campoComplemento.setVisible(true);
                campoEndereco.setVisible(true);
                campoEstado.setVisible(true);
                campoNumero.setVisible(true);
                campoBairro.setVisible(true);
                labelBairro.setVisible(true);
                labelCep.setVisible(true);
                labelCidade.setVisible(true);
                labelComplemento.setVisible(true);
                labelEndereco.setVisible(true);
                labelNumero.setVisible(true);
                labelEstado.setVisible(true);
            }
        }
}
