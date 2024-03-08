module com.example.moulagapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.moulagapp to javafx.fxml;
    exports com.example.moulagapp;
}