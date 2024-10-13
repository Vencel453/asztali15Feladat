package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Kolcsonzes> kolcsonzesek = new ArrayList<>();
        try {
            Scanner olvasó = new Scanner(new File("kolcsonzesek.txt"));

            olvasó.nextLine();

            while (olvasó.hasNextLine()) {
                String sor = olvasó.nextLine();
                String[] adatok = sor.split(";");
                kolcsonzesek.add(new Kolcsonzes(adatok));
            }

            olvasó.close();
        } catch (FileNotFoundException exception) {
            System.out.println("A forrásfájl nem található!");
            System.exit(-1);
        }

        System.out.printf("5. feladat: Napi kölcsönzések száma: %d\n", kolcsonzesek.size());

        Scanner konzol = new Scanner(System.in);
        System.out.print("6. feladat: Kérek egy nevet: ");
        String név = konzol.nextLine();
        ArrayList<String> kölcsönzők = new ArrayList<>();
        System.out.printf("\t\t%s kölcsönzései:\n", név);
        for (Kolcsonzes egyed : kolcsonzesek) {
            if (egyed.getNév().equals(név)) {
                System.out.println(egyed.toString());
            }
        }

        System.out.print("7. Feladat: Adjon meg egy időpontot óra:perc alakban: ");
        String[] tempIdő = konzol.nextLine().split(":");

        int óra = Integer.parseInt(tempIdő[0]);
        int perc = Integer.parseInt(tempIdő[1]);

        System.out.println("\t\tA vizen lévő járművek:");
        for (Kolcsonzes egyed : kolcsonzesek) {
            if ((egyed.getEÓra() < óra) || (egyed.getEÓra() == óra && egyed.getEPerc() <= perc)) {
                if ((óra < egyed.getVÓra()) || (óra == egyed.getVÓra() && perc < egyed.getVperc())) {
                    System.out.println(egyed.toString2());
                }
            }
        }

        int szamlalas = 0;
        for (Kolcsonzes egyed : kolcsonzesek) {
            int kezdőPerc = (egyed.getEÓra() * 60) + egyed.getEPerc();
            int végePerc = (egyed.getVÓra() * 60) + egyed.getVperc();
            szamlalas += (végePerc - kezdőPerc + 29) / 30;
        }
        System.out.printf("8. feladat: A napi bevétel: %d\n", szamlalas * 2400);

        try {
            FileWriter író = new FileWriter("F.txt");
            for (Kolcsonzes egyed : kolcsonzesek) {
                if (egyed.getJazon() == 'F') {
                    String EÓraS = "";
                    if (egyed.getEÓra() < 10) {
                        EÓraS += "0" + egyed.getEÓra();
                    }
                    else {
                        EÓraS += egyed.getEÓra();
                    }

                    String EPercS = "";
                    if (egyed.getEPerc() < 10) {
                        EPercS += "0" + egyed.getEPerc();
                    }
                    else {
                        EPercS += egyed.getEPerc();
                    }

                    String VÓraS = "";
                    if (egyed.getVÓra() < 10) {
                        VÓraS += "0" + egyed.getVÓra();
                    }
                    else {
                        VÓraS += egyed.getVÓra();
                    }

                    String VpercS = "";
                    if (egyed.getVperc() < 10) {
                        VpercS += "0" + egyed.getVperc();
                    }
                    else {
                        VpercS += egyed.getVperc();
                    }

                    író.write(String.format("%s:%s-%s:%s : %s\n", EÓraS, EPercS, VÓraS, VpercS, egyed.getNév()));
                }
            }
            író.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("10. Feladat: Statisztika");

        ArrayList<Character> típusok = new ArrayList<>();

        for (Kolcsonzes egyed : kolcsonzesek) {
            if (!típusok.contains(egyed.getJazon())) {
                típusok.add(egyed.getJazon());
            }
        }

        Collections.sort(típusok);

        for (Character karakter : típusok) {
            int szamlalo = 0;
            for (Kolcsonzes egyed : kolcsonzesek) {
                if (egyed.getJazon() == karakter) {
                    szamlalo++;
                }
            }
            System.out.printf("\t\t%c - %d\n", karakter, szamlalo);
        }


    }
}