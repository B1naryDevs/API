package com.example.emprego;

import AcessoDAO.CandidatoDAO;
import AcessoDAO.FuncionarioDAO;
import AcessoDAO.UsuarioDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;

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
    private Button botaoRelatorio;

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
    private TextField getCampoSenha;

    @FXML
    private TextField getCampoConfirmarSenha;

    @FXML
    private ToggleButton tgbtModo;

    @FXML
    private AnchorPane anchor;

    @FXML
    private ImageView imgModo;

    long cpf = 0L;

    rhControler4 rh4 = new rhControler4(); //usuario do rh4

    // Definição das ações dos botões

    @FXML
    void AvancarHome(ActionEvent event) throws Exception {HelloApplication.ChangeScene("homerh");}

    @FXML
    void AvancarVagas(ActionEvent event) throws Exception{HelloApplication.ChangeScene("telavaga");}

    @FXML
    void AvancarCargos(ActionEvent event) throws Exception { HelloApplication.ChangeScene("cargo");}

    @FXML
    void AvancarRH(ActionEvent event) throws Exception {HelloApplication.ChangeScene("rh");}

    @FXML
    void AvancarRelatorios(ActionEvent event) throws Exception {HelloApplication.ChangeScene("rh4");}

    @FXML
    void TelaRelatorio(ActionEvent event) throws Exception {HelloApplication.ChangeScene("relatorio");}


    @FXML
    void SalvarAlteracoes(ActionEvent event) throws Exception {

        try{

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("AVISO");
            alert.setHeaderText("VOCÊ REALMENTE DESEJA ALTERAR AS INFORMAÇÕES");
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
                        if (getCampoNome.getText().isEmpty()) {
                            alert.setHeaderText("PREENCHA O NOME!");
                            alert.showAndWait();
                        } else if (getCampoEmail.getText().isEmpty()) {
                            alert.setHeaderText("PREENCHA O EMAIL!");
                            alert.showAndWait();
                        } else if (getCampoTelefone.getText().isEmpty()) {
                            alert.setHeaderText("PREENCHA O TELEFONE!");
                            alert.showAndWait();
                        } else {
                            String SIZ_REGEX = ".{14}";
                            Pattern SIZ_PATTERN = Pattern.compile(SIZ_REGEX);
                            if (SIZ_PATTERN.matcher(getCampoTelefone.getText().trim()).matches()) {
                                String[] char_telefone = getCampoTelefone.getText().split("");
                                List<String> chars2 = new ArrayList();
                                String remover2 = "";

                                long telefone_long = 0L;

                                chars2.addAll(Arrays.asList(char_telefone));

                                for (String sss : chars2){

                                    if (!"-".equals(sss) && !"(".equals(sss) && !")".equals(sss)){

                                        remover2 += sss;

                                    }

                                }
                                telefone_long = Long.parseLong(remover2);
                                String telefone = String.valueOf(telefone_long);
                                //Validação de email
                                String EMAIL_REGEX = ".+@.+\\.[a-z]+";
                                Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
                                if (EMAIL_PATTERN.matcher(getCampoEmail.getText()).matches()) {
                                    //Validação de telefone
                                    String TELEPHONE_REGEX = "\\d{11}";
                                    Pattern TELEPHONE_PATTERN = Pattern.compile(TELEPHONE_REGEX);
                                    if (TELEPHONE_PATTERN.matcher(telefone).matches()) {
                                        String senhaMd5 = Md5.getHashMd5(getCampoSenha.getText());
                                        //Inserir funcionario no banco

                                        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                                        Funcionario funcionario = new Funcionario();
                                        funcionario.setNome(getCampoNome.getText());
                                        funcionario.setEmail(getCampoEmail.getText());
                                        funcionario.setSenha(senhaMd5);
                                        funcionario.setCpf(cpf);
                                        funcionario.setTelefone(Long.parseLong(telefone));
                                        funcionarioDAO.updfunc(funcionario);

                                        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                                        alert2.setHeaderText("ALTERAÇÃO REALIZADA COM SUCESSO !");
                                        alert2.showAndWait();
                                    } else {
                                        alert.setHeaderText("FORMATO DE TELEFONE INVÁLIDO!");
                                        alert.showAndWait();
                                    }
                                } else {
                                    alert.setHeaderText("FORMATO DE EMAIL INVÁLIDO!");
                                    alert.showAndWait();
                                }
                            }else {
                                alert.setHeaderText("FORMATO DE TELEFONE INVÁLIDO");
                                alert.showAndWait();
                            }
                        }
                    }else {

                        // alteração de dados
                        if(Objects.equals(getCampoSenha.getText(), "") && Objects.equals(getCampoConfirmarSenha.getText(), "")){
                            if (getCampoNome.getText().isEmpty()) {
                                alert.setHeaderText("PREENCHA O NOME!");
                                alert.showAndWait();
                            } else if (getCampoEmail.getText().isEmpty()) {
                                alert.setHeaderText("PREENCHA O EMAIL!");
                                alert.showAndWait();
                            } else if (getCampoTelefone.getText().isEmpty()) {
                                alert.setHeaderText("PREENCHA O TELEFONE!");
                                alert.showAndWait();
                            } else {
                                String SIZ_REGEX = ".{14}";
                                Pattern SIZ_PATTERN = Pattern.compile(SIZ_REGEX);
                                if (SIZ_PATTERN.matcher(getCampoTelefone.getText().trim()).matches()) {
                                    String[] char_telefone = getCampoTelefone.getText().split("");
                                    List<String> chars2 = new ArrayList();
                                    String remover2 = "";

                                    long telefone_long = 0L;

                                    chars2.addAll(Arrays.asList(char_telefone));

                                    for (String sss : chars2){

                                        if (!"-".equals(sss) && !"(".equals(sss) && !")".equals(sss)){

                                            remover2 += sss;

                                        }

                                    }
                                    telefone_long = Long.parseLong(remover2);
                                    String telefone = String.valueOf(telefone_long);
                                    //Validação de email
                                    String EMAIL_REGEX = ".+@.+\\.[a-z]+";
                                    Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
                                    if (EMAIL_PATTERN.matcher(getCampoEmail.getText()).matches()) {
                                        //Validação de telefone
                                        String TELEPHONE_REGEX = "\\d{11}";
                                        Pattern TELEPHONE_PATTERN = Pattern.compile(TELEPHONE_REGEX);
                                        if (TELEPHONE_PATTERN.matcher(telefone).matches()) {
                                            //Inserir funcionario no banco

                                            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                                            Funcionario funcionario = new Funcionario();
                                            funcionario.setNome(getCampoNome.getText());
                                            funcionario.setEmail(getCampoEmail.getText());
                                            funcionario.setTelefone(Long.parseLong(telefone));
                                            funcionario.setCpf(cpf);
                                            funcionarioDAO.updfuncse(funcionario);

                                            Alert alert3 = new Alert(Alert.AlertType.INFORMATION);
                                            alert3.setHeaderText("ALTERAÇÃO REALIZADA COM SUCESSO !");
                                            alert3.showAndWait();
                                        } else {
                                            alert.setHeaderText("FORMATO DE TELEFONE INVÁLIDO!");
                                            alert.showAndWait();
                                        }
                                    } else {
                                        alert.setHeaderText("FORMATO DE EMAIL INVÁLIDO!");
                                        alert.showAndWait();
                                    }
                                }else {
                                    alert.setHeaderText("FORMATO DE TELEFONE INVÁLIDO");
                                    alert.showAndWait();
                                }
                            }
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

        Tema tema = new Tema();
        if (tema.getLuz() == false) {
            Image image = new Image("file:src/main/resources/imagens/Lua.png", 25, 25, true, true);
            anchor.getStylesheets().add("file:src/main/resources/styles/ModoEscuro.css");
            imgModo.setImage(image);
        } else {
            Image image = new Image("file:src/main/resources/imagens/Sol.png", 25, 25, true, true);
            anchor.getStylesheets().add("file:src/main/resources/styles/ModoClaro.css");
            imgModo.setImage(image);
        }


        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        for (Funcionario rh : funcionarioDAO.Func(rhControler4.getSecemail())){
            cpf = rh.getCpf();
            getCampoNome.setText(rh.getNome());
            getCampoEmail.setText(rh.getEmail());
            Formatter tff = new Formatter();
            tff.setMask("(##)#####-####");
            tff.setTf(getCampoTelefone);
            getCampoTelefone.setText(String.valueOf(rh.getTelefone()));
            tff.formatter();

        }
    }

    @FXML
    private void mascaraTel() {
        Formatter tff = new Formatter();
        tff.setMask("(##)#####-####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(getCampoTelefone);
        tff.formatter();
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
