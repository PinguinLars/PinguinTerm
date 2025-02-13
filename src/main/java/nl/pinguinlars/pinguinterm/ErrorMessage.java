package nl.pinguinlars.pinguinterm;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ErrorMessage extends Application {
    @Override
    public void start(Stage primaryStage) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Launch Error");
        alert.setHeaderText("No microbit connected");
        alert.setContentText("Please connect a microbit and try again.");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}