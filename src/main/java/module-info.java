module com.example.soundvibe {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.soundvibe to javafx.fxml;
    exports com.example.soundvibe;
}