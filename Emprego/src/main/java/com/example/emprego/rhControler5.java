package com.example.emprego;

import AcessoDAO.FuncionarioDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Objects;
import java.util.Optional;
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
    private Button botaoSalvar;

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

    long cpf = 0L;

    rhControler4 rh4 = new rhControler4(); //usuario do rh4

    // Definição das ações dos botões

    @FXML
    void AvancarHome(ActionEvent event) throws Exception {


        HelloApplication.ChangeScene("homerh");}

    @FXML
    void AvancarVagas(ActionEvent event) throws Exception{HelloApplication.ChangeScene("vaga");}

    @FXML
    void AvancarCargos(ActionEvent event) throws Exception { HelloApplication.ChangeScene("cargo");}

    @FXML
    void AvancarRH(ActionEvent event) throws Exception {HelloApplication.ChangeScene("rh");}

    @FXML
    void AvancarRelatorios(ActionEvent event) throws Exception {HelloApplication.ChangeScene("");}

    @FXML
    void SalvarAlteracoes(ActionEvent event) throws Exception {

        try{

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("AVISO");
            alert.setHeaderText("VOCÊ REALMENTE DESEJA ALTERAR AS INFORMAÇÕOES");
            ButtonType cancelButton = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getDialogPane().getButtonTypes().add(cancelButton);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {

                //update do candidato


                //campo senha incorreta
                if (!Objects.equals(getCampoConfirmarSenha.getText(), getCampoSenha.getText())){
                    Alert alert0 = new Alert(Alert.AlertType.ERROR);
                    alert0.setHeaderText("SENHA DIGITADA INCORRETA !");
                    alert0.showAndWait();

                }else {


                    //Alteração de senha (+ dados caso tenha)
                    if (Objects.equals(getCampoSenha.getText(), getCampoConfirmarSenha.getText()) && !Objects.equals(getCampoSenha.getText(), "") && !Objects.equals(getCampoConfirmarSenha.getText(), ""))
                    {
                        String senhaMd5 = Md5.getHashMd5(getCampoSenha.getText());
                        //Inserir funcionario no banco

                        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                        Funcionario funcionario = new Funcionario();
                        funcionario.setNome(getCampoNome.getText());
                        funcionario.setEmail(getCampoEmail.getText());
                        funcionario.setSenha(senhaMd5);
                        funcionario.setCpf(cpf);
                        funcionario.setTelefone(Long.parseLong(getCampoTelefone.getText()));
                        funcionarioDAO.updfunc(funcionario);

                        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                        alert2.setHeaderText("ALTERAÇÃO REALIZADA COM SUCESSO !");
                        alert2.showAndWait();

                    }else {

                        // alteração de dados
                        if(Objects.equals(getCampoSenha.getText(), "") && Objects.equals(getCampoConfirmarSenha.getText(), "")){
                            //Inserir funcionario no banco

                            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                            Funcionario funcionario = new Funcionario();
                            funcionario.setNome(getCampoNome.getText());
                            funcionario.setEmail(getCampoEmail.getText());
                            funcionario.setTelefone(Long.parseLong(getCampoTelefone.getText()));
                            funcionario.setCpf(cpf);
                            funcionarioDAO.updfuncse(funcionario);

                            Alert alert3 = new Alert(Alert.AlertType.INFORMATION);
                            alert3.setHeaderText("ALTERAÇÃO REALIZADA COM SUCESSO !");
                            alert3.showAndWait();
                        }

                    }
                }

            }

        }catch (Exception e){
            Alert alert0 = new Alert(Alert.AlertType.ERROR);
            alert0.setHeaderText("NÃO FOI POSSíVEL ATALIZAR AS INFORMAÇÕES !\nTENTE NOVAMENTE");
            alert0.showAndWait();
        }
    }

    @FXML
    void SairTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("login");}

   @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


       FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

       for (Funcionario rh : funcionarioDAO.Func(rhControler4.getSecemail())){
           getCampoNome.setText(rh.getNome());
           getCampoEmail.setText(rh.getEmail());
           getCampoCpf.setText(String.valueOf(rh.getCpf()));
           cpf = rh.getCpf();
           getCampoTelefone.setText(String.valueOf(rh.getTelefone()));

       }
   }
}
