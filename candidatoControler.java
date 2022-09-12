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

public class candidatoCOntroler {

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
            String nomeObrigatorio = JOptionPane.showInputDialog("O CAMPO NOME É OBRIGATÓRIO! FAVOR PREENCHER!");
            System.out.println(nomeObrigatorio);
            return;
        }
        if(cpfCandidato.getText().equals("")){
            String cpfObrigatorio = JOptionPane.showInputDialog("O CAMPO CPF É OBRIGATÓRIO! FAVOR PREENCHER!");
            System.out.println(cpfObrigatorio);
            return;
        }
        if (cpfCandidato.getText().equals("00000000000")){
            String cpf0 = JOptionPane.showInputDialog("INSIRA UM CPF VÁLIDO!");
            System.out.println(cpf0);
            return;
        }
        if (cpfCandidato.getText().equals("11111111111")){
            String cpf1 = JOptionPane.showInputDialog("INSIRA UM CPF VÁLIDO!");
            System.out.println(cpf1);
            return;
        }
        if (cpfCandidato.getText().equals("22222222222")){
            String cpf2 = JOptionPane.showInputDialog("INSIRA UM CPF VÁLIDO!");
            System.out.println(cpf2);
            return;
        }
        if (cpfCandidato.getText().equals("33333333333")){
            String cpf3 = JOptionPane.showInputDialog("INSIRA UM CPF VÁLIDO!");
            System.out.println(cpf3);
            return;
        }
        if (cpfCandidato.getText().equals("44444444444")){
            String cpf4 = JOptionPane.showInputDialog("INSIRA UM CPF VÁLIDO!");
            System.out.println(cpf4);
            return;
        }
        if (cpfCandidato.getText().equals("55555555555")){
            String cpf5 = JOptionPane.showInputDialog("INSIRA UM CPF VÁLIDO!");
            System.out.println(cpf5);
            return;
        }
        if (cpfCandidato.getText().equals("66666666666")){
            String cpf6 = JOptionPane.showInputDialog("INSIRA UM CPF VÁLIDO!");
            System.out.println(cpf6);
            return;
        }
        if (cpfCandidato.getText().equals("77777777777")){
            String cpf7 = JOptionPane.showInputDialog("INSIRA UM CPF VÁLIDO!");
            System.out.println(cpf7);
            return;
        }
        if (cpfCandidato.getText().equals("88888888888")){
            String cpf8 = JOptionPane.showInputDialog("INSIRA UM CPF VÁLIDO!");
            System.out.println(cpf8);
            return;
        }
        if (cpfCandidato.getText().equals("99999999999")){
            String cpf9 = JOptionPane.showInputDialog("INSIRA UM CPF VÁLIDO!");
            System.out.println(cpf9);
            return;
        }
        //if (cpfCandidato.length() != 11){    
        //}
        
        if(dataCandidato.getValue().equals("")){
            String dataObrigatoria = JOptionPane.showInputDialog("O CAMPO DATA DE NASCIMENTO É OBRIGATÓRIO! FAVOR PREENCHER!");
            System.out.println(dataObrigatoria);
            return;
        }
        if(emailCandidato.getText().equals("")){
            String emailObrigatorio = JOptionPane.showInputDialog("O CAMPO EMAIL É OBRIGATÓRIO! FAVOR PREENCHER!");
            System.out.println(emailObrigatorio);
            return;
        }
        if(senhaCandidato.getText().equals("")){
            String senhaObrigatoria = JOptionPane.showInputDialog("O CAMPO SENHA É OBRIGATÓRIO! FAVOR PREENCHER!");
            System.out.println(senhaObrigatoria);
            return;
        }
        if(telefoneCandidato.getText().equals("")){
            String telefoneObrigatorio = JOptionPane.showInputDialog("O CAMPO TELEFONE É OBRIGATÓRIO! FAVOR PREENCHER!");
            System.out.println(telefoneObrigatorio);
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

