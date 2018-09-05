package com.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	private Player player;
	
	@Before
	public void setUp() {
		player = new Player("Tester", "Dummy", "DummiesOver9000");
	}
	
	@Test
	public void getName_returns_player_name() {
		assertEquals("Tester", player.getName());
	}
	
	@Test
	public void setName_should_change_player_name() {
		player.setName("NewName");
		assertEquals("NewName", player.getName());
	}
	
	@Test
	public void getFirstName_should_return_player_first_name() {
		assertEquals("Dummy", player.getFirstName());
	}
	
	@Test
	public void setPsnId_should_change_player_psn_id() {
		player.setFirstName("DummyBoii");
		assertEquals("DummyBoii", player.getFirstName());
	}
	
	@Test
	public void getPsnId_should_return_player_psn_id() {
		assertEquals("DummiesOver9000", player.getPsnId());
	}
	
	@Test
	public void setPsnId_with_spaces_should_throw_exception() {
		try {
			player.setPsnId("ThisIs Invalid");
			fail("This should throw an exception");
		} catch (Exception e) {
			
		}
	}
	
	@Test
	public void setPsnId_passing_lengt_limitation_should_throw_exception() {
		try {
			player.setPsnId("ThisIsAStoryWrittenByACuntThatDoesntUnderstandNameLimitations.");
			fail("This should throw an exception");
		} catch (Exception e) {
		}
	}
	
}