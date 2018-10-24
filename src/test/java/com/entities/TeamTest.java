package com.entities;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TeamTest {

	private Team team;
	
	@Before
	public void setUp() throws Exception {
		team = new Team("DummyTeam", 3);
		team.addPlayer(new Player("Test1", "Test-1", "Test--1"));
		team.addPlayer(new Player("Test2", "Test-2", "Test--2"));
		team.addPlayer(new Player("Test3", "Test-3", "Test--3"));
	}
	
	@Test
	public void addPlayer_should_add_an_extra_player_to_the_team() throws Exception {
		team.setTeamSize(4);
		team.addPlayer(new Player("Extra", "Extra-", "Extra--"));
		assertEquals("Extra", team.getPlayers().get(3).getName());
	}
	
	@Test
	public void addPlayer_should_throw_exception_if_max_size_is_exceeded() {
		try {
			team.addPlayer(new Player("Extra", "Extra-", "Extra--"));
			fail("This should throw an exception");
		} catch (Exception ex) {
			
		}
	}
	
	@Test
	public void removePlayer_should_remove_player_from_the_team() throws Exception {
		team.removePlayer(new Player("Test3", "Test-3", "Test--3"));
		assertEquals(2, team.getPlayers().size());
	}
	
	@Test
	public void removePlayer_should_throw_exception_when_player_does_not_exist() {
		try {
			team.removePlayer(new Player("Noo", "Nooo", "NoooHOooow"));
			fail("This should throw an exception!");
		} catch (Exception e) {
		}
	}
	
	@Test
	public void removePlayer_should_throw_exception_if_team_is_already_empty() {
		Team dreamTeam = new Team(1);
		try {
			dreamTeam.removePlayer(new Player("Halleeow","Kiekahbuuuh","Butter"));
			fail("This should throw an exception");
		} catch (Exception e) {
		}
	}
	
	@Test
	public void getPlayers_should_return_all_players() {
		assertEquals(3, team.getTeamSize());
		assertEquals("Test1", team.getPlayers().get(0).getName());
		assertEquals("Test2", team.getPlayers().get(1).getName());
		assertEquals("Test3", team.getPlayers().get(2).getName());
	}
	
	@Test
	public void getTeamName_should_return_team_name() {
		assertEquals("DummyTeam", team.getTeamName());
	}
	
	@Test
	public void setTeamName_should_change_team_name() {
		team.setTeamName("DreamTeam");
		assertEquals("DreamTeam", team.getTeamName());
	}
	
	@Test
	public void getTeamSize_should_return_initial_team_size() {
		assertEquals(3, team.getTeamSize());
	}
	
	@Test
	public void setTeamSize_should_throw_exception_if_its_less_than_current_players_in_team() {
		try {
			team.setTeamSize(1);
			fail("This should throw an exception");
		} catch (Exception e) {
		}
	}
}