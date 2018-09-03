package com.repositories;

import java.util.ArrayList;
import java.util.List;

import com.entities.Player;

public class PlayerRepository implements IRepository<Player> {

	private List<Player> list = new ArrayList<>();
	
	@Override
	public void add(Player t) {
		list.add(t);
	}

	@Override
	public void remove(Player t) {
		list.remove(t);
	}
	
	@Override
	public void remove(int index) {
		list.remove(index);
	}

	@Override
	public void get(int index) {
		list.get(index);
	}

	@Override
	public List<Player> getAll() {
		return list;
	}

	
	
}