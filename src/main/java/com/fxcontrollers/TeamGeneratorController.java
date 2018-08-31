package com.fxcontrollers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class TeamGeneratorController {

    @FXML private TextField txtfield_number_of_players;
    @FXML private TextField txtfield_number_of_teams;

    @FXML private CheckBox checkbox_divisions;

    @FXML private BorderPane borderpane_number_of_divisions;

    @FXML private ComboBox<String> combobox_number_of_divisions;

    @FXML private TextArea txtarea_team_result;

    @FXML void initialize() {
        combobox_number_of_divisions.getSelectionModel().select(0);
        checkDefaults();
    }

    @FXML private void checkbox_divisions_changed() {
        checkDefaults();
    }

    @FXML private void set_number_of_teams() {
        System.out.println("teams:" + txtfield_number_of_teams.getText());
    }

    @FXML private void set_number_of_players() {
        System.out.println("players: " + txtfield_number_of_players.getText());
    }

    @FXML private void button_generate_teams() {
        System.out.println("Generating teams");
    }

    private void checkDefaults() {
        if (checkbox_divisions.isSelected())
            borderpane_number_of_divisions.setVisible(true);
        else
            borderpane_number_of_divisions.setVisible(false);

    }

    @FXML
    public void exitMenu_click(){
        System.exit(0);
    }

    @FXML
    public void newMenu_action(){

    }

    @FXML
    public void openMenu_action(){

    }

    @FXML
    public void saveMenu_action(){

    }

    @FXML
    public void aboutMenu_action(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText(null);
        alert.setContentText("Created by: Anthony Stulens & Ben Teppers");
        //alert.setGraphic(new ImageView(getClass().getResource("/resources/icons/image.png").toString()));

        alert.showAndWait();
    }

}
