package com.fxcontrollers;

import com.entities.Game;
import com.entities.Player;
import com.repositories.GamesRepository;
import com.repositories.PlayerRepository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PlayersController {
	@FXML private TextField txt_playerName;
	@FXML private TextField txt_playerFirstname;
	@FXML private TextField txt_playerPSNId;
	//@FXML private ListView<Player> lview_allPlayers;
	@FXML private TableView<Player> tv_allPlayers;
	@FXML private TableColumn<Player,String> tv_firstnameCol;
	@FXML private TableColumn<Player,String> tv_nameCol;
	@FXML private TableColumn<Player,String> tv_psnIdCol;
	
	private Player player;

	private ObservableList<Player> data = FXCollections.observableArrayList(PlayerRepository.getAll());
	
	private int previousSelectedPlayerIndex;
	
	@FXML void initialize() {
		listing_demo(); //TODO DELETE ME WHEN DONE!
		initPlayerListListener();
	}
	
	@FXML private void create_player() {
		System.out.println("Create player...");
		Player newPlayer = new Player(
				txt_playerName.getText(),
				txt_playerFirstname.getText(),
				txt_playerPSNId.getText()
		);
		PlayerRepository.add(newPlayer);
		tv_allPlayers.getItems().clear();
		tv_allPlayers.getItems().addAll(PlayerRepository.getAll());
	}
	
	@FXML private void modify_player() {
		System.out.println("Modify player...");
		if(player == null) return;
		Player oldPlayer = player;
		player = new Player(
				txt_playerName.getText(),
				txt_playerFirstname.getText(),
				txt_playerPSNId.getText()
		);
		PlayerRepository.modify(oldPlayer, player);
		tv_allPlayers.getItems().clear();
		tv_allPlayers.getItems().addAll(PlayerRepository.getAll());
		tv_allPlayers.getSelectionModel().select(previousSelectedPlayerIndex);
	}
	
	@FXML private void remove_player() {
		System.out.println("Remove player...");
		if (player == null) return;
		PlayerRepository.remove(player);
		tv_allPlayers.getItems().clear();
		tv_allPlayers.getItems().addAll(PlayerRepository.getAll());
	}
	
	private void initPlayerListListener() {
		tv_allPlayers.getSelectionModel().selectedItemProperty().addListener(e -> {
			player = tv_allPlayers.getSelectionModel().getSelectedItem();
			if (player == null) return;
			previousSelectedPlayerIndex = tv_allPlayers.getSelectionModel().getSelectedIndex();
			txt_playerFirstname.setText(player.getFirstName());
			txt_playerName.setText(player.getName());
			txt_playerPSNId.setText(player.getPsnId());

			//TODO turn games list into frame list.
		});

		tv_firstnameCol.setCellValueFactory(new PropertyValueFactory<Player,String>("firstName"));
		tv_nameCol.setCellValueFactory(new PropertyValueFactory<Player,String>("name"));
		tv_psnIdCol.setCellValueFactory(new PropertyValueFactory<Player,String>("psnId"));
		tv_allPlayers.getItems().addAll(PlayerRepository.getAll());
	}
	
	private void listing_demo() {
		System.out.println("Demo sequence initiated!");
				
		PlayerRepository.add(new Player("Stulens", "Anthony", "AnthonioFéro"));
		PlayerRepository.add(new Player("Teppers", "Ben", "BennyOClock"));
		
		GamesRepository.add(new Game("GTA V"));
		GamesRepository.add(new Game("Rainbow Six Siege"));
		
		//TODO build games selection list
	}

	public ObservableList<Player> getData() {
		return data;
	}

	public void setData(ObservableList<Player> data) {
		this.data = data;
	}
}