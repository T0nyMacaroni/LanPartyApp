package com.repositories;

import java.util.ArrayList;
import java.util.List;

import com.entities.Player;

public class PlayerRepository implements IRepository<Player> {

	public static List<Player> list = new ArrayList<>();
	
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

	@Override
	public void modify(Player o1, Player o2) {
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

	@Override
	public void modify(int index, Player o) {
		// TODO Auto-generated method stub
		
	}
}