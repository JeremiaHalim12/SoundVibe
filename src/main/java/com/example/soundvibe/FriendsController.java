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
import javafx.stage.Stage;
import model.Album;
import model.Artist;
import model.Song;
import model.User;
import process.usecases.album.AlbumGetById;
import process.usecases.artist.ArtistGet;
import process.usecases.artist.ArtistGetById;
import process.usecases.song.SongGet;
import process.usecases.user.UserGetById;

import java.io.IOException;
import java.util.List;

public class FriendsController extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FriendsController.class.getResource("SoundVibeLogged.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("SoundVibe");
        stage.setScene(scene);
        stage.show();
    }

    private String pageUsername;
    private String pageUseremail;
    private String pagePassword;
    @FXML
    private Label label;
    public void displayName(String username, String useremail, String password) {
        this.pageUsername = username;
        this.pageUseremail = useremail;
        this.pagePassword = password;
        label.setText(username);
    }

//    @FXML
//    private ListView list1;

    // VBOX ARTIST, SONG, DURATION, ALBUM
//    @FXML
//    private VBox vboxSongs;

    // GET FROM USECASES
//    private final Song[] songs = new SongGet().executeSongGet();

    // INITIALIZE VBOX CONTENT FROM ARRAY
    @FXML
    public void initialize() {
//        addLabelsToVBox(vboxSongs, songs);

//        String name = config.getName();
//        label.setText(name);
    }

    // ALL LABELS TO VBOX
//    private void addLabelsToVBox(VBox vbox, Object[] data) {
//        for (Object item : data) {
//            if (item instanceof Song) {
//                Song song = (Song) item;
//                Label label = new Label(song.getSongTitle());
//                label.setStyle("-fx-padding: 0 0 5 0;");
//                vbox.getChildren().add(label);
//            }
//        }
//    }

    // SEARCH
    @FXML
    TextField textFieldSearch;

    @FXML
    Button search;

    private UserGetById userGetById = new UserGetById();

    @FXML
    Label labelllll;

    @FXML
    private void handleSearchButtonClick(ActionEvent event) {
        String usernameToSearch = textFieldSearch.getText();

        if (!usernameToSearch.isEmpty()) {
            User user = userGetById.executeUserGetById(usernameToSearch);

            if (user != null) {
                // User found, do something with the user object
//                System.out.println("User found: " + user.getUserName());
                labelllll.setText(user.getUserName());
            } else {
                // User not found, handle accordingly
//                System.out.println("User not found.");
                labelllll.setText("User not found.");
            }
        } else {
            // Handle empty search field input
//            System.out.println("Please enter a username to search.");
            labelllll.setText("Please enter a username to search.");
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

    // Button SignOut
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


    public static void main(String[] args) {
        launch();
    }
}