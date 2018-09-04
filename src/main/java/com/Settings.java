package com;

import java.io.File;

import javafx.stage.Stage;

public class Settings {

	//IO
	public static final String DEFAULT_EXPORT_FOLDER = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "LanPartyApp" + File.separator;
	public static final String PLAYER_REPOSITORY_DATA = DEFAULT_EXPORT_FOLDER + "Player_Repository.repo";
	public static final String GAMES_REPOSITORY_DATA = DEFAULT_EXPORT_FOLDER + "Games_Repository.repo";
	
	//Overall
	public static Stage primaryStage;
}