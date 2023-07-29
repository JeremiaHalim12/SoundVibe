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
        stage.setTitle("Login to SoundVibe");
        stage.setScene(scene);
        stage.show();
//        test
    }

    public static void main(String[] args) {
        launch();
    }
}