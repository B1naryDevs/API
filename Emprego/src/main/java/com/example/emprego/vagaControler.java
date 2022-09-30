package com.example.emprego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

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
    private void mascaraCep() {
        Formatter nascimento = new Formatter();
        nascimento.setMask("#####-###");
        nascimento.setCaracteresValidos("0123456789");
        nascimento.setTf(campoCep);
        nascimento.formatter();
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
            String complemento = campoComplemento.gettext();
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
