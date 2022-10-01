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

        primaryStage.setScene(menu);
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
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
