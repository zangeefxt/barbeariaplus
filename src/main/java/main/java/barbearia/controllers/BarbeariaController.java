package main.java.barbearia.Controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import main.java.barbearia.Navegador;
import main.java.barbearia.Models.Barbearia;

public class BarbeariaController {

    @FXML
    private TextField nomeBarbearia;
    @FXML
    private TextField emailBarbearia;
    @FXML
    private TextField whatsappBarbearia;
    @FXML
    private TextField tipoCorteBarbearia;
    @FXML
    private TextField profissionalBarbearia;
    @FXML
    private DatePicker dataBarbearia;
    @FXML
    private TextField horaBarbearia;

    @FXML
    private void cadastrarBarbearia() {
        String nome = nomeBarbearia.getText();
        String email = emailBarbearia.getText();
        String whatsapp = whatsappBarbearia.getText();
        String tipoCorte = tipoCorteBarbearia.getText();
        String profissional = profissionalBarbearia.getText();
        LocalDate data = dataBarbearia.getValue();
        String hora = horaBarbearia.getText();
        LocalDateTime dataHora = null;

        if (data != null && !hora.isEmpty()) {
            String[] partesHora = hora.split(":");
            if (partesHora.length == 2) {
                int horas = Integer.parseInt(partesHora[0]);
                int minutos = Integer.parseInt(partesHora[1]);
                dataHora = LocalDateTime.of(data, LocalDateTime.of(0, 1, 1, horas, minutos).toLocalTime());
            }
        }

        if (nome.isEmpty() || email.isEmpty() || whatsapp.isEmpty() || tipoCorte.isEmpty() || profissional.isEmpty()
                || data == null || hora == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, preencha todos os campos.");
            alert.showAndWait();
            return;
        }

        if (dataHora == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Data ou hora inválida.");
            alert.showAndWait();
            return;
        }

        Barbearia.getInstance().agendarCorte(nome, email, whatsapp, tipoCorte, profissional, dataHora);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cadastro");
        alert.setHeaderText(null);
        alert.setContentText("Barbearia " + nome + " cadastrada com sucesso!");
        alert.showAndWait();

        this.voltarTela();
    }

    @FXML
    private void voltarTela() {
        Navegador.loadJanela(Navegador.JANELA_HOME);
    }
}
