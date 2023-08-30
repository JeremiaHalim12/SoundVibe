package com.example.soundvibe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Album;
import model.Song;
import process.usecases.album.AlbumGet;
import process.usecases.song.SongGet;

import java.io.IOException;

public class LikedSongLoggedController {

    @FXML
    private VBox vboxSongs;

    private final Song[] songs = new SongGet().executeSongGet();

    // Album
    @FXML
    private VBox vboxAlbums;

    private final Album[] albums = new AlbumGet().executeAlbumGet();

    // DURATIONS
    @FXML
    private VBox vboxDurations;

    // INITIALIZE VBOX CONTENT FROM ARRAY
    @FXML
    public void initialize() {
        addLabelsToVBox(vboxSongs, songs);
        addLabelsToVBox(vboxAlbums, albums);
        addDurationLabels(vboxDurations, songs);
    }

    // SHOW LOGGED NAME
    private String pageUsername;
    private String pageUseremail;
    private String pagePassword;
    @FXML
    private Label label;
    public void displayName(String username, String useremail, String password) {
        label.setText(username);
        this.pageUsername = username;
        this.pageUseremail = useremail;
        this.pagePassword = password;
    }

    private void addLabelsToVBox(VBox vbox, Object[] data) {
        for (Object item : data) {
            if (item instanceof Song song) {
                Label label = new Label(song.getSongTitle());
                label.setStyle("-fx-padding: 0 0 5 0;");
                vbox.getChildren().add(label);
            } else if (item instanceof Album album) {
                Label label = new Label(album.getAlbumName());
                label.setStyle("-fx-padding: 0 0 5 0;");
                vbox.getChildren().add(label);
            }
        }
    }

    private void addDurationLabels(VBox vbox, Song[] songs) {
        for (Song song : songs) {
            Label label = new Label(song.getSongDuration());
            label.setStyle("-fx-padding: 0 0 5 0;");
            vbox.getChildren().add(label);
        }
    }


    // Button SignIn
    @FXML
    Button SignIn;
    @FXML
    public void signInButtonAction(ActionEvent event) throws IOException {
        Stage loginStage = new Stage();
        FXMLLoader loader = new FXMLLoader(SoundVibe.class.getResource("LoginPage.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root, 600, 400);
        loginStage.setScene(newScene);
        loginStage.initModality(Modality.APPLICATION_MODAL);
        loginStage.setTitle("Login Page");
        loginStage.show();
    }

    // Button SignUp
    @FXML
    Button SignUp;

    @FXML
    private void signupButtonAction() {
        try {
            // Load LoginPage.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUpPage.fxml"));
            Parent loginPageParent = loader.load();

            // Access the current stage
            Stage currentStage = (Stage) SignUp.getScene().getWindow();

            // Set the new scene on the current stage
            currentStage.setScene(new Scene(loginPageParent));
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exception that might occur during the loading of the LoginPage.fxml
        }
    }

    // Button Home (Go to Home Page)
    @FXML
    Button homeButton;

    @FXML
    private void homeButtonAction() {
        try {
            // Load SoundVibe.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SoundVibeLogged.fxml"));
            Parent loginPageParent = loader.load();

            SoundVibeLogged soundVibeLogged = loader.getController();
            soundVibeLogged.displayName(pageUsername, pageUseremail, pagePassword);

            // Access the current stage
            Stage currentStage = (Stage) homeButton.getScene().getWindow();

            // Set the new scene on the current stage
            currentStage.setScene(new Scene(loginPageParent));
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exception that might occur during the loading of the LoginPage.fxml
        }
    }

    // Button Library (Go to Library Page)
    @FXML
    Button libraryButton;

    @FXML
    private void libraryButtonAction() {
        try {
            // Load LibraryPage.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LibraryPageLogged.fxml"));
            Parent loginPageParent = loader.load();

            LibraryLoggedController libraryLoggedController = loader.getController();
            libraryLoggedController.displayName(pageUsername, pageUseremail, pagePassword);

            // Access the current stage
            Stage currentStage = (Stage) libraryButton.getScene().getWindow();

            // Set the new scene on the current stage
            currentStage.setScene(new Scene(loginPageParent));
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exception that might occur during the loading of the LoginPage.fxml
        }
    }

    // Button Artist (Go to Artist Page)
    @FXML
    Button artistBottom;

    @FXML
    private void artistButtonAction() {
        try {
            // Load ArtistPage.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ArtistPageLogged.fxml"));
            Parent loginPageParent = loader.load();

            ArtistLoggedController artistLoggedController = loader.getController();
            artistLoggedController.displayName(pageUsername, pageUseremail, pagePassword);

            // Access the current stage
            Stage currentStage = (Stage) artistBottom.getScene().getWindow();

            // Set the new scene on the current stage
            currentStage.setScene(new Scene(loginPageParent));
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exception that might occur during the loading of the LoginPage.fxml
        }
    }

    @FXML
    Button Profile;

    @FXML
    private void profileButtonAction() {
//        System.out.println(config.getName());
//        System.out.println(config.getEmail());
//
//        SoundVibeConfig config2 = new SoundVibeConfig(config.getName(),config.getEmail());
//        SoundVibeLogged.setConfig(config2);
        try {
            // Load SoundVibe.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfilePage.fxml"));
            Parent loginPageParent = loader.load();

            // display name ke profile
            ProfileController profileController = loader.getController();
            profileController.displayName(pageUsername, pageUseremail, pagePassword);

            // Access the current stage
            Stage currentStage = (Stage) Profile.getScene().getWindow();

            // Set the new scene on the current stage
            currentStage.setScene(new Scene(loginPageParent));

        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exception that might occur during the loading of the SoundVibe.fxml
        }
    }

}
