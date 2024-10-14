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

    public static String Művelet(String[] kifejezés) {
        if (kifejezés[1].equals("mod")) {
            if (Integer.parseInt(kifejezés[0]) == 0 || Integer.parseInt(kifejezés[2]) == 0) {
                return "Egyéb hiba!";
            }
            return String.valueOf(Integer.parseInt(kifejezés[0]) % Integer.parseInt(kifejezés[2]));
        }
        else if (kifejezés[1].equals("/")) {
            if (Integer.parseInt(kifejezés[0]) == 0 || Integer.parseInt(kifejezés[2]) == 0) {
                return "Egyéb hiba!";
            }
            return String.valueOf(Double.parseDouble(kifejezés[0]) / Double.parseDouble(kifejezés[2]));
        }
        else if (kifejezés[1].equals("div")) {
            if ((Integer.parseInt(kifejezés[0]) == 0) || (Integer.parseInt(kifejezés[2]) == 0)) {
                return "Egyéb hiba!";
            }
            return String.valueOf(Integer.parseInt(kifejezés[0]) / Integer.parseInt(kifejezés[2]));
        }
        else if (kifejezés[1].equals("-")) {
            return String.valueOf(Integer.parseInt(kifejezés[0]) - Integer.parseInt(kifejezés[2]));
        }
        else if (kifejezés[1].equals("*")) {
            return String.valueOf(Integer.parseInt(kifejezés[0]) * Integer.parseInt(kifejezés[2]));
        }
        else if (kifejezés[1].equals("+")) {
            return String.valueOf(Integer.parseInt(kifejezés[0]) + Integer.parseInt(kifejezés[2]));
        }
        else {
            return "Hibás operátor!";
        }
    }
}
