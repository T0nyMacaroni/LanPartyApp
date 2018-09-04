package com.fxcontrollers;

import com.entities.Team;
import com.uicomponents.Popup;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TeamGeneratorController {

	public static Stage parentStage;
	
    @FXML private TextField txtfield_number_of_players;

    @FXML private TextField txtfield_number_of_teams;

    @FXML private CheckBox checkbox_divisions;

    @FXML private BorderPane borderpane_number_of_divisions;

    @FXML private ComboBox<String> combobox_number_of_divisions;

    @FXML private TextArea txtarea_team_result;

    private List<Team> Teams = new ArrayList<>();

    @FXML void initialize() {
        combobox_number_of_divisions.getSelectionModel().select(0);
        checkDefaults();
    }

    @FXML private void checkbox_divisions_changed() {
        checkDefaults();
    }


    @FXML private void button_selectPlayers_action() {

    }

    @FXML private void button_generate_teams() {
        //test
        System.out.println("Generating teams");

        int numberOfPlayers;
        int numberOfTeams;

        try{
            numberOfPlayers = Integer.parseInt(txtfield_number_of_players.getText());
            numberOfTeams = Integer.parseInt(txtfield_number_of_teams.getText());

            if(numberOfPlayers % numberOfTeams == 0){
                //
            } else {
                Popup alert = new Popup(Alert.AlertType.WARNING);
                alert.setTitle("Warning!");
                alert.setHeaderText("Teams aren't even");
                alert.setContentText("Please adjust number of players according to even teams");
                alert.showBox();

            }
        } catch (Exception e){
            Popup alert = new Popup(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("");
            alert.setContentText("Please enter a numeric value");
            alert.showBox();
        }
    }

    private void checkDefaults() {
        if (checkbox_divisions.isSelected())
            borderpane_number_of_divisions.setVisible(true);
        else
            borderpane_number_of_divisions.setVisible(false);

    }

}
