package com.example.emprego;

import AcessoDAO.CandidatoDAO;
import AcessoDAO.CargoDAO;
import AcessoDAO.UsuarioDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;

public class areaCandidatoControler implements Initializable {

    // Nomeclatura dos botões

    @FXML
    private Button botaoHome;

    @FXML
    private Button botaoVagas;

    @FXML
    private Button botaoSobre;

    @FXML
    private Button botaoSalvar;

    @FXML
    private Button botaoAcompanhar;

    @FXML
    private ToggleButton botaoSair;

    // Definição dos campos

    @FXML
    private TextField campoCpf;

    @FXML
    private TextField campoEmail;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoTelefone;

    @FXML
    private TextField campoData;
    private static long cpf_antigo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CandidatoDAO candidatoDAO = new CandidatoDAO();
        candidatoDAO.Cand();

        Candidato candidato = new Candidato();
        Usuario usuario = new Usuario();

        cpf_antigo = usuario.getCpf();
        campoNome.setText(candidato.getNome());
        campoEmail.setText(usuario.getEmail());
        campoData.setText(candidato.getDataNac());
        campoTelefone.setText(String.valueOf(candidato.getTelefone()));
    }

    @FXML
    void AtualizarDados(ActionEvent event) throws Exception{
        String nome = campoNome.getText();
        String data = campoData.getText();
        String email = campoEmail.getText();
        String telefone_not = campoTelefone.getText();

        if (nome.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O NOME!");
            alert.showAndWait();
        } else if (data.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA A DATA!");
            alert.showAndWait();
        } else if (email.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O EMAIL!");
            alert.showAndWait();
        } else if (telefone_not.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O TELEFONE!");
            alert.showAndWait();
        } else {
            String SIZ_REGEX = ".{14}";
            Pattern SIZ_PATTERN = Pattern.compile(SIZ_REGEX);
            if (SIZ_PATTERN.matcher(telefone_not.trim()).matches()) {
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
                                    candidato.setDataNac(data);
                                    candidato.setEmail(email);
                                    candidato.setTelefone(telefone_long);
                                    Usuario usuario = new Usuario();
                                    usuario.setEmail(email);

                                    CandidatoDAO candidatoDAO = new CandidatoDAO();
                                    candidatoDAO.updatecand(candidato,cpf_antigo);
                                    UsuarioDAO usuarioDAO = new UsuarioDAO();
                                    usuarioDAO.updateusu(usuario,cpf_antigo);

                                    HelloApplication.ChangeScene("areacandidato");
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
                                                candidato.setCpf(cpf_antigo);
                                                candidato.setDataNac(data);
                                                candidato.setEmail(email);
                                                candidato.setTelefone(telefone_long);
                                                Usuario usuario = new Usuario();
                                                usuario.setEmail(email);
                                                usuario.setCpf(cpf_antigo);

                                                CandidatoDAO candidatoDAO = new CandidatoDAO();
                                                candidatoDAO.updatecand(candidato,cpf_antigo);

                                                UsuarioDAO usuarioDAO = new UsuarioDAO();
                                                usuarioDAO.updateusu(usuario,cpf_antigo);

                                                HelloApplication.ChangeScene("areacandidato");
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
                }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("FORMATO DE TELEFONE INVÁLIDO");
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
    private void mascaraNascimento() {
        Formatter nascimento = new Formatter();
        nascimento.setMask("##/##/####");
        nascimento.setCaracteresValidos("0123456789");
        nascimento.setTf(campoData);
        nascimento.formatter();
    }

    // Definição das ações dos botões

    @FXML
    void AvancarHome(ActionEvent event) throws Exception {HelloApplication.ChangeScene("home");}

    @FXML
    void AvancarAreaCandidato(ActionEvent event) throws Exception {HelloApplication.ChangeScene("areacandidato");}

    @FXML
    void AvancarVagas(ActionEvent event) throws Exception {HelloApplication.ChangeScene("candidatura");}

    @FXML
    void AvancarProcessoSeletivo(ActionEvent event) throws Exception {HelloApplication.ChangeScene("processoseletivo");}

    @FXML
    void AvancarSobre(ActionEvent event) throws Exception {HelloApplication.ChangeScene("sobre");}

    @FXML
    void SairTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("login");}

}


