package org.example;

public class Races {
    private int year;
    private int races;
    private int wins;
    private int podiums;
    private int poles;
    private int fastests;

    public Races(String[] datas) {
        this.year = Integer.parseInt(datas[0]);
        this.races = Integer.parseInt(datas[1]);
        this.wins = Integer.parseInt(datas[2]);
        this.podiums = Integer.parseInt(datas[3]);
        this.poles = Integer.parseInt(datas[4]);
        this.fastests = Integer.parseInt(datas[5]);
    }

    public int getYear() {
        return year;
    }

    public int getRaces() {
        return races;
    }

    public int getWins() {
        return wins;
    }

    public int getPodiums() {
        return podiums;
    }

    public int getPoles() {
        return poles;
    }

    public int getFastests() {
        return fastests;
    }
}
