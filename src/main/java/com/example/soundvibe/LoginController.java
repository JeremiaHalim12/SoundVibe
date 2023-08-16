package com.example.soundvibe;

import DAO.UserDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.User;
import process.usecases.user.UserLogin;

import java.io.IOException;

public class LoginController {
    // BUTTON UNTUK LOGGED IN
    @FXML
    Button buttonLoggedIn;

    @FXML
    TextField textFieldUsername;
    @FXML
    TextField textFieldPassword;

    // USER DAPET DARI UserLogin usecase
    public void buttonLoggedInAction(ActionEvent event) {

        UserDAO uDAO = new UserDAO();
        ObservableList<User> uList = uDAO.showData();

        String username = textFieldUsername.getText().trim();
        String password = textFieldPassword.getText().trim();

//        UserLogin userLogin = new UserLogin();
//        User user = userLogin.execute(username, password);

        User targetUser = null;
        for (User user : uList) {
            if (user.getUserEmail().equals(username)) {
                targetUser = user;
                break;
            }
        }

        if (targetUser != null) {
            String userPassword = targetUser.getUserPassword();
            if (userPassword.equals(password)) {
                Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                currentStage.close();
                System.out.println("Logged in");
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Login Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid username or password. Please try again.");
                alert.showAndWait();
            }
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
