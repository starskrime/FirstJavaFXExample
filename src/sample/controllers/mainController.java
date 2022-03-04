package sample.controllers;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import sample.Const;
import sample.DatabaseHandler;
import sample.User;
import sample.animations.Shake;

public class mainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootAnchor;

    @FXML
    private Button regbutton;

    @FXML
    private TextField loginField;

    @FXML
    private Button signinButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    void clickRegistrationButton(ActionEvent event) {

    }

    @FXML
    void clickSignInButton(ActionEvent event) {

    }

    @FXML
    void initialize() {



        signinButton.setOnAction(event -> {
            String login = loginField.getText().trim();
            String password = passwordField.getText().trim();

            if (!login.equals("") && (!password.equals("")))
                loginUser(login,password);
            else {
                //System.out.println("Error: Login and password are empty");
                new Alert(Alert.AlertType.INFORMATION, "Username and Password are empty").showAndWait();
            }

            //System.out.println("SignIn button is pressed");
        });

        regbutton.setOnAction(event -> {
            regbutton.getScene().getWindow().hide();
            //Anchor =
            FXMLLoader regButtonXMLLoader = new FXMLLoader(getClass().getResource("../design/registration.fxml"));

            Scene regScene = null;
            try {
               regScene = new Scene(regButtonXMLLoader.load(), 700 ,400);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage regStage = new Stage();
            regStage.setTitle("Registration");
            regStage.setScene(regScene);
            regStage.show();


            }
        );

    }

    private void loginUser(String login, String password) {
        DatabaseHandler loginUserDbHandler = new DatabaseHandler();
        User user = new User();
        user.setUserName(login);
        user.setPassword(password);
        ResultSet result = loginUserDbHandler.getUser(user);
        System.out.println(result);
        int counter = 0;
        try {
            while (result.next()){
                counter++;

            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(result);
        }

        if (counter >= 1){
            signinButton.getScene().getWindow().hide();
            //Anchor =
            FXMLLoader regButtonXMLLoader = new FXMLLoader(getClass().getResource("../design/welcome.fxml"));

            Scene welcomeScene = null;
            try {
                welcomeScene = new Scene(regButtonXMLLoader.load(), 700 ,400);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage regStage = new Stage();
            regStage.setTitle("Welcome");
            regStage.setScene(welcomeScene);
            regStage.show();



            //System.out.println("Sucess1!");

        }


        else {
            Shake userLoginAnim = new Shake(loginField);
            Shake userPassAnim = new Shake(passwordField);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();
        }

    }

    public void clickRegistrationButton(javafx.event.ActionEvent actionEvent) {
    }

    public void clickSignInButton(javafx.event.ActionEvent actionEvent) {
    }
}



