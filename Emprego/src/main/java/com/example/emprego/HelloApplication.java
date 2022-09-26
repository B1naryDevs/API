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

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        primaryStage.setTitle("+Emprego");

        Parent layoutfxml = FXMLLoader.load(getClass().getResource("layout.fxml"));
        candidato = new Scene(layoutfxml);

        Parent layout2fxml = FXMLLoader.load(getClass().getResource("layout2.fxml"));
        candidato2 = new Scene(layout2fxml);

        Parent layout3fxml = FXMLLoader.load(getClass().getResource("layout3.fxml"));
        candidato3 = new Scene(layout3fxml);

        Parent layout4fxml = FXMLLoader.load(getClass().getResource("layout4.fxml"));
        candidatofinal = new Scene(layout4fxml);

        Parent layout5fxml = FXMLLoader.load(getClass().getResource("layout5.fxml"));
        vaga = new Scene(layout5fxml);

        primaryStage.setScene(vaga);
        primaryStage.show();
        primaryStage.setFullScreen(true);
    }

    public static void ChangeScene(String tela) {
        switch (tela) {
            case "candidato1":
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
            case "candidato4":
                stage.setScene(candidatofinal);
                stage.setFullScreen(true);
                break;
            case "vaga":
                stage.setScene(vaga);
                stage.setFullScreen(true);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}