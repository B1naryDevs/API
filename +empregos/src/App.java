import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    private static Stage stage;

    private static Scene tela1;
    private static Scene tela2;
    private static Scene tela3;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        primaryStage.setTitle("+Emprego");

        Parent tela1fxml = FXMLLoader.load(getClass().getResource("layout.fxml"));
        tela1 = new Scene(tela1fxml);

        Parent tela2fxlm = FXMLLoader.load(getClass().getResource("layout2.fxml"));
        tela2 = new Scene(tela2fxlm);

        Parent tela3fxlm = FXMLLoader.load(getClass().getResource("layout3.fxml"));
        tela3 = new Scene(tela3fxlm);

        primaryStage.setScene(tela1);
        primaryStage.show();
        primaryStage.setFullScreen(true);
    }

    public static void ChangeScene(String tela) {
        switch (tela) {
            case "tela1":
                stage.setScene(tela1);
                stage.setFullScreen(true);
                break;
            case "tela2":
                stage.setScene(tela2);
                stage.setFullScreen(true);
                break;
            case "tela3":
                stage.setScene(tela3);
                stage.setFullScreen(true);
        }
    }
}