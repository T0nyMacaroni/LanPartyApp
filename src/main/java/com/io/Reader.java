package com.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import com.Settings;
import com.entities.Game;
import com.entities.Player;
import com.repositories.GamesRepository;
import com.repositories.PlayerRepository;

public class Reader {
	
	/**
	 * Transfers file-data to object-data
	 * @param fileName - String :: has to be an absolute path
	 * @return Object
	 */
	private static Object readFile(String fileName) {
		try (FileInputStream file = new FileInputStream(fileName);
			 ObjectInputStream obj = new ObjectInputStream(file)) {
			return obj.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Transfers all file-data from the default-dir to object-data
	 */
	public static void initData() {
		prepare_player_data(null);
		prepare_games_data();
	}
	
	/**
	 * Convert player repository data from a file to an object.
	 * @param path - Absolute path
	 */
	@SuppressWarnings("unchecked")
	private static void prepare_player_data(String path) {
		if (path == null) path = Settings.PLAYER_REPOSITORY_DATA;
		List<Player> repo_player = (List<Player>) readFile(path);
		List<Player> new_repo_player = new ArrayList<>();
		repo_player.forEach(e -> {
			e.build_player();
			new_repo_player.add(e);
		});
		PlayerRepository.createMap(new_repo_player);
	}
	
	/**
	 * Convert games repository data from a file to an object.
	 */
	@SuppressWarnings("unchecked")
	private static void prepare_games_data() {
		List<Game> repo_games = (List<Game>) readFile(Settings.GAMES_REPOSITORY_DATA);
		GamesRepository.createMap(repo_games);
	}
	
	/**
	 * Imports player repository data from a file to an object using an absolute path
	 * @param filePath - absolute path
	 */
	public static void import_player_repository(String filePath) {
		prepare_player_data(filePath);
	}
	
}