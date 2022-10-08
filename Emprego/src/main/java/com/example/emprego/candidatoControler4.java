package com.example.emprego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class candidatoControler4 {

    @FXML
    private Button botaoHome;

    @FXML
    void VoltarInicio(ActionEvent event) throws FileNotFoundException {
        Candidato candidato = new Candidato(null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);;
        String nome = candidato.getNome();
        long cpf = candidato.getCpf();
        String data = candidato.getDataNac();
        String email = candidato.getEmail();
        String senha = candidato.getSenha();
        long telefone = candidato.getTelefone();
        String empresa = candidato.getExpEmpresa();
        String cargo = candidato.getCargo();
        String expinicio = candidato.getExpInicio();
        String exptermino = candidato.getExpTermino();
        String descricao = candidato.getDescricao();
        String cargos = candidato.getCargoInteresse();
        float pretensao = candidato.getPretSalarial();
        String competencia = candidato.getCompetencia();
        String idioma = candidato.getIdioma();
        String instituicao = candidato.getInstituicao();
        String inicio = candidato.getCursoInicio();
        String termino = candidato.getCursoTermino();
        String curso = candidato.getCurso();

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
        dados.add(nome + "," + cpf + "," + data + "," + email + "," + senha + "," + telefone + "," + empresa + "," + cargo + "," + expinicio + "," + exptermino + "," + descricao + "," + cargos + "," + pretensao + "," +competencia + "," + idioma + "," + instituicao + "," + inicio + "," + termino + "," + curso);

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
        HelloApplication.ChangeScene("candidato");
    }
}
