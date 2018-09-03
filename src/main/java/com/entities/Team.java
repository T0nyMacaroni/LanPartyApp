package com.entities;

import com.entities.Player;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private List<Player> players;
    private int teamSize;

    public Team(int teamSize){
        this.setTeamName(teamName);
        this.teamSize = teamSize;
        players = new ArrayList<>(teamSize);
    }

    public void addPlayer(Player player){
        players.add(player);
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
}
