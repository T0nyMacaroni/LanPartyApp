package com.fxcontrollers;

import java.util.ArrayList;
import java.util.List;

import com.entities.Generator;
import com.entities.Team;
import com.nodes.Popup;

import com.repositories.PlayerRepository;
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
                int teamSize = numberOfPlayers /numberOfTeams;
                Generator gen = new Generator(false,numberOfTeams,teamSize,PlayerRepository.getAll());


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

	public List<Team> getTeams() {
		return Teams;
	}

	public void setTeams(List<Team> teams) {
		Teams = teams;
	}

}
