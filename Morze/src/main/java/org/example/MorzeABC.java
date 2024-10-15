package org.example;

public class MorzeABC {
    private char betű;
    private String morzeKód;

    public MorzeABC(String[] adatok) {
        this.betű = adatok[0].charAt(0);
        this.morzeKód = adatok[1];
    }

    public char getBetű() {
        return betű;
    }

    public String getMorzeKód() {
        return morzeKód;
    }

}
