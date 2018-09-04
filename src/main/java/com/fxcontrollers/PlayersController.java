package com.fxcontrollers;

import com.entities.Game;
import com.entities.Player;
import com.repositories.GamesRepository;
import com.repositories.PlayerRepository;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PlayersController {
	@FXML private TextField txt_playerName;
	@FXML private TextField txt_playerFirstname;
	@FXML private TextField txt_playerPSNId;
	@FXML private ListView<Player> lview_allPlayers;
	
	private Player player;
	
	private int previousSelectedPlayerIndex;
	
	@FXML void initialize() {
		listing_demo(); //TODO DELETE ME WHEN DONE!
		initPlayerListListener();
	}
	
	@FXML private void create_player() {
		System.out.println("Create player...");
	}
	
	@FXML private void modify_player() {
		System.out.println("Modify player...");
		Player oldPlayer = player;
		player = new Player(
				txt_playerName.getText(),
				txt_playerFirstname.getText(),
				txt_playerPSNId.getText()
		);
		PlayerRepository.modify(oldPlayer, player);
		lview_allPlayers.getItems().clear();
		lview_allPlayers.getItems().addAll(PlayerRepository.getAll());
		lview_allPlayers.getSelectionModel().select(previousSelectedPlayerIndex);
	}
	
	private void initPlayerListListener() {
		lview_allPlayers.getSelectionModel().selectedItemProperty().addListener(e -> {
			player = lview_allPlayers.getSelectionModel().getSelectedItem();
			if (player == null) return;
			previousSelectedPlayerIndex = lview_allPlayers.getSelectionModel().getSelectedIndex();
			txt_playerName.setText(player.getName());
			txt_playerFirstname.setText(player.getFirstName());
			txt_playerPSNId.setText(player.getPsnId());
			//TODO turn games list into frame list.
		});
	}
	
	private void listing_demo() {
		System.out.println("Demo sequence initiated!");
				
		PlayerRepository.add(new Player("Anthony", "Stulens", "AnthonioFéro"));
		PlayerRepository.add(new Player("Ben", "Teppers", "BennyOClock"));
		
		lview_allPlayers.getItems().addAll(PlayerRepository.getAll());
		
		GamesRepository.add(new Game("GTA V"));
		GamesRepository.add(new Game("Rainbow Six Siege"));
		
		//TODO build games selection list
	}
}