module com.example.moulagapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;

    opens com.example.moulagapp to javafx.fxml;
    exports com.example.moulagapp;
}