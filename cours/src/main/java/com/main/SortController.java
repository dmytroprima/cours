package com.main;

import com.candy.Candy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.sql.ResultSet;
import java.sql.SQLException;
import static com.main.Main.worker;

public class SortController{

    @FXML
    private Button ABCSort;

    @FXML
    private TableColumn<Candy, String> candyName;

    @FXML
    private TableColumn<Candy, Integer> candySugar;

    @FXML
    private TextField giftName;

    @FXML
    private Button okButton;

    @FXML
    private Button sugarSort;

    @FXML
    private TableView<Candy> table;

    ObservableList<Candy> list = FXCollections.observableArrayList();

    @FXML
    void initialize() throws SQLException {
        ABCSort.setOnAction(event -> {
            try {
                getGift("ABC");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            candyName.setCellValueFactory(new PropertyValueFactory<Candy, String>("name"));
            candySugar.setCellValueFactory(new PropertyValueFactory<Candy, Integer>("sugarContent"));
            table.setItems(list);
        });
        sugarSort.setOnAction(event -> {
            try {
                getGift("sugar");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            candyName.setCellValueFactory(new PropertyValueFactory<Candy, String>("name"));
            candySugar.setCellValueFactory(new PropertyValueFactory<Candy, Integer>("sugarContent"));
            table.setItems(list);
        });
        okButton.setOnAction(event ->{
            Stage stage1 = (Stage) okButton.getScene().getWindow();
            stage1.close();
        });
    }

    private void getGift(String param) throws SQLException {
        list.clear();
        ResultSet res = null;
        if(param.equals("ABC")){
            String query = "select  * from mydbtest.gifts inner join mydbtest.candies on gifts.candy = candies.Name where gifts.name = '" + giftName.getText() + "' order by gifts.candy asc";
            res = worker.executeGet(query);
        }
        else if(param.equals("sugar")){
            String query = "select  * from mydbtest.gifts inner join mydbtest.candies on gifts.candy = candies.Name where gifts.name = '" + giftName.getText() +"' order by candies.sugar asc";
            res = worker.executeGet(query);
        }
        while (res.next()){
            list.add(new Candy(res.getString(2),0,res.getInt(6),0));
        }
    }
}
