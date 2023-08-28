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
import process.repositories.UserRepository;

import java.io.IOException;

public class ProfileController {
    private static SoundVibeConfig config;

    public static void setConfig(SoundVibeConfig config) {
        ProfileController.config = config;
    }

    @FXML
    Button SignOut;

    @FXML
    Button back;

    @FXML
    TextField textFieldUsername;

    @FXML
    TextField textFieldEmail;

    public void buttonBackAction(ActionEvent event) {
        try {
            // Load LoginPage.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SoundVibeLogged.fxml"));
            Parent loginPageParent = loader.load();

            // Access the current stage
            Stage currentStage = (Stage) back.getScene().getWindow();

            // Set the new scene on the current stage
            currentStage.setScene(new Scene(loginPageParent));
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exception that might occur during the loading of the LoginPage.fxml
        }
    }

    @FXML
    private void signoutButtonAction() {
        try {
            // Load SoundVibe.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SoundVibe.fxml"));
            Parent loginPageParent = loader.load();

            // Access the current stage
            Stage currentStage = (Stage) SignOut.getScene().getWindow();

            // Set the new scene on the current stage
            currentStage.setScene(new Scene(loginPageParent));

        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exception that might occur during the loading of the SoundVibe.fxml
        }
    }

//    public void buttonSignUpAction(ActionEvent event) {
//        String username = textFieldUsername.getText().trim();
//        String email = textFieldEmail.getText().trim();
//        String password = textFieldPassword.getText().trim();
//
//        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("SignUp Error");
//            alert.setHeaderText(null);
//            alert.setContentText("Please fill in all fields.");
//            alert.showAndWait();
//            return;
//        }
//
//        UserRepository uRepo = new UserRepository();
//
//        try {
//            uRepo.addUser(username, email, password);
//
//            SoundVibeConfig config = new SoundVibeConfig(username);
//            SoundVibeLogged.setConfig(config);
//
//            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
//            successAlert.setTitle("Sign Up Successful");
//            successAlert.setHeaderText(null);
//            successAlert.setContentText("Press OK button to Login");
//            successAlert.showAndWait();
//
//            // Load LoginPage.fxml
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
//            Parent loginPageParent = loader.load();
//
//            // Access the current stage
//            Stage currentStage = (Stage) buttonSignUp.getScene().getWindow();
//
//            // Set the new scene on the current stage
//            currentStage.setScene(new Scene(loginPageParent));
//        } catch (IOException e) {
//            e.printStackTrace();
//            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
//            errorAlert.setTitle("Sign Up Error");
//            errorAlert.setHeaderText(null);
//            errorAlert.setContentText("Failed to create user. Please try again.");
//            errorAlert.showAndWait();
//        }
//    }

    @FXML
    private void initialize() {
//        SignOut.setDisable(true);
        textFieldUsername.textProperty().addListener((observable, oldValue, newValue) -> {
            SignOut.setDisable(newValue.trim().isEmpty());
        });

        String name = config.getName();
        String email = config.getEmail();

        textFieldUsername.setText(name);
        textFieldEmail.setText(email);
    }
}
