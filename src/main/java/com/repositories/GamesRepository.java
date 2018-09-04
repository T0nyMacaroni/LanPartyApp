package com.repositories;

import java.util.HashMap;
import java.util.Map;

import com.entities.Game;

public class GamesRepository {

	private static Map<String, Game> list = new HashMap<>();
	
	public static void add(Game t) {
		list.put(t.getName(), t);
	}
	
	public static void remove(String gameName) {
		list.remove(gameName);
	}

	public static Game get(String gameName) {
		return list.get(gameName);
	}

	public static Map<String, Game> getAll() {
		return list;
	}

	public static void modify(String gameName, Game game) {
		list.put(gameName, game);
	}
	
}