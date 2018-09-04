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
	private PlayerRepository player_repo;
	private GamesRepository games_repo;
	
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
		player_repo.modify(oldPlayer, player);
		lview_allPlayers.getItems().clear();
		lview_allPlayers.getItems().addAll(player_repo.getAll());
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
				
		player_repo = new PlayerRepository();
		player_repo.add(new Player("Anthony", "Stulens", "AnthonioFéro"));
		player_repo.add(new Player("Ben", "Teppers", "BennyOClock"));
		
		lview_allPlayers.getItems().addAll(player_repo.getAll());
		
		games_repo = new GamesRepository();
		games_repo.add(new Game("GTA V"));
		games_repo.add(new Game("Rainbow Six Siege"));
		
		//TODO build games selection list
	}
}