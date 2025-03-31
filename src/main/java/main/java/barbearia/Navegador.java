package main.java.barbearia;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import main.java.barbearia.Controllers.JanelaBase;

public class Navegador {


    public static final String JANELA_BASE = "/main/java/barbearia/base.fxml";
    public static final String JANELA_HOME = "/main/java/barbearia/home.fxml";
    public static final String JANELA_CADASTRAR_BARBEARIA = "/main/java/barbearia/cadastrarBarbearia.fxml";

    private static JanelaBase controlador;

    public static void setControlador(JanelaBase controlador) {
        Navegador.controlador = controlador;
    }

    public static void loadJanela(String fxml) {
        try {
            controlador.setJanela((Node) FXMLLoader.load(Navegador.class.getResource(fxml)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}