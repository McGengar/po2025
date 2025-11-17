module org.example.demo1todel {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.demo1todel to javafx.fxml;
    exports org.example.demo1todel;
}