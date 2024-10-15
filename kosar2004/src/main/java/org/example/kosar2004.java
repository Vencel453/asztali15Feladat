package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class kosar2004 {
    public static void main(String[] args) {
        ArrayList<Mérkőzés> mérkőzések = new ArrayList();

        try {
            Scanner olvasó = new Scanner(new File("eredmenyek.txt"));
            olvasó.nextLine();

            while(olvasó.hasNextLine()) {
                String[] adatok = olvasó.nextLine().split(";");
                mérkőzések.add(new Mérkőzés(adatok));
            }

            olvasó.close();
        } catch (FileNotFoundException var6) {
            System.out.println("A forrásállomány nem található!");
            System.exit(-1);
        }

        int hazaiSzámláló = 0;
        int idegenSzámláló = 0;
        Iterator var4 = mérkőzések.iterator();

        while(var4.hasNext()) {
            Mérkőzés egyed = (Mérkőzés)var4.next();
            if (egyed.getHazai().equals("Real Madrid")) {
                ++hazaiSzámláló;
            } else if (egyed.getIdegen().equals("Real Madrid")) {
                ++idegenSzámláló;
            }
        }

        System.out.printf("3. feladat: Real Madrid: Hazai: %d, Idegen: %d\n", hazaiSzámláló, idegenSzámláló);

        boolean döntetlen = false;

        for (Mérkőzés egyed : mérkőzések) {
            if (egyed.getHazai_pont() == egyed.getIdegen_pont()) {
                döntetlen = true;
                break;
            }
        }

        if (döntetlen) {
            System.out.println("4. feladat: Volt döntetlen? igen");
        }
        else {
            System.out.println("4. feladat: Volt döntetlen? nem");
        }

        String barcelonaCsapat = "";

        for (Mérkőzés egyed : mérkőzések) {
            if (egyed.getHazai().contains("Barcelona")) {
                barcelonaCsapat = egyed.getHazai();
                break;
            }
        }

        System.out.println("5. feladat: barcelonai csapat neve: " + barcelonaCsapat);

        System.out.println("6. feladat:");
        for (Mérkőzés egyed : mérkőzések) {
            if (egyed.getIdőpont().equals("2004-11-21")) {
                System.out.printf("\t\t%s-%s (%d:%d)\n",
                        egyed.getHazai(),
                        egyed.getIdegen(),
                        egyed.getHazai_pont(),
                        egyed.getIdegen_pont());
            }
        }

        ArrayList<String> stadionok = new ArrayList<>();
        for (Mérkőzés egyed : mérkőzések) {
            if (!stadionok.contains(egyed.getHelyszín())) {
                stadionok.add(egyed.getHelyszín());
            }
        }

        System.out.println("7. feladat:");
        for (String stadion : stadionok) {
            int számláló = 0;
            for (Mérkőzés egyed : mérkőzések) {
                if (egyed.getHelyszín().equals(stadion)) {
                    számláló++;
                }
            }
            if (számláló > 20) {
                System.out.printf("\t\t%s: %d\n", stadion, számláló);
            }
        }
    }
}
