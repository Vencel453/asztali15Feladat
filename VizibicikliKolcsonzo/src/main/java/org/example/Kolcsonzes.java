package org.example;

public class Kolcsonzes {
    private String név;
    private char Jazon;
    private int EÓra;
    private int EPerc;
    private int VÓra;
    private int Vperc;

    public Kolcsonzes(String adatok[]) {
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

    @Override
    public String toString() {
        return String.format("\t\t%d:%d-%d:%d", EÓra, EPerc, VÓra, Vperc);
    }

    public String toString2() {
        String EÓraS = "";
        if (EÓra < 10) {
            EÓraS += "0" + EÓra;
        }
        else {
            EÓraS += EÓra;
        }

        String EPercS = "";
        if (EPerc < 10) {
            EPercS += "0" + EPerc;
        }
        else {
            EPercS += EPerc;
        }

        String VÓraS = "";
        if (VÓra < 10) {
            VÓraS += "0" + VÓra;
        }
        else {
            VÓraS += VÓra;
        }

        String VpercS = "";
        if (Vperc < 10) {
            VpercS += "0" + Vperc;
        }
        else {
            VpercS += Vperc;
        }

        return String.format("\t\t%s:%s-%s:%s : %s", EÓraS, EPercS, VÓraS, VpercS, név);
    }
}
