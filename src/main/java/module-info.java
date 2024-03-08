module com.example.moulagapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.moulagapp to javafx.fxml;
    exports com.example.moulagapp;
}