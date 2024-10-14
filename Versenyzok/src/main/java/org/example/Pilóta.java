package org.example;

public class Pilóta {
    private String név;
    private String születési_dátum;
    private String nemzetiség;
    private int rajtszám;

    public Pilóta(String[] adatok) {
        this.név = adatok[0];
        this.születési_dátum = adatok[1];
        this.nemzetiség = adatok[2];
        if (adatok.length == 4) {
            this.rajtszám = Integer.parseInt(adatok[3]);
        }else {
            this.rajtszám = 0;
        }
    }

    public String getNév() {
        return név;
    }

    public String getSzületési_dátum() {
        return születési_dátum;
    }

    public String getNemzetiség() {
        return nemzetiség;
    }

    public int getRajtszám() {
        return rajtszám;
    }

    @Override
    public String toString() {
        String[] dátum = születési_dátum.split("\\.");
        return String.format("\t\t%s (%s. %s. %s.)", név, dátum[0], dátum[1], dátum[2]);
    }
}
