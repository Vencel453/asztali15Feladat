package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Versenyzők {
    public static void main(String[] args) {
        ArrayList<Pilóta> pilóták = new ArrayList<>();

        try {
            Scanner olvasó = new Scanner(new File("pilotak.csv"));

            olvasó.nextLine();

            while (olvasó.hasNextLine()) {
                String sor = olvasó.nextLine();
                String[] adatok = sor.split(";");
                pilóták.add(new Pilóta(adatok));
            }

            olvasó.close();
        } catch (FileNotFoundException exception) {
            System.out.println("A forrásállomány nem található!");
        }

        System.out.printf("3. feladat: %d\n", pilóták.size());

        System.out.printf("4. feladat: %s\n", pilóták.get(pilóták.size()-1).getNév());

        System.out.println("5. feladat:");

        for (Pilóta egyed : pilóták) {
            int év = Integer.parseInt(egyed.getSzületési_dátum().substring(0, 4));
            if (év < 1901) {
                System.out.println(egyed.toString());
            }
        }

        int minRajtszám = Integer.MAX_VALUE;
        String minNemzetiség = "";
        for (Pilóta egyed : pilóták) {
            if ((egyed.getRajtszám() > 0) && (egyed.getRajtszám() < minRajtszám)) {
            minRajtszám = egyed.getRajtszám();
            minNemzetiség = egyed.getNemzetiség();
            }
        }
        System.out.printf("6. feladat: %s", minNemzetiség);

        ArrayList<Integer> ismétlések = new ArrayList<>();
        for (Pilóta egyed : pilóták) {
            for (Pilóta elem : pilóták) {
                if ((elem.getRajtszám() > 0) && (egyed.getRajtszám() == elem.getRajtszám() && (!(elem.getNév().equals(egyed.getNév())) && !(elem.getSzületési_dátum().equals(egyed.getSzületési_dátum())) && !(ismétlések.contains(elem.getRajtszám()))))) {
                    ismétlések.add(elem.getRajtszám());
                }
            }
        }
        System.out.print("7. feladat:");
        for (Integer egyed : ismétlések) {
            if (ismétlések.get(ismétlések.size()-1) == egyed){
                System.out.printf(" %d", egyed);
            }
            else {
                System.out.printf(" %d,", egyed);
            }

        }
        System.out.println();
    }
}