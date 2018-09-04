package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Player implements Serializable {

	private static final long serialVersionUID = 8658534901414231502L;

	private transient StringProperty firstName;
	private transient StringProperty name;
	private transient StringProperty psnId;
	
	private String _firstName;
	private String _name;
	private String _psnId;

	private List<String> games;

	public Player(String name, String firstName, String psnId) {
		_name = name;
		_psnId = psnId;
		_firstName = firstName;
		this.name = new SimpleStringProperty(name);
		this.firstName = new SimpleStringProperty(firstName);
		this.psnId = new SimpleStringProperty(psnId);
		games = new ArrayList<>();
	}

	public void build_player() {
		this.name = new SimpleStringProperty(_name);
		this.firstName = new SimpleStringProperty(_firstName);
		this.psnId = new SimpleStringProperty(_psnId);
	}

	public void setFirstName(String value) {
		firstNameProperty().set(value);
	}

	public String getFirstName() {
		return firstNameProperty().get();
	}

	public StringProperty firstNameProperty() {
		return firstName;
	}

	public void setName(String value) {
		nameProperty().set(value);
	}

	public String getName() {
		return nameProperty().get();
	}

	public StringProperty nameProperty() {
		return name;
	}

	public void setPsnId(String value) {
		psnIdProperty().set(value);
	}

	public String getPsnId() {
		return psnIdProperty().get();
	}

	public StringProperty psnIdProperty() {
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
