package com.example.emprego;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {

    private static Stage stage;
    private static Scene candidato;
    private static Scene candidato2;
    private static Scene candidato3;
    private static Scene candidatofinal;
    private static Scene vaga;
    private static Scene vagafinal;
    private static Scene login;
    private static Scene cargo;
    private static Scene cargofinal;
    private static Scene rh;
    private static Scene rh2;
    private static Scene rh3;
    private static Scene rh4;
    private static Scene rh5;
    private static Scene processoseletivo;
    private static Scene candidatura;
    private static Scene candidatura2;
    private static Scene areacandidato;
    private static Scene home;
    private static Scene homerh;
    private static Scene sobre;
    private static Scene gerenciamentovaga;
    private static Scene gerenciamentovaga2;
    private static Scene telavaga;
    private static Scene telavaga2;
    private static Scene telavaga3;
    private static Scene telavaga4;
    private static Scene relatorio;
    private static Scene relatorio2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        primaryStage.setTitle("+Emprego");

        Parent layout_login = FXMLLoader.load(HelloApplication.class.getResource("layout_login.fxml"));
        login = new Scene(layout_login);

        primaryStage.setScene(login);
        primaryStage.show();
        primaryStage.setFullScreen(true);
    }

    public static void ChangeScene(String tela) throws IOException {
        FuncionarioUsuario funcionarioUsuario = new FuncionarioUsuario();
        switch (tela) {
            case "candidato":
                Parent layout_candidato = FXMLLoader.load(HelloApplication.class.getResource("layout_candidato.fxml"));
                candidato = new Scene(layout_candidato);
                stage.setScene(candidato);
                stage.setFullScreen(true);
                break;
            case "candidato2":
                Parent layout_candidato2 = FXMLLoader.load(HelloApplication.class.getResource("layout_candidato2.fxml"));
                candidato2 = new Scene(layout_candidato2);
                stage.setScene(candidato2);
                stage.setFullScreen(true);
                break;
            case "candidato3":
                Parent layout_candidato3 = FXMLLoader.load(HelloApplication.class.getResource("layout_candidato3.fxml"));
                candidato3 = new Scene(layout_candidato3);
                stage.setScene(candidato3);
                stage.setFullScreen(true);
                break;
            case "candidatofinal":
                Parent layout_candidato4 = FXMLLoader.load(HelloApplication.class.getResource("layout_candidato4.fxml"));
                candidatofinal = new Scene(layout_candidato4);
                stage.setScene(candidatofinal);
                stage.setFullScreen(true);
                break;
            case "vaga":
                Parent layout_vaga = FXMLLoader.load(HelloApplication.class.getResource("layout_vaga.fxml"));
                vaga = new Scene(layout_vaga);
                stage.setScene(vaga);
                stage.setFullScreen(true);
                break;
            case "vagafinal":
                Parent layout_vaga2 = FXMLLoader.load(HelloApplication.class.getResource("layout_vaga2.fxml"));
                vagafinal = new Scene(layout_vaga2);
                stage.setScene(vagafinal);
                stage.setFullScreen(true);
                break;
            case "login":
                Parent layout_login = FXMLLoader.load(HelloApplication.class.getResource("layout_login.fxml"));
                login = new Scene(layout_login);
                stage.setScene(login);
                stage.setFullScreen(true);
                break;
            case "cargo":
                Parent layout_cargo = FXMLLoader.load(HelloApplication.class.getResource("layout_cargo.fxml"));
                cargo = new Scene(layout_cargo);
                stage.setScene(cargo);
                stage.setFullScreen(true);
                break;
            case "cargofinal":
                Parent layout_cargo2 = FXMLLoader.load(HelloApplication.class.getResource("layout_cargo2.fxml"));
                cargofinal = new Scene(layout_cargo2);
                stage.setScene(cargofinal);
                stage.setFullScreen(true);
                break;
            case "rh":
                Parent layout_rh = FXMLLoader.load(HelloApplication.class.getResource("layout_rh.fxml"));
                rh = new Scene(layout_rh);
                stage.setScene(rh);
                stage.setFullScreen(true);
                break;
            case "rh2":
                Parent layout_rh2 = FXMLLoader.load(HelloApplication.class.getResource("layout_rh2.fxml"));
                rh2 = new Scene(layout_rh2);
                stage.setScene(rh2);
                stage.setFullScreen(true);
                break;
            case "rh3":
                Parent layout_rh3 = FXMLLoader.load(HelloApplication.class.getResource("layout_rh3.fxml"));
                rh3 = new Scene(layout_rh3);
                stage.setScene(rh3);
                stage.setFullScreen(true);
                break;
            case "rh4":
                Parent layout_rh4 = FXMLLoader.load(HelloApplication.class.getResource("layout_rh4.fxml"));
                rh4 = new Scene(layout_rh4);
                stage.setScene(rh4);
                stage.setFullScreen(true);
                break;
            case "rh5":
                Parent layout_rh5 = FXMLLoader.load(HelloApplication.class.getResource("layout_rh5.fxml"));
                rh5 = new Scene(layout_rh5);
                stage.setScene(rh5);
                stage.setFullScreen(true);
                break;
            case "processoseletivo":
                Parent layout_processoseletivo = FXMLLoader.load(HelloApplication.class.getResource("layout_processoSeletivo.fxml"));
                processoseletivo = new Scene(layout_processoseletivo);
                stage.setScene(processoseletivo);
                stage.setFullScreen(true);
                break;
            case "areacandidato":
                Parent layout_area_candidato = FXMLLoader.load(HelloApplication.class.getResource("layout_area_candidato.fxml"));
                areacandidato = new Scene(layout_area_candidato);
                stage.setScene(areacandidato);
                stage.setFullScreen(true);
                break;
            case "candidatura":
                Parent layout_candidatura = FXMLLoader.load(HelloApplication.class.getResource("layout_candidatura.fxml"));
                candidatura = new Scene(layout_candidatura);
                stage.setScene(candidatura);
                stage.setFullScreen(true);
                break;
            case "candidatura2":
                Parent layout_candidatura2 = FXMLLoader.load(HelloApplication.class.getResource("layout_candidatura2.fxml"));
                candidatura2 = new Scene(layout_candidatura2);
                stage.setScene(candidatura2);
                stage.setFullScreen(true);
                break;
            case "homerh":
                Parent layout_homerh = FXMLLoader.load(HelloApplication.class.getResource("layout_homerh.fxml"));
                homerh = new Scene(layout_homerh);
                stage.setScene(homerh);
                stage.setFullScreen(true);
                break;
            case "home":
                Parent layout_home = FXMLLoader.load(HelloApplication.class.getResource("layout_home.fxml"));
                home = new Scene(layout_home);
                stage.setScene(home);
                stage.setFullScreen(true);
                break;
            case "sobre":
                Parent layout_sobre_nos = FXMLLoader.load(HelloApplication.class.getResource("layout_sobre_nos.fxml"));
                sobre = new Scene(layout_sobre_nos);
                stage.setScene(sobre);
                stage.setFullScreen(true);
                break;
            case "gerenciamentovaga":
                Parent layout_gerenciamento_vaga = FXMLLoader.load(HelloApplication.class.getResource("layout_gerenciamento_vaga.fxml"));
                gerenciamentovaga = new Scene(layout_gerenciamento_vaga);
                stage.setScene(gerenciamentovaga);
                stage.setFullScreen(true);
                break;
            case "gerenciamentovaga2":
                Parent layout_gerenciamento_vaga2 = FXMLLoader.load(HelloApplication.class.getResource("layout_gerenciamento_vaga2.fxml"));
                gerenciamentovaga2 = new Scene(layout_gerenciamento_vaga2);
                stage.setScene(gerenciamentovaga2);
                stage.setFullScreen(true);
                break;
            case "telavaga":
                Parent layout_telavaga = FXMLLoader.load(HelloApplication.class.getResource("layout_telavaga.fxml"));
                telavaga = new Scene(layout_telavaga);
                stage.setScene(telavaga);
                stage.setFullScreen(true);
                break;
            case "telavaga2":
                Parent layout_telavaga2 = FXMLLoader.load(HelloApplication.class.getResource("layout_telavaga2.fxml"));
                telavaga2 = new Scene(layout_telavaga2);
                stage.setScene(telavaga2);
                stage.setFullScreen(true);
                break;
            case "telavaga3":
                Parent layout_telavaga3 = FXMLLoader.load(HelloApplication.class.getResource("layout_telavaga3.fxml"));
                telavaga3 = new Scene(layout_telavaga3);
                stage.setScene(telavaga3);
                stage.setFullScreen(true);
                break;
            case "telavaga4":
                Parent layout_telavaga4 = FXMLLoader.load(HelloApplication.class.getResource("layout_telavaga4.fxml"));
                telavaga4 = new Scene(layout_telavaga4);
                stage.setScene(telavaga4);
                stage.setFullScreen(true);
                break;
            case "relatorio":
                if(funcionarioUsuario.getEmail().equals("Adm@gmail.com")){
                    Parent layout_relatorio = FXMLLoader.load(HelloApplication.class.getResource("layout_relatorio.fxml"));
                    relatorio = new Scene(layout_relatorio);
                    stage.setScene(relatorio);
                    stage.setFullScreen(true);
                }else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("ACESSO NEGADO!");
                    alert.showAndWait();
                }
                break;
            case "relatorio2":
                if(funcionarioUsuario.getEmail().equals("Adm@gmail.com")){
                    Parent layout_relatorio2 = FXMLLoader.load(HelloApplication.class.getResource("layout_relatorio2.fxml"));
                    relatorio2 = new Scene(layout_relatorio2);
                    stage.setScene(relatorio2);
                    stage.setFullScreen(true);
                }else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("ACESSO NEGADO!");
                    alert.showAndWait();
                }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
