package com.entities;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private List<Player> players;
    private int teamSize;

    public Team() {
    	this(-1);
    }
    
    public Team(int teamSize){
        this(null, teamSize);
    }
    
    public Team (String teamName, int teamSize) {
    	this.setTeamName(teamName);
    	this.teamSize = teamSize;
        players = new ArrayList<>(teamSize);
    }
    
    public void addPlayer(Player player) throws Exception {
    	if (players.size() >= teamSize) {
    		throw new Exception("Team size exceeded");
    	}
        players.add(player);
    }
    
    public void removePlayer(Player player) throws Exception {
    	if (players.size() == 0) {
    		throw new Exception("Team is already empty");
    	}
    	int index = 0;
    	for (int i = 0; i < players.size(); i++) {
    		if (players.get(i).getPsnId().equalsIgnoreCase(player.getPsnId())) {
    			players.remove(index);
    			return;
    		}
    	}
    	throw new Exception("player with [" + player.getPsnId() + "] does not exist.");
    }

    public List<Player> getPlayers(){
        return players;
    }

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) throws Exception {
		if (players.size() > teamSize) {
			throw new Exception("new team size is less than current player in the team.");
		}
		this.teamSize = teamSize;
	}
}
