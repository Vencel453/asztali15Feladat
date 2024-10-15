package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vizsga> vizsgák = new ArrayList<>();

        try {
            Scanner olvasó = new Scanner(new File("sikeres.csv"));

            olvasó.nextLine();

            while (olvasó.hasNextLine()) {
                String[] adatok = olvasó.nextLine().split(";");
                vizsgák.add(new Vizsga(adatok, true));
            }

            olvasó.close();
        } catch (FileNotFoundException e){
            System.out.println("A sikeres.csv nem található!");
            System.exit(-1);
        }

        try {
            Scanner olvasó = new Scanner(new File("sikertelen.csv"));

            olvasó.nextLine();

            while (olvasó.hasNextLine()) {
                String[] adatok = olvasó.nextLine().split(";");
                vizsgák.add(new Vizsga(adatok, false));
            }

            olvasó.close();
        } catch (FileNotFoundException e){
            System.out.println("A sikertelen.csv nem található!");
            System.exit(-1);
        }

        System.out.println("2. feladat: A legnépszerűbb nyelvek:");

        ArrayList<String> nyelvek = new ArrayList<>();
        for (Vizsga egyed : vizsgák) {
            if (!nyelvek.contains(egyed.getNyelv())) {
                nyelvek.add(egyed.getNyelv());
            }
        }


        ArrayList<NyelvÖsszegzés> nyelvÖsszegzések = new ArrayList<>();
        for (String nyelv : nyelvek) {
            int össz = 0;
            for (Vizsga egyed : vizsgák) {
                if (nyelv.equals(egyed.getNyelv())) {
                    össz += egyed.getÉv2009() + egyed.getÉv2010() + egyed.getÉv2011() + egyed.getÉv2012() + egyed.getÉv2012() + egyed.getÉv2013() + egyed.getÉv2014() + egyed.getÉv2015() + egyed.getÉv2016() + egyed.getÉv2017();
                }
            }
            nyelvÖsszegzések.add(new NyelvÖsszegzés(nyelv, össz));
        }

        for (int i = 0; i < 3; i++) {
            int max = 0;
            int maxIndex = 0;
            for (int j = 0; j < nyelvÖsszegzések.size(); j++) {
                if (nyelvÖsszegzések.get(j).getÖssz() > max) {
                    max = nyelvÖsszegzések.get(j).getÖssz();
                    maxIndex = j;
                }
            }
            System.out.printf("\t\t%s\n", nyelvÖsszegzések.get(maxIndex).getNyelv());
            nyelvÖsszegzések.remove(maxIndex);
        }

        for (NyelvÖsszegzés egyed : nyelvÖsszegzések) {
            System.out.println(egyed.getNyelv() + " " +  egyed.getÖssz());
        }

    }
}