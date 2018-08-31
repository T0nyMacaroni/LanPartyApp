package com.entities;

import java.io.Serializable;
import java.util.List;

public class Player implements Serializable {
	
	private static final long serialVersionUID = 8658534901414231502L;
	
	private String name;
    private String psnId;

    private List<String> games;

    public Player(String name, String psnId){
        this.name = name;
        this.psnId = psnId;
    }

    public String getName(){
        return name;
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

	public void setGames(List<String> games) {
		this.games = games;
	}
}
