package com.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.entities.Player;

public class PlayerRepository {

	private static Map<String, Player> list = new HashMap<>();
	
	public static void add(Player t) {
		list.put(t.getPsnId(), t);
	}

	public static void remove(Player t) {
		list.remove(t.getPsnId());
	}

	public static Player get(String psnId) {
		return list.get(psnId);
	}
	
	public static void modify(Player player) {
		list.put(player.getPsnId(), player);
	}
	
	public static List<Player> getAll() {
		return list.values().stream().collect(Collectors.toList());
	}
}