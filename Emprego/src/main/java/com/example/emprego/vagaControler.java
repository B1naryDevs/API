package com.example.emprego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

public class vagaControler {

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
    private CheckBox campoNao;

    @FXML
    private TextField campoNumero;

    @FXML
    private TextField campoPeriodo;

    @FXML
    private TextField campoSalario;

    @FXML
    private CheckBox campoSim;

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

        if(campoSim.isSelected()) {
            String cep = campoCep.getText();
            String cidade = campoCidade.getText();
            String complemento = campoComplemento.getText();
            String endereco = campoEndereco.getText();
            String estado = campoEstado.getText();
            String numero = campoNumero.getText();
            String bairro = campoBairro.getText();
        }

        if(campoNao.isSelected()){
            campoCep.setVisible(false);
            campoCidade.setVisible(false);
            campoComplemento.setVisible(false);
            campoEndereco.setVisible(false);
            campoEstado.setVisible(false);
            campoNumero.setVisible(false);
            campoBairro.setVisible(false);
        }
    }

}
