package com.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.Settings;
import com.repositories.GamesRepository;
import com.repositories.PlayerRepository;

public class Writer {

	/**
	 * Converts the object to a file.
	 * @param fileName - String :: must be an absolute path
	 * @param object - T
	 */
	private static <T> void write_to_file(String fileName, T object) {
		try (FileOutputStream file = new FileOutputStream(fileName);
				ObjectOutputStream out = new ObjectOutputStream(file)) {
			out.writeObject(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates the base directory if it doesn't exist yet.<br>
	 * path: \Documents\LanPartyApp\
	 */
	public static void create_directory_if_doesnt_exist() {
		File file = new File(Settings.DEFAULT_EXPORT_FOLDER);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	/**
	 * Process every serializable object to a file.<br>
	 * exported to the base-dir :: \Documents\LanPartyApp\
	 */
	public static void processData() {
		process_player_repository();
		process_games_repository();
	}
	
	/**
	 * Process player repository to default location
	 */
	public static void process_player_repository() {
		write_to_file(Settings.PLAYER_REPOSITORY_DATA, PlayerRepository.getAll());
	}
	
	/**
	 * Process games repository to default location
	 */
	public static void process_games_repository() {
		write_to_file(Settings.GAMES_REPOSITORY_DATA, GamesRepository.getAll());
	}
	
	/**
	 * convert player repository object data to file
	 * @param filePath - absolute path
	 */
	public static void export_player_repository(String filePath) {
		write_to_file(filePath, PlayerRepository.getAll());
	}
	
}