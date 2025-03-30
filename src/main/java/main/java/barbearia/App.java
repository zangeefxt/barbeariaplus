package main.java.barbearia;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;
import main.java.barbearia.Data.DataConnection;
import main.java.barbearia.Repository.Barbearia_Repositorio;
import main.java.barbearia.controllers.HomeController;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        
        DataConnection connection = new DataConnection();
        connection.DataConnectionInit();

        Barbearia_Repositorio repo = new Barbearia_Repositorio();


        Scene scene = new Scene(loadTela("home.fxml", o -> new HomeController(repo)), 640, 480);
        stage.setScene(scene);
        stage.show();

    }

    public static Parent loadTela(String fxml, Callback controller){
        Parent root = null;
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource(fxml));
            loader.setControllerFactory(controller);

            root = loader.load();
            
        }catch (Exception e){
            System.out.println("Problema no arquivo fxml. Está correto?? "+fxml);
            e.printStackTrace();
            System.exit(0);
        }
        return root;   
    }


    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/barbearia/views/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }
    


    public static void main(String[] args) {
        launch();
    }

}
