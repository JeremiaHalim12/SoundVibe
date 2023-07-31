package com.example.soundvibe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController {
    // BUTTON UNTUK LOGGED IN
    @FXML
    Button buttonLoggedIn;

    @FXML
    TextField textFieldUsername;
    @FXML
    TextField textFieldPassword;

    // ACTION UNTUK CLOSE STAGE DOANG
    // BISA DIGANTI LAIN
//    public void buttonLoggedInAction(ActionEvent event) throws IOException {
//        Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
//        currentStage.close();
//    }

    // ACTION UNTUK CLOSE KETIKA USERNAME DAN PASSWORD BENAR
    public void buttonLoggedInAction(ActionEvent event) {
        String username = textFieldUsername.getText().trim();
        String password = textFieldPassword.getText().trim();
        // GANTI USERNAME DAN PASSWORD DISINI
        if (username.equals("2072001") && password.equals("2072001")) {
            Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            currentStage.close();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid username or password. Please try again.");
            alert.showAndWait();
        }
    }

    // initialize untuk disable buttonLoggedIn dan listener
    @FXML
    private void initialize() {
        buttonLoggedIn.setDisable(true);
        textFieldUsername.textProperty().addListener((observable, oldValue, newValue) -> {
            buttonLoggedIn.setDisable(newValue.trim().isEmpty());
        });
    }

}
