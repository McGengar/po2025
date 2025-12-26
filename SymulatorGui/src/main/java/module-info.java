module org.example.symulatorgui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.logging;


    opens org.example.symulatorgui to javafx.fxml;
    exports org.example.symulatorgui;
}