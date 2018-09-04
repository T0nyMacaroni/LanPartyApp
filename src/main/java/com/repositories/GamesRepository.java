package com.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
	
	public static void modify(Game game) {
		list.put(game.getName(), game);
	}
	
	public static List<Game> getAll() {
		return list.values().stream().collect(Collectors.toList());
	}
	
}