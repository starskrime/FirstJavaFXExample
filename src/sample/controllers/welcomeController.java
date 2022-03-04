package sample.controllers;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import sample.User;

import java.awt.event.ActionEvent;

public class welcomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView houseImage;

    @FXML
    private Button exitButton;

    @FXML
    void initialize() {
        User user = new User();
        System.out.println(user.getUserName());
        exitButton.setOnAction(event -> {
            exitButton.getScene().getWindow().hide();
            //Anchor =
            FXMLLoader regButtonXMLLoader = new FXMLLoader(getClass().getResource("../design/main.fxml"));

            Scene mainScene = null;
            try {
                mainScene = new Scene(regButtonXMLLoader.load(), 700 ,400);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage mainStage = new Stage();
            mainStage.setTitle("Test APP");
            mainStage.setScene(mainScene);
            mainStage.show();



                }
        );

    }
}
