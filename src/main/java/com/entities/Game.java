package com.entities;

public class Game {

	private String name;

	public Game() {
		
	}
	
	public Game(String name) {
		setName(name);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
}