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
import process.usecases.user.UserSignUp;
//import process.usecases.user.UserLogin;

import java.io.IOException;

public class SignUpController {
    @FXML
    Button buttonSignUp;

    @FXML
    Button cancel;

    @FXML
    TextField textFieldUsername;

    @FXML
    TextField textFieldEmail;

    @FXML
    TextField textFieldPassword;

    public void buttonCancelAction(ActionEvent event) {
        try {
            // Load LoginPage.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SoundVibe.fxml"));
            Parent loginPageParent = loader.load();

            // Access the current stage
            Stage currentStage = (Stage) cancel.getScene().getWindow();

            // Set the new scene on the current stage
            currentStage.setScene(new Scene(loginPageParent));
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exception that might occur during the loading of the LoginPage.fxml
        }
    }

    public void buttonSignUpAction(ActionEvent event) {
        String username = textFieldUsername.getText().trim();
        String email = textFieldEmail.getText().trim();
        String password = textFieldPassword.getText().trim();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("SignUp Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        UserSignUp userSignUp = new UserSignUp();

        try {
            userSignUp.executeUserSignUp(username, email, password);

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Sign Up Successful");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Press OK button to Login");
            successAlert.showAndWait();

            // Load LoginPage.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
            Parent loginPageParent = loader.load();

            // Access the current stage
            Stage currentStage = (Stage) buttonSignUp.getScene().getWindow();

            // Set the new scene on the current stage
            currentStage.setScene(new Scene(loginPageParent));
        } catch (IOException e) {
            e.printStackTrace();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Sign Up Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Failed to create user. Please try again.");
            errorAlert.showAndWait();
        }
    }

    @FXML
    private void initialize() {
        buttonSignUp.setDisable(true);
        textFieldUsername.textProperty().addListener((observable, oldValue, newValue) -> {
            buttonSignUp.setDisable(newValue.trim().isEmpty());
        });
    }
}
