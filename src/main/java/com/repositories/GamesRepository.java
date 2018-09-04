package com.repositories;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.entities.Game;

public class GamesRepository implements Serializable {
	
	private static final long serialVersionUID = 4969573314216061320L;
	private static Map<String, Game> list = new HashMap<>();
	
	public static void add(Game t) {
		list.put(t.getName(), t);
	}
	
	public static void remove(Game game) {
		list.remove(game.getName());
	}

	public static Game get(String gameName) {
		return list.get(gameName);
	}
	
	public static void modify(Game oldGame, Game game) {
		remove(oldGame);
		list.put(game.getName(), game);
	}
	
	public static List<Game> getAll() {
		return list.values().stream().collect(Collectors.toList());
	}
	
}