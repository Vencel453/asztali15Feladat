package org.example;

public class Vizsga {
    private String nyelv;
    private int év2009;
    private int év2010;
    private int év2011;
    private int év2012;
    private int év2013;
    private int év2014;
    private int év2015;
    private int év2016;
    private int év2017;
    private boolean sikeresE;

    public Vizsga(String[] adatokSiker, boolean sikeresE) {
        this.nyelv = adatokSiker[0];
        this.év2009 = Integer.parseInt(adatokSiker[1]);
        this.év2010 = Integer.parseInt(adatokSiker[2]);
        this.év2011 = Integer.parseInt(adatokSiker[3]);
        this.év2012 = Integer.parseInt(adatokSiker[4]);
        this.év2013 = Integer.parseInt(adatokSiker[5]);
        this.év2014 = Integer.parseInt(adatokSiker[6]);
        this.év2015 = Integer.parseInt(adatokSiker[7]);
        this.év2016 = Integer.parseInt(adatokSiker[8]);
        this.év2017 = Integer.parseInt(adatokSiker[9]);
        this.sikeresE =  sikeresE;
    }

    public String getNyelv() {
        return nyelv;
    }

    public int getÉv2009() {
        return év2009;
    }

    public int getÉv2010() {
        return év2010;
    }

    public int getÉv2011() {
        return év2011;
    }

    public int getÉv2012() {
        return év2012;
    }

    public int getÉv2013() {
        return év2013;
    }

    public int getÉv2014() {
        return év2014;
    }

    public int getÉv2015() {
        return év2015;
    }

    public int getÉv2016() {
        return év2016;
    }

    public int getÉv2017() {
        return év2017;
    }

    public boolean isSikeresE() {
        return sikeresE;
    }
}
