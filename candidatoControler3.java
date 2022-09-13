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
import javax.swing.JOptionPane;

public class candidatoControler3 {

    @FXML
    private Button botaoAvancar3;

    @FXML
    private Button botaoVoltar2;

    @FXML
    private TextField competenciaCandidato;

    @FXML
    private TextField cursoCandidato;

    @FXML
    private TextField idiomaCandidato;

    @FXML
    private DatePicker inicioCandidato2;

    @FXML
    private TextField intituicaoCandidato;

    @FXML
    private DatePicker terminoCandidato2;

    @FXML
    void cadastrarDados3(ActionEvent event) throws FileNotFoundException {
        String curso = cursoCandidato.getText();
        String instituicao = intituicaoCandidato.getText();
        String idioma = idiomaCandidato.getText();
        String competencia = competenciaCandidato.getText();
        LocalDate inicio3 = inicioCandidato2.getValue();
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
        String inicio4 = dtf.format(inicio3);
        LocalDate termino3 = terminoCandidato2.getValue();
        String termino4 = dtf.format(inicio3);
        
        if (curso.equals("") || instituicao.equals("") || idioma.equals("") || competencia.equals("")
                || inicio4.equals("") || termino4.equals("")){ 
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
        dados.add(curso + "," + instituicao + "," + idioma + "," + competencia + "," + inicio4 + "," + termino4);

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
    }

    @FXML
    void voltarTela2(ActionEvent event) {
        App.ChangeScene("tela2");
    }

}
