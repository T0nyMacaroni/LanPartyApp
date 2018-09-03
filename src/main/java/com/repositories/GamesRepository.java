package com.repositories;

import java.util.ArrayList;
import java.util.List;

import com.entities.Game;

public class GamesRepository implements IRepository<Game> {

	private List<Game> list = new ArrayList<>();
	
	@Override
	public void add(Game t) {
		list.add(t);
	}

	@Override
	public void remove(int index) {
		list.remove(index);
	}

	@Override
	public void remove(Game t) {
		list.remove(t);
	}

	@Override
	public void get(int index) {
		list.get(index);
	}

	@Override
	public List<Game> getAll() {
		return list;
	}

	
	
}