package main.java.com.entities;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private String psnId;

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
