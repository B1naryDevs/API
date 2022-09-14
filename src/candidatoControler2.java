import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.opencsv.CSVWriter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class candidatoControler2 {

    @FXML
    private Button botaoAvancar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private TextField cargoCandidato;

    @FXML
    private TextField cargosCandidato;

    @FXML
    private TextField descricaoCandidato;

    @FXML
    private TextField empresaCandidato;

    @FXML
    private DatePicker inicioCandidato;

    @FXML
    private TextField pretencaoCandidato;

    @FXML
    private DatePicker terminoCandidato;

    @FXML
    void cadastrarDados2(ActionEvent event) throws FileNotFoundException {
        String cargo = cargoCandidato.getText();
        String descricao = descricaoCandidato.getText();
        String empresa = empresaCandidato.getText();
        String cargos = cargosCandidato.getText();
        String pretencao = pretencaoCandidato.getText();
        LocalDate inicio = inicioCandidato.getValue();
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
        String inicio2 = dtf.format(inicio);
        LocalDate termino = terminoCandidato.getValue();
        String termino2 = dtf.format(termino);

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
        dados.add(cargo + "," + descricao + "," + empresa + "," + inicio2 + "," + termino2 + "," + cargos + ","
                + pretencao);

        // criação de novo objeto para escrever os novos valores
        PrintWriter pw = new PrintWriter(new File("dados_cadidato2.csv"));

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

        App.ChangeScene("tela3");
    }

    @FXML
    void voltarTela(ActionEvent event) {
        App.ChangeScene("tela1");
    }

}
