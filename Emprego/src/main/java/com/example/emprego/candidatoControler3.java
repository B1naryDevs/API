package com.example.emprego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class candidatoControler3 {

    @FXML
    private Button botaoFinalizar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private TextField campoCompetencia;

    @FXML
    private TextField campoCurso;

    @FXML
    private TextField campoIdioma;

    @FXML
    private DatePicker campoInicio;

    @FXML
    private TextField campoInstituicao;

    @FXML
    private DatePicker campoTermino;

    @FXML
    void FinalizarCadastro(ActionEvent event) throws FileNotFoundException {
        String competencia = campoCompetencia.getText();
        String idioma = campoIdioma.getText();
        String instituicao = campoInstituicao.getText();
        LocalDate inicioinicial = campoInicio.getValue();
        LocalDate terminoinicial = campoTermino.getValue();
        String inicio = String.valueOf(inicioinicial);
        String termino = String.valueOf(terminoinicial);
        String curso = campoCurso.getText();

        if (competencia.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA A COMPETENCIA!");
            alert.showAndWait();
        } else if (idioma.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O IDIOMA!");
            alert.showAndWait();
        } else if (instituicao.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA A INSTITUIÇÃO!");
            alert.showAndWait();
        } else if (inicio.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA A DATA DE INICIO!");
            alert.showAndWait();
        } else if (termino.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA A DATA DE TERMINO!");
            alert.showAndWait();
        } else if (curso.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O CURSO!");
            alert.showAndWait();
        } else {
            // Validação data inicio
            String INICIO_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";
            Pattern INICIO_PATTERN = Pattern.compile(INICIO_REGEX);
            if (INICIO_PATTERN.matcher(inicio).matches()) {
                // Validação data termino
                String TERMINO_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";
                Pattern TERMINO_PATTERN = Pattern.compile(TERMINO_REGEX);
                if (TERMINO_PATTERN.matcher(termino).matches()) {
                    Candidato candidato = new Candidato();
                    candidato.setCompetencia(competencia);
                    candidato.setIdioma(idioma);
                    candidato.setInstituicao(instituicao);
                    candidato.setCursoInicio(inicio);
                    candidato.setCursoTermino(termino);
                    candidato.setCurso(curso);

                    String nome = candidato.getNome();
                    String cpf = candidato.getCpf();
                    String data = candidato.getDataNac();
                    String email = candidato.getEmail();
                    String senha = candidato.getSenha();
                    String telefone = candidato.getTelefone();
                    String empresa = candidato.getExpEmpresa();
                    String cargo = candidato.getCargo();
                    String expinicio = candidato.getExpInicio();
                    String exptermino = candidato.getExpTermino();
                    String descricao = candidato.getDescricao();
                    String cargos = candidato.getCargoInteresse();
                    String pretensao = candidato.getPretSalarial();

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
                    dados.add(nome + "," + cpf + "," + data + "," + email + "," + senha + "," + telefone + "," + empresa + "," + cargo + "," + expinicio + "," + exptermino + "," + descricao + "," + cargos + "," + pretensao + "," + competencia + "," + idioma + "," + instituicao + "," + inicio + "," + termino + "," + curso);

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

                    // fecha conexão com arquivo
                    pw.close();

                    HelloApplication.ChangeScene("candidatofinal");
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("FORMATO DE DATA INVÁLIDO!");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("FORMATO DE DATA INVÁLIDO!");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void VoltarTela(ActionEvent event) {
        HelloApplication.ChangeScene("candidato2");
    }
}
