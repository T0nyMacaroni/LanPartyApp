package com.entities;

import java.io.Serializable;
import java.util.List;

public class Player implements Serializable {
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
}
