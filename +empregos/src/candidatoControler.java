import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.JOptionPane;
import com.opencsv.CSVWriter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class candidatoControler {

    @FXML
    private Button botaoAvancar;

    @FXML
    private TextField cpfCandidato;

    @FXML
    private DatePicker dataCandidato;

    @FXML
    private TextField emailCandidato;

    @FXML
    private TextField nomeCandidato;

    @FXML
    private TextField senhaCandidato;

    @FXML
    private TextField telefoneCandidato;

    @FXML
    void cadastrarDados(ActionEvent event) throws FileNotFoundException {
        String nome = nomeCandidato.getText();
        String cpf = cpfCandidato.getText();
        LocalDate data = dataCandidato.getValue();
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
        String data2 = dtf.format(data);
        String email = emailCandidato.getText();
        String senha = senhaCandidato.getText();
        String telefone = telefoneCandidato.getText();

        if (nome.equals("") || cpf.equals("") || data2.equals("") || email.equals("") || senha.equals("")
                || telefone.equals("")) {
            JOptionPane.showMessageDialog(null, "PREEENCHA TODOS OS CAMPOS!");
            return;
        }

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
        PrintWriter pw = new PrintWriter(new File("dados_cadidato.csv"));

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

        App.ChangeScene("tela2");
    }

}
