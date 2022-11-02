package com.example.emprego;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class HelloApplication extends Application {

    private static Stage stage;
    private static Scene candidato;
    private static Scene candidato2;
    private static Scene candidato3;
    private static Scene candidatofinal;
    private static Scene vaga;
    private static Scene vagafinal;
    private static Scene login;
    private static Scene menu;
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
    private static Scene sobre;


    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        primaryStage.setTitle("+Emprego");

        Parent layout_candidato = FXMLLoader.load(getClass().getResource("layout_candidato.fxml"));
        candidato = new Scene(layout_candidato);

        Parent layout_candidato2 = FXMLLoader.load(getClass().getResource("layout_candidato2.fxml"));
        candidato2 = new Scene(layout_candidato2);

        Parent layout_candidato3 = FXMLLoader.load(getClass().getResource("layout_candidato3.fxml"));
        candidato3 = new Scene(layout_candidato3);

        Parent layout_candidato4 = FXMLLoader.load(getClass().getResource("layout_candidato4.fxml"));
        candidatofinal = new Scene(layout_candidato4);

        Parent layout_vaga = FXMLLoader.load(getClass().getResource("layout_vaga.fxml"));
        vaga = new Scene(layout_vaga);

        Parent layout_vaga2 = FXMLLoader.load(getClass().getResource("layout_vaga2.fxml"));
        vagafinal = new Scene(layout_vaga2);

        Parent layout_login = FXMLLoader.load(getClass().getResource("layout_login.fxml"));
        login = new Scene(layout_login);

        Parent layout_menu = FXMLLoader.load(getClass().getResource("layout_menu.fxml"));
        menu = new Scene(layout_menu);

        Parent layout_cargo = FXMLLoader.load(getClass().getResource("layout_cargo.fxml"));
        cargo = new Scene(layout_cargo);
        
        Parent layout_cargo2 = FXMLLoader.load(getClass().getResource("layout_cargo2.fxml"));
        cargofinal = new Scene(layout_cargo2);

        Parent layout_rh = FXMLLoader.load(getClass().getResource("layout_rh.fxml"));
        rh = new Scene(layout_rh);

        Parent layout_rh2 = FXMLLoader.load(getClass().getResource("layout_rh2.fxml"));
        rh2 = new Scene(layout_rh2);

        Parent layout_rh3 = FXMLLoader.load(getClass().getResource("layout_rh3.fxml"));
        rh3 = new Scene(layout_rh3);

        Parent layout_rh4 = FXMLLoader.load(getClass().getResource("layout_rh4.fxml"));
        rh4 = new Scene(layout_rh4);

        Parent layout_rh5 = FXMLLoader.load(getClass().getResource("layout_rh5.fxml"));
        rh5 = new Scene(layout_rh5);

        Parent layout_processoseletivo = FXMLLoader.load(getClass().getResource("layout_processoSeletivo.fxml"));
        processoseletivo = new Scene(layout_processoseletivo);

        Parent layout_area_candidato = FXMLLoader.load(getClass().getResource("layout_area_candidato.fxml"));
        areacandidato = new Scene(layout_area_candidato);

        Parent layout_candidatura = FXMLLoader.load(getClass().getResource("layout_candidatura.fxml"));
        candidatura = new Scene(layout_candidatura);

        Parent layout_candidatura2 = FXMLLoader.load(getClass().getResource("layout_candidatura2.fxml"));
        candidatura2 = new Scene(layout_candidatura2);

        Parent layout_home = FXMLLoader.load(getClass().getResource("layout_home.fxml"));
        home = new Scene(layout_home);

        Parent layout_sobre_nos = FXMLLoader.load(getClass().getResource("layout_sobre_nos.fxml"));
        sobre = new Scene(layout_sobre_nos);

        primaryStage.setScene(login);
        primaryStage.show();
        primaryStage.setFullScreen(true);
    }

    public static void ChangeScene(String tela) {
        switch (tela) {
            case "candidato":
                stage.setScene(candidato);
                stage.setFullScreen(true);
                break;
            case "candidato2":
                stage.setScene(candidato2);
                stage.setFullScreen(true);
                break;
            case "candidato3":
                stage.setScene(candidato3);
                stage.setFullScreen(true);
                break;
            case "candidatofinal":
                stage.setScene(candidatofinal);
                stage.setFullScreen(true);
                break;
            case "vaga":
                stage.setScene(vaga);
                stage.setFullScreen(true);
                break;
            case "vagafinal":
                stage.setScene(vagafinal);
                stage.setFullScreen(true);
                break;
            case "login":
                stage.setScene(login);
                stage.setFullScreen(true);
                break;
            case "menu":
                stage.setScene(menu);
                stage.setFullScreen(true);
                break;
            case "cargo":
                stage.setScene(cargo);
                stage.setFullScreen(true);
                break;
            case "cargofinal":
                stage.setScene(cargofinal);
                stage.setFullScreen(true);
                break;
            case "rh":
                stage.setScene(rh);
                stage.setFullScreen(true);
                break;
            case "rh2":
                stage.setScene(rh2);
                stage.setFullScreen(true);
                break;
            case "rh3":
                stage.setScene(rh3);
                stage.setFullScreen(true);
                break;
            case "rh4":
                stage.setScene(rh4);
                stage.setFullScreen(true);
                break;
            case "rh5":
                stage.setScene(rh5);
                stage.setFullScreen(true);
                break;
            case "processoseletivo":
                stage.setScene(processoseletivo);
                stage.setFullScreen(true);
                break;
            case "areacandidato":
                stage.setScene(areacandidato);
                stage.setFullScreen(true);
                break;
            case "candidatura":
                stage.setScene(candidatura);
                stage.setFullScreen(true);
                break;
            case "candidatura2":
                stage.setScene(candidatura2);
                stage.setFullScreen(true);
                break;
            case "home":
                stage.setScene(home);
                stage.setFullScreen(true);
                break;
            case "sobre":
                stage.setScene(sobre);
                stage.setFullScreen(true);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
