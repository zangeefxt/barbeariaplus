module main.java.barbearia {
    requires javafx.controls;
    requires javafx.fxml;
    requires io.github.cdimascio.dotenv.java;
    requires java.sql;

    opens main.java.barbearia.Controllers to javafx.fxml;
    exports main.java.barbearia;
}
