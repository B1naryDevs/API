package com.example.emprego;

import AcessoDAO.FuncionarioDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

import java.net.URL;
import java.util.ResourceBundle;

public class rhControler5 implements Initializable {

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
    private Button botaoAprovados;

    @FXML
    private Button botaoReprovados;

    @FXML
    private ToggleButton botaoSair;

    @FXML
    private TextField getCampoNome;

    @FXML
    private TextField getCampoEmail;

    @FXML
    private TextField getCampoTelefone;

    @FXML
    private TextField getCampoCpf;

    @FXML
    private TextField getCampoSenha;

    @FXML
    private TextField getCampoConfirmarSenha;

    @FXML
    private TextField campoteste;


    // Definição das ações dos botões

    @FXML
    void AvancarHome(ActionEvent event) throws Exception {HelloApplication.ChangeScene("home");}

    @FXML
    void AvancarVagas(ActionEvent event) throws Exception{HelloApplication.ChangeScene("vaga");}

    @FXML
    void AvancarCargos(ActionEvent event) throws Exception { HelloApplication.ChangeScene("cargo");}

    @FXML
    void AvancarRH(ActionEvent event) throws Exception {HelloApplication.ChangeScene("rh");}

    @FXML
    void AvancarRelatorios(ActionEvent event) throws Exception {HelloApplication.ChangeScene("");}

    @FXML
    void SairTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("login");}

   @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rhControler4 rh4 = new rhControler4();
       FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

       for (Funcionario rh : funcionarioDAO.Func(rh4.getSecemail())){
           getCampoNome.setText(rh.getNome());
           getCampoEmail.setText(rh.getEmail());
           getCampoCpf.setText(String.valueOf(rh.getCpf()));
           getCampoTelefone.setText(String.valueOf(rh.getTelefone()));

           // string senha está com a senha do funcionario em codigo hash(lembre - se
           //de cadastrar um novo funcionario ! Pois os pré cadastrados do banco não possuem Hash !!)
           String senha = rh.getSenha();

           //senha sem hash
           String hash = "coloca aqui a senha sem hash";

       }
   }


}
