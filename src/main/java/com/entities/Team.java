package com.entities;

import com.entities.Player;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private List<Player> players = new ArrayList<>();

    public Team(String teamName){
        this.teamName = teamName;
    }

    public void addPlayer(Player player){
        players.add(player);
    }
}
