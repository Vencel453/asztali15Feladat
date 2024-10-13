package org.example;

public class Kölcsön {
    private String név;
    private char Jazon;
    private int EÓra;
    private int EPerc;
    private int VÓra;
    private int Vperc;

    public Kölcsön(String adatok[]) {
        név = adatok[0];
        Jazon = adatok[1].charAt(0);
        EÓra = Integer.parseInt(adatok[2]);
        EPerc = Integer.parseInt(adatok[3]);
        VÓra = Integer.parseInt(adatok[4]);
        Vperc = Integer.parseInt(adatok[5]);
    }

    public String getNév() {
        return név;
    }

    public char getJazon() {
        return Jazon;
    }

    public int getEÓra() {
        return EÓra;
    }

    public int getEPerc() {
        return EPerc;
    }

    public int getVÓra() {
        return VÓra;
    }

    public int getVperc() {
        return Vperc;
    }
}
