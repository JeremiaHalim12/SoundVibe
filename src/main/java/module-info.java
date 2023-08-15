module com.example.soundvibe {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.soundvibe to javafx.fxml;
    exports com.example.soundvibe;
}