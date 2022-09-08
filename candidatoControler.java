import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.opencsv.CSVWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    void cadastrarDados(ActionEvent event) {
        String nome = nomeCandidato.getText();
        String cpf = cpfCandidato.getText();
        LocalDate data = dataCandidato.getValue();
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
        String data2 = dtf.format(data);
        String email = emailCandidato.getText();
        String senha = senhaCandidato.getText();
        String telefone = telefoneCandidato.getText();

        try {
            String caminho = "dados_candidato.csv";
            FileWriter fw = new FileWriter(new File(caminho));
            CSVWriter cw = new CSVWriter(fw);

            String[] headers = { "Nome", "CPF", "Data de Nascimento", "Email", "Senha", "Telefone" };
            List<String[]> dados = new ArrayList<String[]>();
            String[] candidato = { nome, cpf, data2, email, senha, telefone };

            dados.add(headers);
            dados.add(candidato);

            cw.writeAll(dados);

            cw.close();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
