package com.example.emprego;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;
import javafx.scene.control.TextField;
import java.text.ParseException;
import javafx.scene.control.TextField;
import javax.swing.text.MaskFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class candidatoControler {

    @FXML
    private Button botaoAvancar;

    @FXML
    private PasswordField campoConfirmarsenha;

    @FXML
    private TextField campoCpf;

    @FXML
    private DatePicker campoData;

    @FXML
    private TextField campoEmail;

    @FXML
    private TextField campoNome;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private TextField campoTelefone;

    @FXML
    void AvancarTela(ActionEvent event) throws FileNotFoundException {
        String nome = campoNome.getText();
        String cpf = campoCpf.getText();
        LocalDate datainicial = campoData.getValue();
        String data = String.valueOf(datainicial);
        String email = campoEmail.getText();
        String senha = campoSenha.getText();
        String senha2 = campoConfirmarsenha.getText();
        String telefone = campoTelefone.getText();

        if (nome.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O NOME!");
            alert.showAndWait();
        } else if (cpf.isEmpty()) {
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
        } else if (telefone.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O TELEFONE!");
            alert.showAndWait();
        } else {
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
                                            String TELEPHONE_REGEX = "\\d{8,12}";
                                            Pattern TELEPHONE_PATTERN = Pattern.compile(TELEPHONE_REGEX);
                                            if (TELEPHONE_PATTERN.matcher(telefone).matches()) {
                                                //Validação de data
                                                String DATE_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";
                                                Pattern DATE_PATTERN = Pattern.compile(DATE_REGEX);
                                                if (DATE_PATTERN.matcher(data).matches()) {
                                                    // Objeto para receber os arquivos
                                                    File arquivoCSV = new File("dados_candidato.csv");

                                                    // - lista que irá receber todos valores do csv
                                                    List<String> dados = new ArrayList();

                                                    // variavel para receber as linhas por linhas
                                                    String linha = new String();
                                                    Scanner read = new Scanner(arquivoCSV);

                                                    // Correr todas as linhas do arquivo
                                                    while (read.hasNext()) {

                                                        linha = read.nextLine();
                                                        dados.add(linha);
                                                    }

                                                    // incremento do novo índice na lista que contém os itens do csv
                                                    dados.add(nome + "," + cpf + "," + data + "," + email + "," + senha + "," + telefone);

                                                    // criação de novo objeto para escrever os novos valores
                                                    PrintWriter pw = new PrintWriter(new File("dados_candidato.csv"));

                                                    // Criação da lista para aplicar os valores no csv
                                                    StringBuilder sb = new StringBuilder();

                                                    // laço para inserir linha(indice) por linha
                                                    for (String lin : dados) {
                                                        sb.append(lin);
                                                        sb.append("\r\n");
                                                    }

                                                    // objeto adicionar os valores no arquivo
                                                    pw.write(sb.toString());

                                                    // frcha conexão com arquivo
                                                    pw.close();

                                                    HelloApplication.ChangeScene("tela2");
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
        }
    }
}