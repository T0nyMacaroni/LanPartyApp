package com.uicomponents;

import com.Settings;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Popup extends Alert {

    private Stage parentStage = Settings.primaryStage;

    public Popup(AlertType type) {
        super(type);
    }

    public void showBox() {
        super.show();
        setX(parentStage.getX() + (parentStage.getWidth()/2 - getWidth()/2));
        setY(parentStage.getY() + (parentStage.getHeight()/2 - getHeight()/2));
    }
}
