package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage loginPage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("design/main.fxml"));
        loginPage.setTitle("Test APP");
        Scene mainScene = new Scene(root, 700, 400);
        loginPage.setScene(mainScene);
        loginPage.show();
        //primaryStage.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
