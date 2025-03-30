package main.java.barbearia.controllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import main.java.barbearia.App;
import main.java.barbearia.Repository.Barbearia_Repositorio;
import main.java.barbearia.models.Cortes;


public class HomeController {

    @FXML private Button btnAgendar;
    @FXML private Button btnListar;
    @FXML private Button btnSair;

    @FXML
    private StackPane painelCentral;

    @FXML
    private TableView<Cortes> tbView;

    @FXML
    private TableColumn<Cortes,Integer> tbcClienteID;


    @FXML
    private TableColumn<Cortes,String> tbcWhatsApp;

    @FXML
    private TableColumn<Cortes,String> tbcNome;

    @FXML
    private TableColumn<Cortes,String> tbcEmail;

    @FXML
    private TableColumn<Cortes,String> tbcTipoCorte;

    @FXML
    private TableColumn<Cortes,String> tbcDataHora;

    @FXML
    private Button btCadastrar;

    private final Barbearia_Repositorio repo;

    public HomeController(Barbearia_Repositorio repo){
        this.repo = repo;
    }

    public void initialize(){ 

            

        tbcClienteID.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getIdCliente()).asObject());
        tbcNome.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
        tbcEmail.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEmail()));
        tbcTipoCorte.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTipoCorte()));
        tbcDataHora.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDataHora()));
        tbcWhatsApp.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getWhatsApp()));

        
        try{
            System.out.println("Listando os cortes ativos...");
            System.out.println(repo.listarCortesAtivos());
            tbView.getItems().addAll(repo.listarCortesAtivos());

        }catch(Exception e){
            Alert alert = new Alert(AlertType.ERROR, e.getMessage());
            alert.showAndWait();
        }

    }
    
    
    
} 