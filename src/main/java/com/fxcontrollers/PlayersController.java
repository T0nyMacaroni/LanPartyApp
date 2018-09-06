package com.fxcontrollers;

import com.entities.Game;
import com.entities.Player;
import com.nodes.Popup;
import com.repositories.GamesRepository;
import com.repositories.PlayerRepository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class PlayersController {
	@FXML private TextField txt_playerName;
	@FXML private TextField txt_playerFirstname;
	@FXML private TextField txt_playerPSNId;
	@FXML private TableView<Player> tv_allPlayers;
	@FXML private TableColumn<Player,String> tv_firstnameCol;
	@FXML private TableColumn<Player,String> tv_nameCol;
	@FXML private TableColumn<Player,String> tv_psnIdCol;
	@FXML private GridPane gamesGrid;
	@FXML private BorderPane baseFrame;
	
	private CheckBox[] games = new CheckBox[GamesRepository.getAll().size()];
	private Player player;

	private ObservableList<Player> data = FXCollections.observableArrayList(PlayerRepository.getAll());
	
	private int previousSelectedPlayerIndex;
	
	@FXML void initialize() {
		initPlayerListListener();
		txt_playerPSNId.textProperty().addListener((object, oldValue, newValue) -> {
			if (Player.isInvalidPsnId(newValue)) {
				txt_playerPSNId.setText(oldValue);
			}
		});
		initGamesGrid();
	}
	
	public void reset_table_focus() {
		reset_fields();
	}
	
	private void initGamesGrid() {
		int max_size = GamesRepository.getAll().size();
		int overall_index = 0;
		for (int i = 0; i < max_size; i++) {
			for (int x = 0; x < 2; x++) {
				if (!(overall_index >= max_size)) {
					games[overall_index] = new CheckBox(GamesRepository.getAll().get(overall_index).getName());
					gamesGrid.add(games[overall_index], i, x);
					overall_index++;
				}
			}
		}
	}
	
	@FXML private void create_player() {
		System.out.println("Create player...");
		if (invoke_empty_field_detected()) return;
		Player newPlayer = new Player(
				txt_playerName.getText(),
				txt_playerFirstname.getText(),
				txt_playerPSNId.getText()
		);
		for (CheckBox box : games) {
			if (box.isSelected()) {
				newPlayer.addGame(new Game(box.getText()));
			}
		}
		if (PlayerRepository.get(newPlayer.getPsnId()) == null) {
			PlayerRepository.add(newPlayer);
			tv_allPlayers.getItems().clear();
			tv_allPlayers.getItems().addAll(PlayerRepository.getAll());
		}
	}
	
	private boolean invoke_empty_field_detected() {
		if (txt_playerName.getText().isEmpty() || 
				txt_playerFirstname.getText().isEmpty() ||
				txt_playerPSNId.getText().isEmpty()) {
			return true;
		}
		return false;
	}
	
	@FXML private void modify_player() {
		System.out.println("Modify player...");
		if (invoke_player_selection_error()) return;
		Player oldPlayer = player;
		player = new Player(
				txt_playerName.getText(),
				txt_playerFirstname.getText(),
				txt_playerPSNId.getText()
		);
		player.clearGames();
		for (CheckBox box : games) {
			if (box.isSelected()) {
				player.addGame(new Game(box.getText()));
			}
		}
		PlayerRepository.modify(oldPlayer, player);
		tv_allPlayers.getItems().clear();
		tv_allPlayers.getItems().addAll(PlayerRepository.getAll());
		tv_allPlayers.getSelectionModel().select(previousSelectedPlayerIndex);
	}
	
	private boolean invoke_player_selection_error() {
		if (player == null) {
			Popup alert = new Popup(AlertType.INFORMATION);
			alert.setTitle("No player selected");
			alert.setContentText("Please select a player..");
			alert.setHeaderText(null);
			alert.showBox();
			return true;
		}
		return false;
	}
	
	private void reset_fields() {
		txt_playerFirstname.setText("");
		txt_playerName.setText("");
		txt_playerPSNId.setText("");
		previousSelectedPlayerIndex = -1;
		player = null;
		tv_allPlayers.getSelectionModel().clearSelection();
		resetGamesCheckBoxes();
	}
	
	@FXML private void remove_player() {
		System.out.println("Remove player...");
		if (invoke_player_selection_error()) return;
		PlayerRepository.remove(player);
		tv_allPlayers.getItems().clear();
		tv_allPlayers.getItems().addAll(PlayerRepository.getAll());
		reset_fields();
	}
	
	private void initPlayerListListener() {
		tv_allPlayers.getSelectionModel().selectedItemProperty().addListener(e -> {
			player = tv_allPlayers.getSelectionModel().getSelectedItem();
			if (player == null) return;
			previousSelectedPlayerIndex = tv_allPlayers.getSelectionModel().getSelectedIndex();
			txt_playerFirstname.setText(player.getFirstName());
			txt_playerName.setText(player.getName());
			txt_playerPSNId.setText(player.getPsnId());
			resetGamesCheckBoxes();
			player.getGames().forEach(g -> {
				for (CheckBox box : games) {
					if (box.getText().equalsIgnoreCase(g.getName())) {
						box.setSelected(true);
					}
				}
			});
		});
		
		tv_firstnameCol.setCellValueFactory(new PropertyValueFactory<Player,String>("firstName"));
		tv_nameCol.setCellValueFactory(new PropertyValueFactory<Player,String>("name"));
		tv_psnIdCol.setCellValueFactory(new PropertyValueFactory<Player,String>("psnId"));
		tv_allPlayers.getItems().addAll(PlayerRepository.getAll());
	}
	
	private void resetGamesCheckBoxes() {
		for (CheckBox box : games) {
			box.setSelected(false);
		}
	}

	public ObservableList<Player> getData() {
		return data;
	}

	public void setData(ObservableList<Player> data) {
		this.data = data;
	}
}