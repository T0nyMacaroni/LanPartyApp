package com.repositories;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.entities.Player;

public class PlayerRepository implements Serializable {

	private static final long serialVersionUID = 5986949393186564338L;
	
	private static Map<String, Player> list = new HashMap<>();
	
	public static void add(Player player) {
		list.put(player.getPsnId(), player);
	}

	public static void remove(Player player) {
		list.remove(player.getPsnId());
	}

	public static Player get(String psnId) {
		return list.get(psnId);
	}
	
	public static void modify(Player oldPlayer,Player newPlayer) {
		remove(oldPlayer);
		list.put(newPlayer.getPsnId(), newPlayer);
	}
	
	public static List<Player> getAll() {
		return list.values().stream().collect(Collectors.toList());
	}
}