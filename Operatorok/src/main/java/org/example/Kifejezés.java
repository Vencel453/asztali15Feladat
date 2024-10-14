package org.example;

public class Kifejezés {
    private int elsőOperandus;
    private String operátor;
    private int másodikOperandsu;

    public Kifejezés(String[] adatok) {
        this.elsőOperandus = Integer.parseInt(adatok[0]);
        this.operátor = adatok[1];
        this.másodikOperandsu = Integer.parseInt(adatok[2]);
    }

    public int getElsőOperandus() {
        return elsőOperandus;
    }

    public String getOperátor() {
        return operátor;
    }

    public int getMásodikOperandsu() {
        return másodikOperandsu;
    }
}
