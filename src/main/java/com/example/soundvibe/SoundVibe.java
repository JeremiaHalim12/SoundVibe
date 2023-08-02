package com.example.soundvibe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SoundVibe extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SoundVibe.class.getResource("LoginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("SoundVibe");
        stage.setScene(scene);
        stage.show();
//        test
    }

<<<<<<< Updated upstream
=======
    // ARTIST
    @FXML
    private VBox vboxArtists;

    private final Artist[] artists = {
            new Artist("Afgan"),
            new Artist("Coldplay"),
            new Artist("Yura Yunita"),
            new Artist("Tulus"),
            new Artist("Tulus"),
            new Artist("Juicy Luicy"),
            new Artist("Hivi!"),
            new Artist("Kodaline"),
            new Artist("NIKI"),
            new Artist("JVKE"),
            new Artist("Coldplay"),
            new Artist("Raim Laode"),
            new Artist("Yura Yunita"),
            new Artist("Soegi Bornean"),
            new Artist("Sal Priadi"),
    };

    // SONGS
    @FXML
    private VBox vboxSongs;

    private final Song[] songs = {
            new Song("Panah Asmara","4:34"),
            new Song("The Scientist","5:09"),
            new Song("Harus Bahagia","2:53"),
            new Song("Hati - Hati di Jalan","4:02"),
            new Song("Monokrom","3:34"),
            new Song("Lantas","3:54"),
            new Song("Kereta Kencan","4:17"),
            new Song("All I Want","5:05"),
            new Song("lowkey","2:51"),
            new Song("golden hour","3:29"),
            new Song("Yellow","4:26"),
            new Song("Komang","3:42"),
            new Song("Tenang","4:07"),
            new Song("Asmalibrasi","4:14"),
            new Song("Serta Mulia","3:09"),
    };

    // ALBUMS
    @FXML
    private VBox vboxAlbums;

    private final Album[] albums = {
            new Album("DEKADE"),
            new Album("A Rush of Blood to the Head"),
            new Album("Harus Bahagia"),
            new Album("Manusia"),
            new Album("Monokrom"),
            new Album("Sentimental"),
            new Album("Kereta Kencan"),
            new Album("In a Perfect World"),
            new Album("lowkey"),
            new Album("this is what falling in love feels like"),
            new Album("Parachutes"),
            new Album("Komang"),
            new Album("Tenang"),
            new Album("Asmalibrasi"),
            new Album("Serta Mulia"),
    };


    // DURATIONS
    @FXML
    private VBox vboxDurations;


    // INITIALIZE VBOX CONTENT FROM ARRAY
    @FXML
    public void initialize() {
        addLabelsToVBox(vboxArtists, artists);
        addLabelsToVBox(vboxSongs, songs);
        addLabelsToVBox(vboxAlbums, albums);
        addDurationLabels(vboxDurations, songs);
    }

    private void addLabelsToVBox(VBox vbox, Object[] data) {
        for (Object item : data) {
            if (item instanceof Artist) {
                Artist artist = (Artist) item;
                Label label = new Label(artist.getArtistName());
                label.setStyle("-fx-padding: 0 0 5 0;");
                vbox.getChildren().add(label);
            } else if (item instanceof Song) {
                Song song = (Song) item;
                Label label = new Label(song.getSongTitle());
                label.setStyle("-fx-padding: 0 0 5 0;");
                vbox.getChildren().add(label);
            } else if (item instanceof Album) {
                Album album = (Album) item;
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





>>>>>>> Stashed changes
    public static void main(String[] args) {
        launch();
    }
}