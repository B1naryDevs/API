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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class candidatoControler {

    @FXML
    private Button botaoAvancar;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoCpf;

    @FXML
    private DatePicker campoData;

    @FXML
    private TextField campoEmail;

    @FXML
    private TextField campoSenha;

    @FXML
    private TextField campoTelefone;

    @FXML
    void AvancarTela(ActionEvent event) throws FileNotFoundException {

        String nome = campoNome.getText();
        String cpf = campoCpf.getText();
        LocalDate datainicial = campoData.getValue();
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
        String datafinal = dtf.format(datainicial);
        String email = campoEmail.getText();
        String senha = campoSenha.getText();
        String telefone = campoTelefone.getText();

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
        dados.add(nome + "," + cpf + "," + datafinal + "," + email + "," + senha + "," + telefone);

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
    }
}