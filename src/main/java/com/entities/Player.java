package com.entities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {
	
	private static final long serialVersionUID = 8658534901414231502L;

    private List<String> games;

    public Player(String name,String firstName, String psnId){
        this.name = new SimpleStringProperty(name);
        this.firstName = new SimpleStringProperty(firstName);
        this.psnId = new SimpleStringProperty(psnId);
        games = new ArrayList<>();
    }

    private StringProperty firstName;
    public void setFirstName(String value) { firstNameProperty().set(value); }
    public String getFirstName() { return firstNameProperty().get(); }
    public StringProperty firstNameProperty() {
        return firstName;
    }

    private StringProperty name;
    public void setName(String value) { firstNameProperty().set(value); }
    public String getName() { return firstNameProperty().get(); }
    public StringProperty nameProperty() {
        return name;
    }

    private StringProperty psnId;
    public void setPsnId(String value) { firstNameProperty().set(value); }
    public String getPsnId() { return firstNameProperty().get(); }
    public StringProperty PsnIdProperty() {
        return psnId;
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
