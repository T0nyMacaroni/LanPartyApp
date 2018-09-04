package com.entities;

import java.io.Serializable;

public class Game implements Serializable {

	private static final long serialVersionUID = -2072940140941450041L;
	
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