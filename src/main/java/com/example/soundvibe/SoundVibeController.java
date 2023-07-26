package com.example.soundvibe;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SoundVibeController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}