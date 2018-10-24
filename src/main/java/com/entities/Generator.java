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

    public Generator(boolean isPot, int numberOfTeams, int teamSize, List<Player> players) {
        this.isPot = isPot;
        this.numberOfTeams = numberOfTeams;
        this.teamSize = teamSize;
        this.players = players;
    }

    public void draw() {
        Random rand;
        List<Player> team;
        List<Player> players1 = players;
        for (int i = 0; i < numberOfTeams; i++) {
            team = new ArrayList<Player>();
            for (int j = 0; j < teamSize; j++) {
                rand = new Random();
                int randomNumber = rand.nextInt(players1.size());
                System.out.println(randomNumber);
                team.add(players1.get(randomNumber));
                players1.remove(randomNumber);
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

