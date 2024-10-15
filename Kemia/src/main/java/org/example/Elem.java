package org.example;

public class Elem {
    private String év;
    private String név;
    private String vegyjel;
    private int rendszám;
    private String felfedező;

    public Elem(String[] adatok) {
        this.év = adatok[0];
        this.név = adatok[1];
        this.vegyjel = adatok[2];
        this.rendszám = Integer.parseInt(adatok[3]);
        this.felfedező = adatok[4];
    }

    public String getÉv() {
        return év;
    }

    public String getNév() {
        return név;
    }

    public String getVegyjel() {
        return vegyjel;
    }

    public int getRendszám() {
        return rendszám;
    }

    public String getFelfedező() {
        return felfedező;
    }
}
