package com.example.soundvibe;

import DAO.UserDAO;
import javafx.collections.ObservableList;
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
        UserDAO uDAO = new UserDAO();
        ObservableList<User> uList = uDAO.showData();

        System.out.println(uList);



        String username = textFieldUsername.getText().trim();
        String password = textFieldPassword.getText().trim();

        String username1 = null;
        for (User user : uList) {
            if (user.getUserEmail().equals(username)) {
                username1 = user.getUserName();
                System.out.println(username1);
            }
        }

//        ubah jadi user signUp atau userCreate
        UserLogin userLogin = new UserLogin();
        User user = userLogin.execute(username, password);

        if (user != null) {
//            Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
//            currentStage.close();

            SoundVibeConfig config = new SoundVibeConfig(username1); // Replace with the actual name
            SoundVibeLogged.setConfig(config);

            // Load LoginPage.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SoundVibeLogged.fxml"));
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
