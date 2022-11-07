package com.example.emprego;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class candidatoControler {

    @FXML
    private Button botaoAvancar;

    @FXML
    private ToggleButton botaoSair;

    @FXML
    private ToggleButton tgbtMostrarSenha1;

    @FXML
    private ToggleButton tgbtMostrarSenha2;

    @FXML
    private PasswordField campoConfirmarsenha;

    @FXML
    private PasswordField campoSenha3;

    @FXML
    private TextField campoData;

    @FXML
    private TextField campoConfirmarsenha2;

    @FXML
    private TextField campoSenha4;
    @FXML
    private TextField campoCpf;

    @FXML
    private TextField campoEmail;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoTelefone;

    @FXML
    void SairTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("login");}
    @FXML
    void AvancarTela(ActionEvent event) throws Exception{
        String nome = campoNome.getText();
        String cpf_not = campoCpf.getText();
        String data = campoData.getText();
        String email = campoEmail.getText();
        String senha = campoSenha3.getText();
        String senha2 = campoConfirmarsenha.getText();
        String telefone_not = campoTelefone.getText();

        if (nome.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O NOME!");
            alert.showAndWait();
        } else if (cpf_not.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O CPF!");
            alert.showAndWait();
        } else if (data.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA A DATA!");
            alert.showAndWait();
        } else if (email.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O EMAIL!");
            alert.showAndWait();
        } else if (senha.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA A SENHA!");
            alert.showAndWait();
        } else if (senha2.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA A CONFIRMAÇÃO DE SENHA!");
            alert.showAndWait();
        } else if (telefone_not.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O TELEFONE!");
            alert.showAndWait();
        } else {
            String SIZ_REGEX = ".{14}";
            Pattern SIZ_PATTERN = Pattern.compile(SIZ_REGEX);
            if (SIZ_PATTERN.matcher(cpf_not.trim()).matches()) {
                String[] char_cpf = cpf_not.split("");
                List<String> chars = new ArrayList();
                String remover = "";

                long cpf_long = 0L;

                chars.addAll(Arrays.asList(char_cpf));

                for (String sss : chars) {

                    if (!"-".equals(sss) && !".".equals(sss)) {

                        remover += sss;

                    }

                }
                cpf_long = Long.parseLong(remover);
                String cpf = String.valueOf(cpf_long);
                String SIZ2_REGEX = ".{14}";
                Pattern SIZ2_PATTERN = Pattern.compile(SIZ2_REGEX);
                if (SIZ2_PATTERN.matcher(telefone_not.trim()).matches()) {
                    String[] char_telefone = telefone_not.split("");
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
                    //Validação de cpf
                    String CPF_REGEX = "\\d{11}";
                    Pattern CPF_PATTERN = Pattern.compile(CPF_REGEX);
                    if (CPF_PATTERN.matcher(cpf).matches()) {
                        String cpf1s = String.valueOf(cpf.charAt(0));
                        int cpf1 = Integer.parseInt(cpf1s);
                        int res1 = cpf1 * 10;
                        String cpf2s = String.valueOf(cpf.charAt(1));
                        int cpf2 = Integer.parseInt(cpf2s);
                        int res2 = cpf2 * 9;
                        String cpf3s = String.valueOf(cpf.charAt(2));
                        int cpf3 = Integer.parseInt(cpf3s);
                        int res3 = cpf3 * 8;
                        String cpf4s = String.valueOf(cpf.charAt(3));
                        int cpf4 = Integer.parseInt(cpf4s);
                        int res4 = cpf4 * 7;
                        String cpf5s = String.valueOf(cpf.charAt(4));
                        int cpf5 = Integer.parseInt(cpf5s);
                        int res5 = cpf5 * 6;
                        String cpf6s = String.valueOf(cpf.charAt(5));
                        int cpf6 = Integer.parseInt(cpf6s);
                        int res6 = cpf6 * 5;
                        String cpf7s = String.valueOf(cpf.charAt(6));
                        int cpf7 = Integer.parseInt(cpf7s);
                        int res7 = cpf7 * 4;
                        String cpf8s = String.valueOf(cpf.charAt(7));
                        int cpf8 = Integer.parseInt(cpf8s);
                        int res8 = cpf8 * 3;
                        String cpf9s = String.valueOf(cpf.charAt(8));
                        int cpf9 = Integer.parseInt(cpf9s);
                        int res9 = cpf9 * 2;
                        int res = res1 + res2 + res3 + res4 + res5 + res6 + res7 + res8 + res9;
                        int resf = (res * 10) % 11;
                        String cpf10s = String.valueOf(cpf.charAt(9));
                        int cpf10 = Integer.parseInt(cpf10s);
                        if (resf == 10) {
                            resf = 0;
                        }
                        if (resf == cpf10) {
                            int res11 = cpf1 * 11;
                            int res12 = cpf2 * 10;
                            int res13 = cpf3 * 9;
                            int res14 = cpf4 * 8;
                            int res15 = cpf5 * 7;
                            int res16 = cpf6 * 6;
                            int res17 = cpf7 * 5;
                            int res18 = cpf8 * 4;
                            int res19 = cpf9 * 3;
                            int res110 = cpf10 * 2;
                            int res22 = res11 + res12 + res13 + res14 + res15 + res16 + res17 + res18 + res19 + res110;
                            int resf2 = (res22 * 10) % 11;
                            String cpf11s = String.valueOf(cpf.charAt(10));
                            int cpf11 = Integer.parseInt(cpf11s);
                            if (resf2 == 10) {
                                resf2 = 0;
                            }
                            if (resf2 == cpf11) {
                                if (cpf1 == cpf2 && cpf1 == cpf3 && cpf1 == cpf4 && cpf1 == cpf5 && cpf1 == cpf6 && cpf1 == cpf7 && cpf1 == cpf8 && cpf1 == cpf9 && cpf1 == cpf10 && cpf1 == cpf11) {
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                    alert.setHeaderText("CPF INVÁLIDO");
                                    alert.showAndWait();
                                } else {
                                    //Validação de senha
                                    if (senha.equals(senha2)) {
                                        String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[-._@#$%^&+=])(?=\\S+$).{8,16}$";
                                        Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);
                                        if (PASSWORD_PATTERN.matcher(senha).matches()) {
                                            //Validação de email
                                            String EMAIL_REGEX = ".+@.+\\.[a-z]+";
                                            Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
                                            if (EMAIL_PATTERN.matcher(email).matches()) {
                                                //Validação de telefone
                                                String TELEPHONE_REGEX = "\\d{11}";
                                                Pattern TELEPHONE_PATTERN = Pattern.compile(TELEPHONE_REGEX);
                                                if (TELEPHONE_PATTERN.matcher(telefone).matches()) {
                                                    //Validação de data
                                                    String DATE_REGEX = "^\\d{2}/\\d{2}/\\d{4}$";
                                                    Pattern DATE_PATTERN = Pattern.compile(DATE_REGEX);
                                                    if (DATE_PATTERN.matcher(data).matches()) {
                                                        //Validação de idade
                                                        String ano = data.substring(6,10);
                                                        int a = Integer.parseInt(ano);
                                                        int year = Calendar.getInstance().get(Calendar.YEAR);;
                                                        if((year-a)>16) {
                                                                    Candidato candidato = new Candidato();
                                                                    candidato.setNome(nome);
                                                                    candidato.setCpf(cpf_long);
                                                                    candidato.setDataNac(data);
                                                                    candidato.setEmail(email);
                                                                    candidato.setSenha(senha);
                                                                    candidato.setTelefone(telefone_long);

                                                                    HelloApplication.ChangeScene("candidato2");
                                                        } else if((year-a)==16) {
                                                            String mes = data.substring(3,5);
                                                            int m = Integer.parseInt(mes);
                                                            int month = Calendar.getInstance().get(Calendar.MONTH)+1;;
                                                            if((month-m)>=0) {
                                                                String dia = data.substring(0,2);
                                                                int d = Integer.parseInt(dia);
                                                                int day = Calendar.getInstance().get(Calendar.DATE);;
                                                                if((day-d)>=0) {
                                                                    Candidato candidato = new Candidato();
                                                                    candidato.setNome(nome);
                                                                    candidato.setCpf(cpf_long);
                                                                    candidato.setDataNac(data);
                                                                    candidato.setEmail(email);
                                                                    candidato.setSenha(senha);
                                                                    candidato.setTelefone(telefone_long);

                                                                    HelloApplication.ChangeScene("candidato2");
                                                                } else {
                                                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                                                    alert.setHeaderText("APENAS MAIORES DE 16 ANOS!");
                                                                    alert.showAndWait();
                                                                }
                                                            } else {
                                                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                                                alert.setHeaderText("APENAS MAIORES DE 16 ANOS!");
                                                                alert.showAndWait();
                                                            }
                                                        } else {
                                                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                                                    alert.setHeaderText("APENAS MAIORES DE 16 ANOS!");
                                                                    alert.showAndWait();
                                                                }
                                                    } else {
                                                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                                        alert.setHeaderText("FORMATO DE DATA INVÁLIDO!");
                                                        alert.showAndWait();
                                                    }
                                                } else {
                                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                                    alert.setHeaderText("FORMATO DE TELEFONE INVÁLIDO!");
                                                    alert.showAndWait();
                                                }
                                            } else {
                                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                                alert.setHeaderText("FORMATO DE EMAIL INVÁLIDO!");
                                                alert.showAndWait();
                                            }
                                        } else {
                                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                            alert.setHeaderText("UTILIZE LETRAS MAIUSCULA E MINUSCULA/NUMEROS/CARECTERES ESPECIAIS!");
                                            alert.showAndWait();
                                        }
                                    } else {
                                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                        alert.setHeaderText("SENHAS DISTINSTAS");
                                        alert.showAndWait();
                                    }
                                }
                            } else {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setHeaderText("CPF INVÁLIDO");
                                alert.showAndWait();
                            }
                        } else {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText("CPF INVÁLIDO");
                            alert.showAndWait();
                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("FORMATO DE CPF INVÁLIDO");
                        alert.showAndWait();
                    }
                }else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("FORMATO DE TELEFONE INVÁLIDO");
                    alert.showAndWait();
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("FORMATO DE CPF INVÁLIDO");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void mascaraTel() {
        Formatter tff = new Formatter();
        tff.setMask("(##)#####-####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(campoTelefone);
        tff.formatter();
    }

    @FXML
    private void mascaraCpf() {
        Formatter cpf = new Formatter();
        cpf.setMask("###.###.###-##");
        cpf.setCaracteresValidos("0123456789");
        cpf.setTf(campoCpf);
        cpf.formatter();
    }

    @FXML
    private void mascaraNascimento() {
        Formatter nascimento = new Formatter();
        nascimento.setMask("##/##/####");
        nascimento.setCaracteresValidos("0123456789");
        nascimento.setTf(campoData);
        nascimento.formatter();
    }

    //imagem ação
    @FXML
    Image img_MostrarSenha = new Image("file:src/main/resources/imagens/iconMostrar.png",25,25,true,true);
    Image img_OcultarSenha = new Image("file:src/main/resources/imagens/iconApagar.png",25,25,true,true);

    @FXML
    Image img_MostrarSenha2 = new Image("file:src/main/resources/imagens/iconMostrar.png",25,25,true,true);
    Image img_OcultarSenha2 = new Image("file:src/main/resources/imagens/iconApagar.png",25,25,true,true);

    //ocultar/mostrar senha
    @FXML
    void mostrarSenha1(ActionEvent event) throws Exception{
        if(tgbtMostrarSenha1.isSelected()){
            tgbtMostrarSenha1.setGraphic(new ImageView(img_MostrarSenha));
            campoSenha4.setText(campoSenha3.getText());
            campoSenha4.setVisible(true);
            campoSenha3.setVisible(false);
        }else{
            tgbtMostrarSenha1.setGraphic(new ImageView(img_OcultarSenha));
            campoSenha3.setText(campoSenha4.getText());
            campoSenha3.setVisible(true);
            campoSenha4.setVisible(false);
        }
    }
    @FXML
    void mostrarSenha2(ActionEvent event) throws Exception {
        if (tgbtMostrarSenha2.isSelected()) {
            tgbtMostrarSenha2.setGraphic(new ImageView(img_MostrarSenha2));
            campoConfirmarsenha2.setText(campoConfirmarsenha.getText());
            campoConfirmarsenha2.setVisible(true);
            campoConfirmarsenha.setVisible(false);
        } else {
            tgbtMostrarSenha2.setGraphic(new ImageView(img_OcultarSenha2));
            campoConfirmarsenha.setText(campoConfirmarsenha2.getText());
            campoConfirmarsenha.setVisible(true);
            campoConfirmarsenha2.setVisible(false);
        }
    }

}


