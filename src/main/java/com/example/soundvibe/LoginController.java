package com.example.soundvibe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    Button button1;

    public void buttonAction(ActionEvent ex) throws IOException {
        Stage loginstage = new Stage();
        FXMLLoader loader = new FXMLLoader(SoundVibe.class.getResource("SoundVibe.fxml"));
        Parent root = loader.load();
        Scene new_scene = new Scene(root, 600, 400);
        loginstage.setScene(new_scene);
        loginstage.initModality(Modality.APPLICATION_MODAL);
        loginstage.setTitle("SoundVibe");
        loginstage.show();
//        test
    }
}
