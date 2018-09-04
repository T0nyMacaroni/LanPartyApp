package com;

import com.io.Writer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxmls/MainFrame.fxml"));
        primaryStage.setTitle("Lan Party App");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        Settings.primaryStage = primaryStage;
        
        primaryStage.setOnHidden(e -> {
        	System.out.println("Closing..");
        	Writer.processData();
        });
    }

    public static void main(String[] args) {
    	Initializer.init();
        launch(args);
    }
}
