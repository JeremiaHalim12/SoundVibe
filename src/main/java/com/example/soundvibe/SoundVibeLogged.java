package com.example.soundvibe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Album;
import model.Artist;
import model.Song;
import process.usecases.album.AlbumGetById;
import process.usecases.artist.ArtistGet;
import process.usecases.artist.ArtistGetById;
import process.usecases.song.SongGet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class SoundVibeLogged extends Application {
    private static SoundVibeConfig config;

    public static void setConfig(SoundVibeConfig config) {
        SoundVibeLogged.config = config;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SoundVibeLogged.class.getResource("SoundVibeLogged.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("SoundVibe");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private Label label;

    @FXML
    private ListView list1;

    // VBOX ARTIST, SONG, DURATION, ALBUM
    @FXML
    private VBox vboxArtists, vboxSongs, vboxDurations, vboxAlbums;

    // GET FROM USECASES
    private final Artist[] artists = new ArtistGet().exexuteArtistGet();
    private final Song[] songs = new SongGet().executeSongGet();
    private final AlbumGetById albumGetter = new AlbumGetById();
    private final ArtistGetById artistGetter = new ArtistGetById();

    // INITIALIZE VBOX CONTENT FROM ARRAY
    @FXML
    public void initialize() {
        addLabelsToVBox(vboxArtists, artists);
        addArtistLabels(vboxArtists, songs);
        addLabelsToVBox(vboxSongs, songs);
        addAlbumLabels(vboxAlbums, songs);
        addDurationLabels(vboxDurations, songs);

        String name = config.getName();
        label.setText(name);
    }

    // ALL LABELS TO VBOX
    private void addLabelsToVBox(VBox vbox, Object[] data) {
        for (Object item : data) {
            if (item instanceof Song) {
                Song song = (Song) item;
                Label label = new Label(song.getSongTitle());
                label.setStyle("-fx-padding: 0 0 5 0;");
                vbox.getChildren().add(label);
            }
        }
    }

    private void addArtistLabels(VBox vbox, Song[] songs) {
        for (Song song : songs) {
            Album album = albumGetter.executeAlbumGetById(song.getSongAlbum());
            if (album != null) {
                Artist artist = artistGetter.executeArtistGetById(album.getAlbumArtist());
                if (artist != null) {
                    Label label = new Label(artist.getArtistName());
                    label.setStyle("-fx-padding: 0 0 5 0;");
                    vbox.getChildren().add(label);
                }
            }
        }
    }

    private void addAlbumLabels(VBox vbox, Song[] songs) {
        for (Song song : songs) {
            Album album = albumGetter.executeAlbumGetById(song.getSongAlbum());
            if (album != null) {
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

    // Button Artist (Go to Artist Page)
    @FXML
    Button artistBottom;

    @FXML
    private void artistButtonAction() {
        try {
            // Load ArtistPage.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ArtistPage.fxml"));
            Parent loginPageParent = loader.load();

            // Access the current stage
            Stage currentStage = (Stage) artistBottom.getScene().getWindow();

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


    public static void main(String[] args) {
        launch();
    }
}