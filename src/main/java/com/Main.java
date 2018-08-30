package main.java.com;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/main/resources/fxmls/TeamGenerator.fxml"));
        primaryStage.setTitle("Lan Party App");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
