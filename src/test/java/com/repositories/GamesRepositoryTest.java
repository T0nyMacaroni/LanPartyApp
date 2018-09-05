package com.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.entities.Game;

public class GamesRepositoryTest {

	@Before
	public void setUp() {
		GamesRepository.clear();
		GamesRepository.createMap(Arrays.asList(
				new Game("GTA V"),
				new Game("MapleStory M")
		));
	}
	
	@Test
	public void add_should_add_the_game_to_the_repository() {
		GamesRepository.add(new Game("DummyGame"));
		assertEquals("DummyGame", GamesRepository.get("DummyGame").getName());
	}
	
	@Test
	public void remove_should_remove_the_game_from_the_list() {
		GamesRepository.remove(new Game("MapleStory M"));
		assertEquals(1, GamesRepository.getAll().size());
		assertEquals("GTA V", GamesRepository.getAll().get(0).getName());
	}
	
	@Test
	public void get_should_return_the_game_object_from_the_list() {
		assertEquals("GTA V", GamesRepository.get("GTA V").getName());
		assertEquals("MapleStory M", GamesRepository.get("MapleStory M").getName());
	}
	
	@Test
	public void modify_should_modify_the_old_object_to_a_new_one() {
		GamesRepository.modify(new Game("GTA V"), new Game("Rainbow Six Siege"));
		assertEquals(2, GamesRepository.getAll().size());
		assertEquals("Rainbow Six Siege", GamesRepository.get("Rainbow Six Siege").getName());
		assertEquals(null, GamesRepository.get("GTA V"));
	}
	
	@Test
	public void getAll_should_return_all_games() {
		assertEquals(2, GamesRepository.getAll().size());
		assertEquals("GTA V", GamesRepository.get("GTA V").getName());
		assertEquals("MapleStory M", GamesRepository.get("MapleStory M").getName());
	}
	
	@Test
	public void createMap_turns_a_list_of_games_into_a_hashmap() {
		GamesRepository.clear();
		GamesRepository.createMap(Arrays.asList(new Game("unknown-game"), new Game("test")));
		assertEquals("unknown-game", GamesRepository.get("unknown-game").getName());
		assertEquals("test", GamesRepository.get("test").getName());
	}
	
	@Test
	public void clear_should_wipe_the_whole_hashmap() {
		GamesRepository.clear();
		assertEquals(0, GamesRepository.getAll().size());
	}
}