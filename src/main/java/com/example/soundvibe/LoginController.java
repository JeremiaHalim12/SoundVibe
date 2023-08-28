package com.example.soundvibe;

//import DAO.UserDAO;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.User;
import process.repositories.UserRepository;
import process.usecases.user.UserLogin;
import org.controlsfx.control.Notifications;
import javafx.util.Duration;



import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class LoginController {
    // BUTTON UNTUK LOGGED IN
    @FXML
    Button buttonLoggedIn;

    @FXML
    Button cancel;

    @FXML
    TextField textFieldUsername;
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


    // USER DAPET DARI UserLogin usecase
    public void buttonLoggedInAction(ActionEvent event) {
        String username = textFieldUsername.getText().trim();
        String password = textFieldPassword.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in both username and password.");
            alert.showAndWait();
            return;
        }

        UserRepository uRepo = new UserRepository();
        User user = uRepo.signIn(username, password);


        if (user != null) {
            SoundVibeConfig config = new SoundVibeConfig(user.getUserName(),user.getUserEmail());
            SoundVibeLogged.setConfig(config);

            try {
                // Load SoundVibeLogged.fxml
                FXMLLoader loader = new FXMLLoader(getClass().getResource("SoundVibeLogged.fxml"));
                Parent soundVibeLoggedParent = loader.load();

                // Access the current stage
                Stage currentStage = (Stage) buttonLoggedIn.getScene().getWindow();

                // Create a new stage for the logged-in scene
                Stage loggedInStage = new Stage();
                loggedInStage.setScene(new Scene(soundVibeLoggedParent));

                // Close the current stage and show the new logged-in stage
                Platform.runLater(() -> {
                    currentStage.close();
                    loggedInStage.show();
                });

                Platform.runLater(() -> {
                    Notifications.create()
                            .title("Login Success")
                            .text("Redirecting to the main page")
                            .darkStyle()
                            .position(Pos.TOP_RIGHT)
                            .hideAfter(Duration.seconds(6))
                            .showInformation();
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
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
