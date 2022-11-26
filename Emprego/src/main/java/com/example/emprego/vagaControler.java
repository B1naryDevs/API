package com.example.emprego;

import AcessoDAO.CargoDAO;
import AcessoDAO.VagaDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.*;
import java.util.regex.Pattern;

import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

import java.net.URL;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.Element;

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
    private TextField campoNumero;

    @FXML
    private TextField campoSalario;

    @FXML
    private CheckBox campoRemoto;

    @FXML
    private CheckBox campoExperiencia;

    @FXML
    private Button botaoFinalizar;

    @FXML
    private Button botaoHome;

    @FXML
    private Button botaoVaga;

    @FXML
    private Button botaoCargo;

    @FXML
    private Button botaoRH;

    @FXML
    private Button botaoRelatorios;

    @FXML
    private Button botaoVoltar;

    @FXML
    private ToggleButton botaoSair;

    @FXML
    private ToggleButton tgbtModo;

    @FXML
    private AnchorPane anchor;

    @FXML
    private ImageView imgModo;

    @FXML
    public ChoiceBox<String> campoCargo;

    @FXML
    private ComboBox<String> campoEstado;

    @FXML
    private ChoiceBox<String> campoPeriodo;

    @FXML
    void AvancarHome(ActionEvent event) throws Exception {HelloApplication.ChangeScene("homerh");}

    @FXML
    void AvancarVaga(ActionEvent event) throws Exception {HelloApplication.ChangeScene("telavaga");}

    @FXML
    void AvancarCargo(ActionEvent event) throws Exception { HelloApplication.ChangeScene("cargo");}

    @FXML
    void AvancarRH(ActionEvent event) throws Exception {HelloApplication.ChangeScene("rh");}

    @FXML
    void AvancarRelatorio(ActionEvent event) throws Exception {HelloApplication.ChangeScene("rh4");}

    @FXML
    void VoltarTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("telavaga");}

    @FXML
    void SairTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("login");}

    private String[] estados = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
    private String[] periodos = {"DIURNO", "NOTURNO", "INTEGRAL"};
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Tema tema = new Tema();
        if(tema.getLuz()==false){
            Image image = new Image("file:src/main/resources/imagens/Lua.png",25,25,true,true);
            anchor.getStylesheets().add("file:src/main/resources/styles/ModoEscuro.css");
            imgModo.setImage(image);
        }else{
            Image image = new Image("file:src/main/resources/imagens/Sol.png",25,25,true,true);
            anchor.getStylesheets().add("file:src/main/resources/styles/ModoClaro.css");
            imgModo.setImage(image);
        }

        // laço para percorrer a lista e adicionar os componentes
        for (String c : CargoDAO.carg()){

            //adicionar cargos
            campoCargo.getItems().add(c);

        }

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
    void finalizarVaga(ActionEvent event) throws Exception {
        String cargo = campoCargo.getValue();
        String periodo = campoPeriodo.getValue();
        String salario = campoSalario.getText();
        String descricao = campoDescricao.getText();

        if (cargo == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O CARGO!");
            alert.showAndWait();
        } else if (periodo == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O PERIODO!");
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
            //Validação salário
            String SALARIO_REGEX = "\\d{3,}";
            Pattern SALARIO_PATTERN = Pattern.compile(SALARIO_REGEX);
            if (SALARIO_PATTERN.matcher(salario).matches()) {
                Float sal = Float.valueOf(salario);

                VagaDAO vagaDAO = new VagaDAO();

                Vaga vaga = new Vaga();
                vaga.setCargo(cargo);
                vaga.setEmpresa_vaga("Pro4TECH");
                vaga.setPeriodo(periodo);
                if(campoExperiencia.isSelected()){
                    vaga.setExperiencia("Sim");
                }else{
                    vaga.setExperiencia("Não");
                }
                vaga.setSalario(sal);
                vaga.setDescricao(descricao);
                vaga.setStatus_vaga("Aberta");

                if (!campoRemoto.isSelected()) {
                    String cep = campoCep.getText();
                    String endereco = campoEndereco.getText();
                    String bairro = campoBairro.getText();
                    String cidade = campoCidade.getText();
                    String estado = campoEstado.getValue();
                    String num_s = campoNumero.getText();
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
                    } else if (estado == null) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("PREENCHA O ESTADO!");
                        alert.showAndWait();
                    }else {
                        String SIZ_REGEX = ".{9}";
                        Pattern SIZ_PATTERN = Pattern.compile(SIZ_REGEX);
                        if (SIZ_PATTERN.matcher(cep.trim()).matches()) {
                            String[] char_cep = cep.split("");
                            List<String> chars = new ArrayList();
                            String remover = "";

                            long cep_long = 0L;

                            chars.addAll(Arrays.asList(char_cep));

                            for (String sss : chars) {

                                if (!"-".equals(sss)) {

                                    remover += sss;

                                }

                            }
                            cep_long = Long.parseLong(remover);
                            String cep_s = String.valueOf(cep_long);
                            String CEP_REGEX = "\\d{8}";
                            Pattern CEP_PATTERN = Pattern.compile(CEP_REGEX);
                            if (CEP_PATTERN.matcher(cep_s).matches()) {
                                String NUMERO_REGEX = "\\d{1,8}";
                                Pattern NUMERO_PATTERN = Pattern.compile(NUMERO_REGEX);
                                if (NUMERO_PATTERN.matcher(num_s).matches()) {
                                    int numero = Integer.parseInt(num_s);
                                    vaga.setRemoto("Não");
                                    vaga.setEndereco(endereco + ", " + numero + ", " + bairro + ", " + complemento + ", " + cep);
                                    vaga.setCidade(cidade + " - " + estado);
                                    vagaDAO.save(vaga);
                                    HelloApplication.ChangeScene("vagafinal");
                                } else {
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                    alert.setHeaderText("FORMATO DE NUMERO INVÁLIDO!");
                                    alert.showAndWait();
                                }
                            } else {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setHeaderText("FORMATO DE CEP INVÁLIDO!");
                                alert.showAndWait();
                            }
                        }else {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText("FORMATO DE CEP INVÁLIDO!");
                            alert.showAndWait();
                        }
                    }
                }else{
                    vaga.setRemoto("Sim");
                    vaga.setEndereco("Remoto");
                    vaga.setCidade("Remoto");
                    vagaDAO.save(vaga);
                    HelloApplication.ChangeScene("vagafinal");
                }
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

    @FXML
    void BuscaCep(ActionEvent event){
        String logradouro = "";
        String tipoLogradouro = "";
        String resultado = null;
        String cep = campoCep.getText();
        try{
            URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
            SAXReader xml = new SAXReader();
            Document documento = xml.read(url);
            Element root = documento.getRootElement();
            for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
                Element element = it.next();
                if(element.getQualifiedName().equals("cidade")){
                    campoCidade.setText(element.getText());
                }
                if(element.getQualifiedName().equals("bairro")) {
                    campoBairro.setText(element.getText());
                }
                if(element.getQualifiedName().equals("uf")) {
                    campoEstado.setValue(element.getText());
                }
                if(element.getQualifiedName().equals("tipo_logradouro")) {
                    tipoLogradouro = element.getText();

                }
                if(element.getQualifiedName().equals("logradouro")) {
                    logradouro = element.getText();
                }
            }
            //setar o campo endereco
            campoEndereco.setText(tipoLogradouro + " " + logradouro);

        } catch(Exception e){
            System.out.println(e);
        }
    }
    public void alterarModo(ActionEvent event) {
        Tema tema = new Tema();
        if (tema.getLuz() == false) {
            Image image = new Image("file:src/main/resources/imagens/Sol.png", 25, 25, true, true);
            anchor.getStylesheets().add("file:src/main/resources/styles/ModoClaro.css");
            anchor.getStylesheets().remove("file:src/main/resources/styles/ModoEscuro.css");
            imgModo.setImage(image);
            tema.setLuz(true);
        } else {
            Image image = new Image("file:src/main/resources/imagens/Lua.png", 25, 25, true, true);
            anchor.getStylesheets().add("file:src/main/resources/styles/ModoEscuro.css");
            anchor.getStylesheets().remove("file:src/main/resources/styles/ModoClaro.css");
            imgModo.setImage(image);
            tema.setLuz(false);
        }
    }
}
