package org.example;

public class Mérkőzés {
    private String hazai;
    private String idegen;
    private int hazai_pont;
    private int idegen_pont;
    private String helyszín;
    private String időpont;

    public Mérkőzés(String[] adatok) {
        this.hazai = adatok[0];
        this.idegen = adatok[1];
        this.hazai_pont = Integer.parseInt(adatok[2]);
        this.idegen_pont = Integer.parseInt(adatok[3]);
        this.helyszín = adatok[4];
        this.időpont = adatok[5];
    }

    public String getHazai() {
        return this.hazai;
    }

    public String getIdegen() {
        return this.idegen;
    }

    public int getHazai_pont() {
        return this.hazai_pont;
    }

    public int getIdegen_pont() {
        return this.idegen_pont;
    }

    public String getHelyszín() {
        return this.helyszín;
    }

    public String getIdőpont() {
        return this.időpont;
    }
}
