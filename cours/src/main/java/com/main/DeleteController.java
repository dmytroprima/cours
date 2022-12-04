package com.main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.SQLException;
import static com.main.Main.worker;

public class DeleteController{

    @FXML
    private Button deleteButton;

    @FXML
    private TextField giftName;

    @FXML
    private Button okButton;

    @FXML
    void initialize() throws SQLException{
        deleteButton.setOnAction(event -> {
            String query = "delete from gifts where name = '"+giftName.getText() +"'";
            worker.executeInstall(query);
        });
        okButton.setOnAction(event ->{
            Stage stage1 = (Stage) okButton.getScene().getWindow();
            stage1.close();
        });
    }
}