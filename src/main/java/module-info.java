module org.example.navalbatlle {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.navalbattle to javafx.fxml;
    opens org.example.navalbattle.controller to javafx.fxml;
    exports org.example.navalbattle;
}