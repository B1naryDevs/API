package com.example.emprego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class vagaControler2 implements Initializable {

    @FXML
    private Button botaoHome;

   @FXML
    private Button botaoVaga;

    @FXML
    private Button botaoCargo;

    @FXML
    private Button botaoRH;

    @FXML
    private Button botaoRelatorios;

    @FXML
    private ToggleButton botaoSair;

    @FXML
    private Button botaoCadastrar;

    @FXML
    private ToggleButton tgbtModo;

    @FXML
    private AnchorPane anchor;

    @FXML
    private ImageView imgModo;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
         Tema tema = new Tema();
         if (tema.getLuz() == false) {
             Image image = new Image("file:src/main/resources/imagens/Lua.png", 25, 25, true, true);
             anchor.getStylesheets().add("file:src/main/resources/styles/ModoEscuro.css");
             imgModo.setImage(image);
         } else {
             Image image = new Image("file:src/main/resources/imagens/Sol.png", 25, 25, true, true);
             anchor.getStylesheets().add("file:src/main/resources/styles/ModoClaro.css");
             imgModo.setImage(image);
         }
    }

    @FXML
    void AvancarHome(ActionEvent event) throws Exception {HelloApplication.ChangeScene("homerh");}

    @FXML
    void AvancarVaga(ActionEvent event) throws Exception {HelloApplication.ChangeScene("telavaga");}

    @FXML
    void AvancarCargo(ActionEvent event) throws Exception { HelloApplication.ChangeScene("cargo");}

    @FXML
    void AvancarRH(ActionEvent event) throws Exception {HelloApplication.ChangeScene("rh");}

    @FXML
    void AvancarRelatorio(ActionEvent event) throws Exception {HelloApplication.ChangeScene("rh4");}

    @FXML
    void SairTela(ActionEvent event) throws Exception {HelloApplication.ChangeScene("login");}

    public void alterarModo(ActionEvent event) {
        Tema tema = new Tema();
        if (tema.getLuz() == false) {
            Image image = new Image("file:src/main/resources/imagens/Sol.png", 25, 25, true, true);
            anchor.getStylesheets().add("file:src/main/resources/styles/ModoClaro.css");
            anchor.getStylesheets().remove("file:src/main/resources/styles/ModoEscuro.css");
            imgModo.setImage(image);
            tema.setLuz(true);
        } else {
            Image image = new Image("file:src/main/resources/imagens/Lua.png", 25, 25, true, true);
            anchor.getStylesheets().add("file:src/main/resources/styles/ModoEscuro.css");
            anchor.getStylesheets().remove("file:src/main/resources/styles/ModoClaro.css");
            imgModo.setImage(image);
            tema.setLuz(false);
        }
    }
}


