package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {
	
	private static final long serialVersionUID = 8658534901414231502L;
	
	private String name;
	private String firstName;
    private String psnId;

    private List<String> games;

    public Player(String name,String firstName, String psnId){
        this.name = name;
        this.firstName = firstName;
        this.psnId = psnId;
        games = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPsnId(){
        return psnId;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPsnId(String psnId){
        this.psnId = psnId;
    }

	public List<String> getGames() {
		return games;
	}

	public void addGame(String game) {
		games.add(game);
	}

	public String toString() {
		return String.format("%-16s - %s %s", getPsnId(), getFirstName(), getName());
	}
}
