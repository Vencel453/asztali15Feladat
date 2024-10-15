package org.example;

public class Utazás {
    private int taxiId;
    private String indulás;
    private int utazásIdeje;
    private double távolság;
    private double vitelDíj;
    private double borravaló;
    private String fizetésMód;

    public Utazás(String[] adatok) {
        this.taxiId = Integer.parseInt(adatok[0]);
        this.indulás = adatok[1];
        this.utazásIdeje = Integer.parseInt(adatok[2]);
        this.távolság = Double.parseDouble(adatok[3].replace(",", "."));
        this.vitelDíj = Double.parseDouble(adatok[4].replace(",", "."));
        this.borravaló = Double.parseDouble(adatok[5].replace(",", "."));
        this.fizetésMód = adatok[6];
    }

    public int getTaxiId() {
        return taxiId;
    }

    public String getIndulás() {
        return indulás;
    }

    public int getUtazásIdeje() {
        return utazásIdeje;
    }

    public double getTávolság() {
        return távolság;
    }

    public double getVitelDíj() {
        return vitelDíj;
    }

    public double getBorravaló() {
        return borravaló;
    }

    public String getFizetésMód() {
        return fizetésMód;
    }

    public void setTaxiId(int taxiId) {
        this.taxiId = taxiId;
    }

    public void setIndulás(String indulás) {
        this.indulás = indulás;
    }

    public void setUtazásIdeje(int utazásIdeje) {
        this.utazásIdeje = utazásIdeje;
    }

    public void setTávolság(double távolság) {
        this.távolság = távolság;
    }

    public void setVitelDíj(double vitelDíj) {
        this.vitelDíj = vitelDíj;
    }

    public void setBorravaló(double borravaló) {
        this.borravaló = borravaló;
    }

    public void setFizetésMód(String fizetésMód) {
        this.fizetésMód = fizetésMód;
    }
}
