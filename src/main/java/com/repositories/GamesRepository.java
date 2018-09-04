package com.repositories;

import java.util.ArrayList;
import java.util.List;

import com.entities.Game;

public class GamesRepository {

	private static List<Game> list = new ArrayList<>();
	
	public static void add(Game t) {
		if (!list.contains(t))
			list.add(t);
	}
	
	public static void remove(int index) {
		list.remove(index);
	}

	public static void remove(Game t) {
		if (!list.contains(t))
			list.remove(t);
	}

	public static void get(int index) {
		list.get(index);
	}

	public static List<Game> getAll() {
		return list;
	}

	public static void modify(Game o1, Game o2) {
		// TODO Auto-generated method stub
		
	}

	public static void modify(int index, Game o) {
		// TODO Auto-generated method stub
		
	}
	
}