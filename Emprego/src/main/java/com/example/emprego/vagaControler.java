package com.example.emprego;

import AcessoDAO.VagaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;

public class vagaControler implements Initializable {

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
    private Label labelCargo;

    @FXML
    private Label labelPeriodo;

    @FXML
    private Button botaoFinalizar;

    @FXML
    private TextField campoBairro;

    @FXML
    private TextField campoCep;

    @FXML
    private TextField campoCidade;

    @FXML
    private TextField campoComplemento;

    @FXML
    private TextArea campoDescricao;

    @FXML
    private TextField campoEndereco;

    @FXML
    private ChoiceBox<String> campoEstado;

    @FXML
    private TextField campoExperiencia;


    @FXML
    private TextField campoNumero;

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
    private ChoiceBox<String> campoCargo;

    @FXML
    private ChoiceBox<String> campoPeriodo;

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


    private String[] cargos = {"DESENVOLVEDOR FRONT-END", "DESENVOLVEDOR BACK-END", "ADMINISTRADOR DE BANCO DE DADOS" };
    private String[] estados = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
    private String[] periodos = {"DIURNO", "NOTURNO", "INTEGRAL"};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        campoCargo.getItems().addAll(cargos);
        campoEstado.getItems().addAll(estados);
        campoPeriodo.getItems().addAll(periodos);

    }

    public void getCargo(ActionEvent event){
        String CargoSelecionado = campoCargo.getValue();
        labelCargo.setText(CargoSelecionado);

    }

    public void getEstado(ActionEvent event){
        String EstadoSelecionado = campoEstado.getValue();
        labelEstado.setText(EstadoSelecionado);

    }

    public void getPeriodo(ActionEvent event){
        String PeriodoSelecionado = campoPeriodo.getValue();
        labelPeriodo.setText(PeriodoSelecionado);

    }

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
        String cargo = campoCargo.getValue();
        String periodo = campoPeriodo.getValue();
        String experiencia = campoExperiencia.getText();
        String salario = campoSalario.getText();
        String descricao = campoDescricao.getText();

        if (cargo.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O CARGO!");
            alert.showAndWait();
        } else if (periodo.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O PERIODO!");
            alert.showAndWait();
        } else if (experiencia.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA A EXPERIÊNCIA!");
            alert.showAndWait();
        } else if (salario.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O SALÁRIO!");
            alert.showAndWait();
        } else if (descricao.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA A DESCRIÇÃO!");
            alert.showAndWait();
        }else{
            if (campoRemoto.isSelected()) {
                String cep = campoCep.getText();
                String[] char_cep = cep.split("");
                List<String> chars = new ArrayList();
                String remover = "";

                long cep_long = 0L;

                chars.addAll(Arrays.asList(char_cep));

                for (String sss : chars){

                    if (!"-".equals(sss)){

                        remover += sss;

                    }

                }
                cep_long = Long.parseLong(remover);
                String cep_s = String.valueOf(cep_long);
                String endereco = campoEndereco.getText();
                String bairro = campoBairro.getText();
                String cidade = campoCidade.getText();
                String estado = campoEstado.getValue();
                String num_s = campoNumero.getText();
                int numero = Integer.parseInt(num_s);
                String complemento = campoComplemento.getText();
                if (cep.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("PREENCHA O CEP!");
                    alert.showAndWait();
                } else if (endereco.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("PREENCHA O ENDEREÇO!");
                    alert.showAndWait();
                } else if (bairro.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("PREENCHA O BAIRRO!");
                    alert.showAndWait();
                } else if (cidade.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("PREENCHA A CIDADE!");
                    alert.showAndWait();
                } else if (estado.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("PREENCHA O ESTADO!");
                    alert.showAndWait();
                }else{
                    String CEP_REGEX = "\\d{7}";
                    Pattern CEP_PATTERN = Pattern.compile(CEP_REGEX);
                    if (CEP_PATTERN.matcher(cep_s).matches()) {
                        String NUMERO_REGEX = "\\d";
                        Pattern NUMERO_PATTERN = Pattern.compile(NUMERO_REGEX);
                        if (NUMERO_PATTERN.matcher(num_s).matches()) {
                            Vaga vaga = new Vaga();
                            vaga.setCep(cep_long);
                            vaga.setEndereco(endereco);
                            vaga.setBairro(bairro);
                            vaga.setCidade(cidade);
                            vaga.setEstado(estado);
                            vaga.setNumero(numero);
                            vaga.setComplemento(complemento);
                        }else{
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText("FORMATO DE NUMERO INVÁLIDO!");
                            alert.showAndWait();
                        }
                    }else{
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("FORMATO DE CEP INVÁLIDO!");
                        alert.showAndWait();
                    }
                }
            }
            //Validação salário
            String SALARIO_REGEX = "\\d{3,}";
            Pattern SALARIO_PATTERN = Pattern.compile(SALARIO_REGEX);
            if (SALARIO_PATTERN.matcher(salario).matches()) {
                //Vaga vaga = new Vaga();
                //vaga.setCargo(cargo);
                //vaga.setPeriodo(periodo);
                //vaga.setExpProfissional(experiencia);
                //vaga.setSalario(Float.valueOf(salario));
                //vaga.setDescricao(descricao);
                ////////////////////////////////////////////////
                ///////////////CONEXÃO COM BANCO////////////////
                ////////////////////////////////////////////////

                Float sal = Float.valueOf(salario);


                VagaDAO vagaDAO = new VagaDAO();

                Vaga vaga = new Vaga();
                vaga.setCargo(cargo);
                vaga.setEmpresa_vaga("Pro4TECH");
                vaga.setSetor_vaga("Tecnologia e informação");
                vaga.setPeriodo(periodo);
                vaga.setExpProfissional(experiencia);
                vaga.setSalario(sal);
                vaga.setDescricao(descricao);
                vaga.setEndereco(campoEndereco.getText() + ", " + campoBairro.getText() + ", " + campoComplemento.getText() + ", " + campoCep.getText());
                vaga.setCidade(campoCidade.getText());
                vaga.setRemote("Sim");
                vaga.setStatus_vaga("Encerrada");

                vagaDAO.save(vaga);

            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("FORMATO DE SALÁRIO INVÁLIDO!");
                alert.showAndWait();
            }
        }
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
