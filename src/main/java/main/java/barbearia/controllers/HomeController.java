package main.java.barbearia.Controllers;

import java.io.IOException;
import java.time.LocalDateTime;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import main.java.barbearia.Navegador;
import main.java.barbearia.Models.Barbearia;

public class HomeController {

    @FXML
    private Button btCadastrar;

    @FXML
    private TextField searchField;

    @FXML
    private Button btStatus;

    @FXML
    private StackPane painelCentral;

    @FXML
    private TableView<Barbearia> tbView;

    @FXML
    private TableColumn<Barbearia, Integer> tbcClienteID;

    @FXML
    private TableColumn<Barbearia, String> tbcWhatsApp;

    @FXML
    private TableColumn<Barbearia, String> tbcNome;

    @FXML
    private TableColumn<Barbearia, String> tbcEmail;

    @FXML
    private TableColumn<Barbearia, String> tbcTipoCorte;

    @FXML
    private TableColumn<Barbearia, String> tbcProfissional;

    @FXML
    private TableColumn<Barbearia, String> tbcDataHora;

    @FXML
    private TableColumn<Barbearia, String> tbcAtivo;

    public void initialize() {

        tbcClienteID.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getIdCliente()).asObject());
        tbcNome.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
        tbcEmail.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEmail()));
        tbcWhatsApp.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getWhatsapp()));
        tbcTipoCorte.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTipoCorte()));
        tbcProfissional.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getProfissional()));
        tbcDataHora.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDataHora().toString()));
        tbcAtivo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAtivo()));

        tbcNome.setCellFactory(TextFieldTableCell.forTableColumn());
        tbcEmail.setCellFactory(TextFieldTableCell.forTableColumn());
        tbcWhatsApp.setCellFactory(TextFieldTableCell.forTableColumn());
        tbcTipoCorte.setCellFactory(TextFieldTableCell.forTableColumn());
        tbcProfissional.setCellFactory(TextFieldTableCell.forTableColumn());
        tbcDataHora.setCellFactory(TextFieldTableCell.forTableColumn());

        try {
            System.out.println("Listando os cortes ativos...");
            tbView.getItems().addAll(Barbearia.getInstance().listarBarbearias());

        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR, e.getMessage());
            alert.showAndWait();
        }

    }

    public void cadastrarBarbearia() throws IOException {
        Navegador.loadJanela(Navegador.JANELA_CADASTRAR_BARBEARIA);
    }

    public void editarNome(TableColumn.CellEditEvent cellEditEvent) {
        Barbearia b = tbView.getSelectionModel().getSelectedItem();
        b.setNome(cellEditEvent.getNewValue().toString());
        Barbearia.getInstance().alterarCorte(b.getIdCliente(), cellEditEvent.getNewValue().toString(), b.getEmail(),
                b.getWhatsapp(), b.getTipoCorte(), b.getProfissional(), b.getDataHora());
    }

    public void editarEmail(TableColumn.CellEditEvent cellEditEvent) {
        Barbearia b = tbView.getSelectionModel().getSelectedItem();
        b.setEmail(cellEditEvent.getNewValue().toString());
        Barbearia.getInstance().alterarCorte(b.getIdCliente(), b.getNome(), cellEditEvent.getNewValue().toString(),
                b.getWhatsapp(), b.getTipoCorte(), b.getProfissional(), b.getDataHora());
    }

    public void editarWhatsApp(TableColumn.CellEditEvent cellEditEvent) {
        Barbearia b = tbView.getSelectionModel().getSelectedItem();
        b.setWhatsapp(cellEditEvent.getNewValue().toString());
        Barbearia.getInstance().alterarCorte(b.getIdCliente(), b.getNome(), b.getEmail(),
                cellEditEvent.getNewValue().toString(), b.getTipoCorte(), b.getProfissional(), b.getDataHora());
    }

    public void editarTipoCorte(TableColumn.CellEditEvent cellEditEvent) {
        Barbearia b = tbView.getSelectionModel().getSelectedItem();
        b.setTipoCorte(cellEditEvent.getNewValue().toString());
        Barbearia.getInstance().alterarCorte(b.getIdCliente(), b.getNome(), b.getEmail(), b.getWhatsapp(),
                cellEditEvent.getNewValue().toString(), b.getProfissional(), b.getDataHora());
    }

    public void editarProfissional(TableColumn.CellEditEvent cellEditEvent) {
        Barbearia b = tbView.getSelectionModel().getSelectedItem();
        b.setProfissional(cellEditEvent.getNewValue().toString());
        Barbearia.getInstance().alterarCorte(b.getIdCliente(), b.getNome(), b.getEmail(), b.getWhatsapp(),
                b.getTipoCorte(), cellEditEvent.getNewValue().toString(), b.getDataHora());
    }

    public void editarDataHora(TableColumn.CellEditEvent cellEditEvent) {
        Barbearia b = tbView.getSelectionModel().getSelectedItem();


        LocalDateTime dataHora;
        try {
            dataHora = LocalDateTime.parse(cellEditEvent.getNewValue().toString());
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR, "Data ou hora inválida.");
            alert.showAndWait();
            return;
        }

        Barbearia.getInstance().alterarCorte(b.getIdCliente(), b.getNome(), b.getEmail(), b.getWhatsapp(),
        b.getTipoCorte(), b.getProfissional(), dataHora);
    }

    public void trocarStatus() {
        if (tbView.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(AlertType.ERROR, "Selecione um corte para alterar o status.");
            alert.showAndWait();
            return;
        }
        if (tbView.getSelectionModel().getSelectedItem().isAtivo()) {
            System.out.println("Cancelando corte: " + tbView.getSelectionModel().getSelectedItem().getNome());
            tbView.getSelectionModel().getSelectedItem().setAtivo(false);
            Barbearia.getInstance().cancelarCorte(tbView.getSelectionModel().getSelectedItem().getIdCliente());
        } else {
            System.out.println("Restaurando corte: " + tbView.getSelectionModel().getSelectedItem().getNome());
            tbView.getSelectionModel().getSelectedItem().setAtivo(true);
            Barbearia.getInstance().restaurarCorte(tbView.getSelectionModel().getSelectedItem().getIdCliente());
        }
        tbView.getItems().clear();
        try {
            System.out.println("Listando os cortes ativos...");
            tbView.getItems().addAll(Barbearia.getInstance().listarBarbearias());
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR, e.getMessage());
            alert.showAndWait();
        }
    }

    

    public void buscaPorCliente() {
        String query = searchField.getText().toLowerCase();
        tbView.getItems().clear();
        if (query.isEmpty()) {

            tbView.getItems().addAll(Barbearia.getInstance().listarBarbearias());
        } else {

            tbView.getItems().addAll(Barbearia.getInstance().buscarCortePorNome(query));

        }
    }

    public void buscaPorProfissional() {
        String query = searchField.getText().toLowerCase();
        tbView.getItems().clear();
        if (query.isEmpty()) {

            tbView.getItems().addAll(Barbearia.getInstance().listarBarbearias());
        } else {

            tbView.getItems().addAll(Barbearia.getInstance().buscarCortePorProfissional(query));

        }
    }
}