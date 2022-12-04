package com.main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button checkButton;

    @FXML
    private Button createButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button infoButton;

    @FXML
    private Button sortButton;

    @FXML
    void initialize() {

        exitButton.setOnAction(event ->{
            System.exit(0);
        });

        infoButton.setOnAction(event ->{
            openWindow("/info.fxml");
        });

        createButton.setOnAction(event->{
            openWindow("/create.fxml");
        });

        checkButton.setOnAction(event ->{
            openWindow("/check.fxml");
        });

        deleteButton.setOnAction(event ->{
            openWindow("/delete.fxml");
        });

        sortButton.setOnAction(event -> {
            openWindow("/sort.fxml");
        });
    }
    private void openWindow(String fxml){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxml));
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}

