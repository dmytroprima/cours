package com.main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InfoController {

    @FXML
    private Button okButton;

    @FXML
    void initialize() {
        okButton.setOnAction(event ->{
            Stage stage1 = (Stage) okButton.getScene().getWindow();
            stage1.close();
        });
    }
}
