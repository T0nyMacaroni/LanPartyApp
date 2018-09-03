package com.fxcontrollers;

import com.entities.Game;
import com.entities.Player;
import com.repositories.GamesRepository;
import com.repositories.PlayerRepository;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PlayersController {
	@FXML private TextField txt_playerName;
	@FXML private TextField txt_playerSurName;
	@FXML private TextField txt_playerPSNId;
	@FXML private ComboBox<Game> cmb_possibleGames;
	@FXML private ListView<Player> lview_allPlayers;
	
	@FXML void initialize() {
		listing_demo();
		cmb_possibleGames.getSelectionModel().select(0);
	}
	
	private void listing_demo() {
		System.out.println("Demo sequence initiated!");
				
		PlayerRepository repo = new PlayerRepository();
		repo.add(new Player("test", "test", "test"));
		repo.add(new Player("another", "another", "another"));
		
		lview_allPlayers.getItems().addAll(repo.getAll());
		
		GamesRepository grepo = new GamesRepository();
		grepo.add(new Game("yolooow"));
		grepo.add(new Game("hahaha"));
		
		cmb_possibleGames.getItems().addAll(grepo.getAll());
	}
}