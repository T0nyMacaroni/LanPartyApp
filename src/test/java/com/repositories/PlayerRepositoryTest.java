package com.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.entities.Player;

public class PlayerRepositoryTest {

	@Before
	public void setUp() {
		PlayerRepository.clear();
		PlayerRepository.createMap(Arrays.asList(
				new Player("Test1", "Test-1", "Test--1"),
				new Player("Test2", "Test-2", "Test--2")
		));
	}
	
	@Test
	public void add_should_add_an_extra_player_to_the_repo() {
		PlayerRepository.add(new Player("Test3", "Test-3", "Test--3"));
		assertEquals(3, PlayerRepository.getAll().size());
		assertEquals("Test--3", PlayerRepository.get("Test--3").getPsnId());
	}
	
	@Test
	public void remove_should_remove_the_player_from_the_repo() {
		PlayerRepository.remove(new Player("Test2", "Test-2", "Test--2"));
		assertEquals(1, PlayerRepository.getAll().size());
		assertEquals("Test--1", PlayerRepository.get("Test--1").getPsnId());
	}
	
	@Test
	public void get_should_return_the_player_having_the_same_psnId() {
		assertEquals("Test2", PlayerRepository.get("Test--2").getName());
	}
	
	@Test
	public void modify_should_modify_the_player() {
		PlayerRepository.modify(new Player("Test2","Test-2","Test--2"), new Player("a","b","c"));
		assertEquals(2, PlayerRepository.getAll().size());
		assertEquals("b", PlayerRepository.get("c").getFirstName());
		assertEquals(null, PlayerRepository.get("Test--2"));
	}
	
	@Test
	public void getAll_should_return_a_list_of_all_players() {
		assertEquals("Test1", PlayerRepository.getAll().get(0).getName());
		assertEquals("Test2", PlayerRepository.getAll().get(1).getName());
	}
	
	@Test
	public void createMap_should_create_a_hashmap_using_an_arraylist() {
		PlayerRepository.clear();
		PlayerRepository.createMap(Arrays.asList(
				new Player("a","a","a"),
				new Player("b","b","b")
		));
		assertEquals(2, PlayerRepository.getAll().size());
		assertEquals("a", PlayerRepository.get("a").getName());
		assertEquals("b", PlayerRepository.get("b").getName());
	}
	
	@Test
	public void clear_should_wipe_the_whole_repository() {
		PlayerRepository.clear();
		assertEquals(0, PlayerRepository.getAll().size());
	}
}