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

public class ArtistLoggedController {
    private String username;

    public void setUsername(String name) {
        username = name;
    }

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

    @FXML
    private Label label;


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

    // Button SignOut
    @FXML
    Button SignOut;

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


    // Button Home (Go to Home Page)
    @FXML
    Button homeButton;

    @FXML
    private void homeButtonAction() {
        try {
            // Load SoundVibe.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SoundVibe.fxml"));
            Parent loginPageParent = loader.load();

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LibraryPage.fxml"));
            Parent loginPageParent = loader.load();

            // Access the current stage
            Stage currentStage = (Stage) libraryButton.getScene().getWindow();

            // Set the new scene on the current stage
            currentStage.setScene(new Scene(loginPageParent));
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exception that might occur during the loading of the LoginPage.fxml
        }
    }

    // Button Liked Song (Go to Liked Song Page)
    @FXML
    Button likedSongButton;

    @FXML
    private void likedSongButtonAction() {
        try {
            // Load LikedSongPage.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LikedSongPage.fxml"));
            Parent loginPageParent = loader.load();

            // Access the current stage
            Stage currentStage = (Stage) likedSongButton.getScene().getWindow();

            // Set the new scene on the current stage
            currentStage.setScene(new Scene(loginPageParent));
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exception that might occur during the loading of the LoginPage.fxml
        }
    }

    // INITIALIZE VBOX CONTENT FROM ARRAY
    @FXML
    public void initialize() {

        addLabelsToVBox(vboxSongs, songs);
        addLabelsToVBox(vboxAlbums, albums);
        addDurationLabels(vboxDurations, songs);

        label.setText(this.username);
    }


}
