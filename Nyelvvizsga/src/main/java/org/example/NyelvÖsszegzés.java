package org.example;

public class NyelvÖsszegzés {
    private String nyelv;
    private int össz;

    public NyelvÖsszegzés(String nyelv, int össz) {
        this.nyelv = nyelv;
        this.össz = össz;
    }

    public String getNyelv() {
        return nyelv;
    }

    public int getÖssz() {
        return össz;
    }
}
