package com.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Game game;
	
	@Before
	public void setUp() {
		game = new Game("GTA V");
	}
	
	@Test
	public void getGame_returns_game_name() {
		assertEquals("GTA V", game.getName());
	}
	
	@Test
	public void setGame_changes_game_name() {
		game.setName("MapleStory M");
		assertEquals("MapleStory M", game.getName());
	}
	
}