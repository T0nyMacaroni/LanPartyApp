package com.repositories;

import java.util.HashMap;
import java.util.Map;

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

	public static Map<String, Player> getAll() {
		return list;
	}

	public static void modify(String psnId, Player player) {
		list.put(psnId, player);
	}
}