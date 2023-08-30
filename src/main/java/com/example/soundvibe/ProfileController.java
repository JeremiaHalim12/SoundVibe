package com.example.soundvibe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;
import process.repositories.UserRepository;

import java.io.IOException;

public class ProfileController {
//    private static SoundVibeConfig config;
//
//    public static void setConfig(SoundVibeConfig config) {
//        ProfileController.config = config;
//    }

    @FXML
    Button SignOut;

    @FXML
    Button back;

    @FXML
    TextField textFieldUsername;

    @FXML
    TextField textFieldEmail;

    @FXML
    TextField textFieldPassword;

    @FXML
    Button editUsername;

    @FXML
    Button editEmail;

    @FXML
    Button editPassword;

    private String pageUsername;
    private String pageUseremail;
    private String pagePassword;
    @FXML
    private Label label;
    public void displayName(String username, String useremail, String password) {
        this.pageUsername = username;
        this.pageUseremail = useremail;
        this.pagePassword = password;
//        label.setText(username);

        textFieldUsername.setText(username);
        textFieldEmail.setText(useremail);
        textFieldPassword.setText(password);
    }

    public void buttonBackAction(ActionEvent event) {
        try {
            // Load LoginPage.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SoundVibeLogged.fxml"));
            Parent loginPageParent = loader.load();

            // display name ke soundvibe logged lagi
            SoundVibeLogged soundVibeLogged = loader.getController();
            soundVibeLogged.displayName(pageUsername, pageUseremail, pagePassword);

            // Access the current stage
            Stage currentStage = (Stage) back.getScene().getWindow();

            // Set the new scene on the current stage
            currentStage.setScene(new Scene(loginPageParent));
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exception that might occur during the loading of the LoginPage.fxml
        }
    }

//    user update username
    public void buttonEditUsernameAction(ActionEvent event) {
        String username = textFieldUsername.getText().trim();
        String email = textFieldEmail.getText().trim();
        String password = textFieldPassword.getText().trim();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edit Profile Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        UserRepository uRepo = new UserRepository();
        User updateUsername = uRepo.updateUsername(username, email);

        try {
            uRepo.updateUsername(username, email);

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Change Username Successful");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Press OK to go to home page");
            successAlert.showAndWait();

            // Load LoginPage.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SoundVibeLogged.fxml"));
            Parent loginPageParent = loader.load();

            SoundVibeLogged soundVibeLogged = loader.getController();
            soundVibeLogged.displayName(updateUsername.getUserName(), updateUsername.getUserEmail(), updateUsername.getUserPassword());

            // Access the current stage
            Stage currentStage = (Stage) editUsername.getScene().getWindow();

            // Set the new scene on the current stage
            currentStage.setScene(new Scene(loginPageParent));
        } catch (IOException e) {
            e.printStackTrace();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Edit Profile Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Failed to edit. Please try again.");
            errorAlert.showAndWait();
        }
    }

//    user update email
    public void buttonEditUserEmailAction(ActionEvent event) {
        String username = textFieldUsername.getText().trim();
        String email = textFieldEmail.getText().trim();
        String password = textFieldPassword.getText().trim();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edit Profile Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        UserRepository uRepo = new UserRepository();
        User updateEmail = uRepo.updateUserEmail(username, email);

        try {
            uRepo.updateUserEmail(username, email);

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Change Email Successful");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Press OK to go to home page");
            successAlert.showAndWait();

            // Load LoginPage.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SoundVibeLogged.fxml"));
            Parent loginPageParent = loader.load();

            SoundVibeLogged soundVibeLogged = loader.getController();
            soundVibeLogged.displayName(updateEmail.getUserName(), updateEmail.getUserEmail(), updateEmail.getUserPassword());

            // Access the current stage
            Stage currentStage = (Stage) editEmail.getScene().getWindow();

            // Set the new scene on the current stage
            currentStage.setScene(new Scene(loginPageParent));
        } catch (IOException e) {
            e.printStackTrace();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Edit Profile Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Failed to edit. Please try again.");
            errorAlert.showAndWait();
        }
    }

    //    user update password
    public void buttonEditPasswordAction(ActionEvent event) {
        String username = textFieldUsername.getText().trim();
        String email = textFieldEmail.getText().trim();
        String password = textFieldPassword.getText().trim();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edit Profile Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        UserRepository uRepo = new UserRepository();
        User updatePassword = uRepo.updateUserPassword(username, password);

        try {
            uRepo.updateUserPassword(username, password);

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Change Password Successful");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Press OK to go to home page");
            successAlert.showAndWait();

            // Load LoginPage.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SoundVibeLogged.fxml"));
            Parent loginPageParent = loader.load();

            SoundVibeLogged soundVibeLogged = loader.getController();
            soundVibeLogged.displayName(updatePassword.getUserName(), updatePassword.getUserEmail(), updatePassword.getUserPassword());

            // Access the current stage
            Stage currentStage = (Stage) editPassword.getScene().getWindow();

            // Set the new scene on the current stage
            currentStage.setScene(new Scene(loginPageParent));
        } catch (IOException e) {
            e.printStackTrace();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Edit Profile Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Failed to edit. Please try again.");
            errorAlert.showAndWait();
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

//        String name = config.getName();
//        String email = config.getEmail();
//
//        textFieldUsername.setText(name);
//        textFieldEmail.setText(email);
    }
}
