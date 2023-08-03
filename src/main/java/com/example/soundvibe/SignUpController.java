package com.example.soundvibe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;
import process.usecases.user.UserLogin;

import java.io.IOException;

public class SignUpController {
    @FXML
    Button buttonLoggedIn;

    @FXML
    TextField textFieldUsername;
    @FXML
    TextField textFieldPassword;

    public void buttonLoggedInAction(ActionEvent event) throws IOException {
        String username = textFieldUsername.getText().trim();
        String password = textFieldPassword.getText().trim();

        UserLogin userLogin = new UserLogin();
        User user = userLogin.execute(username, password);

        if (user != null) {
//            Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
//            currentStage.close();

            // Load LoginPage.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SoundVibe.fxml"));
            Parent loginPageParent = loader.load();

            // Access the current stage
            Stage currentStage = (Stage) buttonLoggedIn.getScene().getWindow();

            // Set the new scene on the current stage
            currentStage.setScene(new Scene(loginPageParent));
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid username or password. Please try again.");
            alert.showAndWait();
        }
    }

    @FXML
    private void initialize() {
        buttonLoggedIn.setDisable(true);
        textFieldUsername.textProperty().addListener((observable, oldValue, newValue) -> {
            buttonLoggedIn.setDisable(newValue.trim().isEmpty());
        });
    }
}
