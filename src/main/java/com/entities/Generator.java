package com.entities;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Generator {
    private boolean isPot;
    private int pots;
    private int numberOfTeams;
    private int teamSize;
    private List<Player> players;
    private List<List> teams = new ArrayList<List>();

    // int numberOfPersons;
    public Generator(boolean isPot, int numberOfTeams, int teamSize, List<Player> players) {
        this.isPot = isPot;
        this.numberOfTeams = numberOfTeams;
        this.teamSize = teamSize;
        this.players = players;
    }

    public void draw() {
        //numberOfPersons = persons.size();
        Random rand;
        List<String> team;
        for (int i = 0; i < numberOfTeams; i++) {
            team = new ArrayList<String>();
            for (int j = 0; j < teamSize; j++) {
                rand = new Random();
                int randomNumber = rand.nextInt(players.size());
                System.out.println(randomNumber);
                //teams.add((List) players.get(randomNumber));
                players.remove(randomNumber);
            }
            teams.add(team);
        }
    }

    public void print() {
        int teamNumber = 1;
        for (List<String> team : teams) {
            System.out.println("Team " + teamNumber);
            for (String member : team) {
                System.out.print(member + " ");
            }
            System.out.println();
            teamNumber++;
        }
    }

    public boolean isPossible() {
        return (numberOfTeams * teamSize == players.size());
    }
}

