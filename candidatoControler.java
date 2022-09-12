import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.opencsv.CSVWriter;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

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
        String formatado = cpf.substring(0, 3) + "." +
                   cpf.substring(3, 6) + "." +
                   cpf.substring(6, 9) + "-" +
                   cpf.substring(9, 11);
        LocalDate data = dataCandidato.getValue();
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
        String data2 = dtf.format(data);
        String email = emailCandidato.getText();
        String senha = senhaCandidato.getText();
        String telefone = telefoneCandidato.getText();
        if(nomeCandidato.getText().equals("")){
            System.out.println("O CAMPO NOME É OBRIGATÓRIO! FAVOR PREENCHER!");
            return;
        }
        if(cpfCandidato.getText().equals("")){
            System.out.println("O CAMPO CPF É OBRIGATÓRIO! FAVOR PREENCHER!");
            return;
        }
        if (cpfCandidato.getText().equals("00000000000")){
            System.out.println("INSIRA UM CPF VÁLIDO!");
            return;
        }
        if (cpfCandidato.getText().equals("11111111111")){
            System.out.println("INSIRA UM CPF VÁLIDO!");
            return;
        }
        if (cpfCandidato.getText().equals("22222222222")){
            System.out.println("INSIRA UM CPF VÁLIDO!");
            return;
        }
        if (cpfCandidato.getText().equals("33333333333")){
            System.out.println("INSIRA UM CPF VÁLIDO!");
            return;
        }
        if (cpfCandidato.getText().equals("44444444444")){
            System.out.println("INSIRA UM CPF VÁLIDO!");
            return;
        }
        if (cpfCandidato.getText().equals("55555555555")){
            System.out.println("INSIRA UM CPF VÁLIDO!");
            return;
        }
        if (cpfCandidato.getText().equals("66666666666")){
            System.out.println("INSIRA UM CPF VÁLIDO!");
            return;
        }
        if (cpfCandidato.getText().equals("77777777777")){
            System.out.println("INSIRA UM CPF VÁLIDO!");
            return;
        }
        if (cpfCandidato.getText().equals("88888888888")){
            System.out.println("INSIRA UM CPF VÁLIDO!");
            return;
        }
        if (cpfCandidato.getText().equals("99999999999")){
            System.out.println("INSIRA UM CPF VÁLIDO!");
            return;
        }
        //if (cpfCandidato.length() != 11){    
        //}
        
        if(dataCandidato.getValue().equals("")){
            System.out.println("O CAMPO DATA DE NASCIMENTO É OBRIGATÓRIO! FAVOR PREENCHER!");
            return;
        }
        if(emailCandidato.getText().equals("")){
            System.out.println("O CAMPO EMAIL É OBRIGATÓRIO! FAVOR PREENCHER!");
            return;
        }
        if(senhaCandidato.getText().equals("")){
            System.out.println("O CAMPO SENHA É OBRIGATÓRIO! FAVOR PREENCHER!");
            return;
        }
        if(telefoneCandidato.getText().equals("")){
            System.out.println("O CAMPO TELEFONE É OBRIGATÓRIO! FAVOR PREENCHER!");
            return;
        }
        

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

