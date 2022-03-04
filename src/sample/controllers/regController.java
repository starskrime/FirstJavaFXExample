package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.DatabaseHandler;
import sample.User;

public class regController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField countryField;

    @FXML
    private Button signupButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField firstnameField;

    @FXML
    private TextField lastnameField;

    @FXML
    private TextField usernameField;

    @FXML
    private CheckBox maleCheckbox;

    @FXML
    private CheckBox femaleCheckbox;

    @FXML
    private Button backButton;

    @FXML
    void initialize() {



        backButton.setOnAction(event -> {
            backButton.getScene().getWindow().hide();
            FXMLLoader backButtonFXMLLoader = new FXMLLoader(getClass().getResource("../design/main.fxml"));
            Scene backScene = null;

            try {
                backScene = new Scene (backButtonFXMLLoader.load() , 700 , 400);
                Stage regStage = new Stage();
                regStage.setScene(backScene);
                //regStage.setTitle(Test);
                regStage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        signupButton.setOnAction(event -> {

            signUpNewUser();
            



        });
    }

    private void signUpNewUser() {
        DatabaseHandler signUpNewUserDbHandler = new DatabaseHandler();

        String firstName = firstnameField.getText();
        String lasttName = lastnameField.getText();
        String userName = usernameField.getText();
        String password = passwordField.getText();
        String country = countryField.getText();
        String gender = "";
        if (maleCheckbox.isSelected())
            gender = "Male";
        else {
            if (femaleCheckbox.isSelected())
                gender = "Female";
        }

        User user = new User(firstName,lasttName,userName,password,country,gender);

        signUpNewUserDbHandler.signUpUser(user);
        new Alert(Alert.AlertType.INFORMATION, "User was added to Database").showAndWait();

    }
}
