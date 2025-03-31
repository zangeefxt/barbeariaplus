package main.java.barbearia;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.java.barbearia.Controllers.JanelaBase;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Pane root = loadMainPane();
        stage.setScene(new Scene(root, 640, 480));

        stage.setTitle("Barbearia...");
        stage.show();
        stage.setResizable(false);
    }

    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(
                App.class.getResourceAsStream(
                        Navegador.JANELA_BASE
                )
        );

        JanelaBase controller = loader.getController();

        Navegador.setControlador(controller);
        Navegador.loadJanela(Navegador.JANELA_HOME);

        return mainPane;
    }

    public static void main(String[] args) {
        launch();
    }
}
