package org.example;

public class Balkezes {
    private String név;
    private String első;
    private String utolsó;
    private int súly;
    private int magasság;

    public Balkezes(String[] adatok) {
        this.név = adatok[0];
        this.első = adatok[1];
        this.utolsó = adatok[2];
        this.súly = Integer.parseInt(adatok[3]);
        this.magasság = Integer.parseInt(adatok[4]);
    }

    public String getNév() {
        return név;
    }

    public String getElső() {
        return első;
    }

    public String getUtolsó() {
        return utolsó;
    }

    public int getSúly() {
        return súly;
    }

    public int getMagasság() {
        return magasság;
    }
}
