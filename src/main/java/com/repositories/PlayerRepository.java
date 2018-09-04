package com.repositories;

import java.util.ArrayList;
import java.util.List;

import com.entities.Player;

public class PlayerRepository {

	private static List<Player> list = new ArrayList<>();
	
	public static void add(Player t) {
		list.add(t);
	}

	public static void remove(Player t) {
		list.remove(t);
	}
	
	public static void remove(int index) {
		list.remove(index);
	}

	public static void get(int index) {
		list.get(index);
	}

	public static List<Player> getAll() {
		return list;
	}

	public static void modify(Player o1, Player o2) {
		if (list.contains(o1)) {
			int index = 0;
			for (Player p : list) {
				if (p.getPsnId() == o1.getPsnId()) {
					list.remove(index);
					list.add(index, o2);
					return;
				}
				index++;
			}
		}
	}

	public static void modify(int index, Player o) {
		// TODO Auto-generated method stub
		
	}
}