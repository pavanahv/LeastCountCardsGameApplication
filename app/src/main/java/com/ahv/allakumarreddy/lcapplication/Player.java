package com.ahv.allakumarreddy.lcapplication;

import java.util.ArrayList;

public class Player {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public ArrayList<Integer> getScores() {
        return scores;
    }

    public void setScores(ArrayList<Integer> scores) {
        this.scores = scores;
    }

    private String name;
    private int total;
    private int position;
    private ArrayList<Integer> scores = new ArrayList<>();

    public boolean isOut() {
        return out;
    }

    public void setOut(boolean out) {
        this.out = out;
    }

    boolean out;

    public void add(int newScore) {
        scores.add(newScore);
        total += newScore;
    }
}
