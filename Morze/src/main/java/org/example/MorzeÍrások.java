package org.example;

import java.util.stream.Stream;

public class MorzeÍrások {
    private String szerző;
    private String idézet;

    public MorzeÍrások(String[] adatok) {
        this.szerző = adatok[0];
        this.idézet = adatok[1];
    }

    public String getSzerző() {
        return szerző;
    }

    public String getIdézet() {
        return idézet;
    }
}
