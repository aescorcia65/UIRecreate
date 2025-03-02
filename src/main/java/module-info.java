module org.example.uirecreate {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.uirecreate to javafx.fxml;
    exports org.example.uirecreate;
}