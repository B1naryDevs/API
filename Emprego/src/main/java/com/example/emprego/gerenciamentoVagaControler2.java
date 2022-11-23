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

import javafx.scene.control.cell.PropertyValueFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.Element;

import static com.example.emprego.gerenciamentoVagaControler.id_vaga;

public class gerenciamentoVagaControler2 implements Initializable {

    String remo, end, cidest;



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
    private Label labelStatus;

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
    private Button botaoVoltar;

    @FXML
    private Button botaoSalvar;

    @FXML
    private ToggleButton botaoSair;

    @FXML
    public ChoiceBox<String> campoCargo;

    @FXML
    private ComboBox<String> campoEstado;

    @FXML
    private ChoiceBox<String> campoPeriodo;

    @FXML
    private ChoiceBox<String> campoStatus;

    @FXML
    void AvancarHome(ActionEvent event) throws Exception {HelloApplication.ChangeScene("homerh");}

    @FXML
    void AvancarVaga(ActionEvent event) throws Exception {HelloApplication.ChangeScene("telavaga");}

    @FXML
    void AvancarCargo(ActionEvent event) throws Exception { HelloApplication.ChangeScene("cargo");}

    @FXML
    void AvancarRH(ActionEvent event) throws Exception {HelloApplication.ChangeScene("rh");}

    @FXML
    void AvancarRelatorio(ActionEvent event) throws Exception {HelloApplication.ChangeScene("");}

    @FXML
    void VoltarTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("gerenciamentovaga");}

    @FXML
    void SalvarVaga(ActionEvent event) throws Exception {

        int id = id_vaga;

        VagaDAO vagaDAO = new VagaDAO();
        Vaga vaga = new Vaga();

        exp();
        rem();

        vaga.setCargo(campoCargo.getValue());
        vaga.setCidade(cidest);
        vaga.setDescricao(campoDescricao.getText());
        vaga.setExperiencia(exp);
        vaga.setRemoto(remo);
        vaga.setEndereco(end);
        vaga.setStatus_vaga(campoStatus.getValue());
        vaga.setPeriodo(campoPeriodo.getValue());
        vaga.setSalario(Float.parseFloat(campoSalario.getText()));

        vagaDAO.updvaga(vaga, id);

        HelloApplication.ChangeScene("");}

    String exp = "";

    @FXML
    void SairTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("login");}

    private String[] estados = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
            "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};

    private String[] periodos = {"DIURNO", "NOTURNO", "INTEGRAL"};

    private String[] status = {"Aberta", "Encerrada", "Em Andamento"};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        List<String> tratamento = new ArrayList();

        List<String> cidesta = new ArrayList();

        VagaDAO vg = new VagaDAO();

        campoEstado.getItems().addAll(estados);
        campoPeriodo.getItems().addAll(periodos);
        campoStatus.getItems().addAll(status);

        cargo();

        int id = id_vaga;

        for (VagaStatic c : vg.Search(id)){

            campoCargo.setValue(c.getCargo());
            campoSalario.setText(String.valueOf(c.getSalario()));
            campoPeriodo.setValue(c.getPeriodo());
            campoDescricao.setText(c.getDescricao());
            campoStatus.setValue(c.getStatus_vaga());



            tratamento.addAll(List.of(c.getEndereco().split(",")));
            cidesta.addAll(List.of(c.getCidade().split(" - ")));

            campoBairro.setText(tratamento.get(2));
            campoEndereco.setText(tratamento.get(0));
            campoNumero.setText(tratamento.get(1));
            campoCep.setText(tratamento.get(4));
            campoComplemento.setText(tratamento.get(3));


            campoCidade.setText(cidesta.get(0));
            campoEstado.setValue(cidesta.get(1));

            //System.out.println(cidesta);

            if (c.getRemoto().equals("Sim")){
                campoRemoto.setSelected(true);
            }
            if (c.getExperiencia().equals("Sim")){
                campoExperiencia.setSelected(true);
            }
        }

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

    public void getStatus(ActionEvent event){
        String StatusSelecionado = campoStatus.getValue();
        labelStatus.setText(StatusSelecionado);

    }

    @FXML
    private void mascaraCep() {
        Formatter cep = new Formatter();
        cep.setMask("#####-###");
        cep.setCaracteresValidos("0123456789");
        cep.setTf(campoCep);
        cep.formatter();
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

    void cargo(){

        // laço para percorrer a lista e adicionar os componentes

        for (String c : CargoDAO.carg()){

            //adicionar cargos
            campoCargo.getItems().add(c);
        }

    }

    void exp(){

        if (campoExperiencia.isSelected()){

            exp = "Sim";

        }else{

            exp = "Não";
        }

    }

    void rem(){
        if (campoRemoto.isSelected()){

            remo = "Sim";
            end = "Remoto";
            cidest = "Remoto";

        }else{

            remo = "Não";

        }
    }

}

