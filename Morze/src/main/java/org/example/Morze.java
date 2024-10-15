package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Morze {
    public static void main(String[] args) {
        ArrayList<MorzeABC> morzeLista = new ArrayList<>();

        try {
            Scanner olvasó = new Scanner(new File("morzeabc.txt"));

            olvasó.nextLine();

            while (olvasó.hasNextLine()) {
                String[] adatok = olvasó.nextLine().split("\t");
                morzeLista.add(new MorzeABC(adatok));
            }

            olvasó.close();
        } catch (FileNotFoundException e) {
            System.out.println("A forrásállomány nem található!");
            System.exit(-1);
        }

        System.out.printf("3. feladat: A morze abc %d karakter kódját tartalmazza.\n", morzeLista.size());

        Scanner konzol = new Scanner(System.in);
        System.out.print("4. feladat: Kérek egy karaktert: ");
        String bekérés = konzol.nextLine();
        boolean volt = false;
        for (MorzeABC egyed : morzeLista) {
            if (bekérés.charAt(0) == (egyed.getBetű())) {
                System.out.printf("\t\t\tA %c karakter morze kódja: %s\n", egyed.getBetű(), egyed.getMorzeKód());
                volt = true;
                break;
            }
        }

        if (!volt) {
            System.out.println("\t\t\tNem található a kódtárban ilyen karakter!\n");
        }

        ArrayList<MorzeÍrások> írások = new ArrayList<>();
        try {
            Scanner olvasó = new Scanner(new File("morze.txt"));

            while (olvasó.hasNextLine()) {
                String[] adatok = olvasó.nextLine().split(";");
                írások.add(new MorzeÍrások(adatok));
            }

            olvasó.close();
        }catch (FileNotFoundException e) {
            System.out.println("A morze.txt nem található!");
            System.exit(-2);
        }

        System.out.println("7. feladat: Az első idézet szerzője: " + Morze2Szöveg(írások.getFirst().getSzerző()));

        int szövegHossz = 0;
        int maxIndex = 0;
        for (int i = 0; i < írások.size(); i++) {
            if (Morze2Szöveg(írások.get(i).getIdézet()).length() > szövegHossz) {
                szövegHossz = Morze2Szöveg(írások.get(i).getIdézet()).length();
                maxIndex = i;
            }
        }

        System.out.println("8. feladat: Az leghosszabb idézet szerzője és az idézet: " + Morze2Szöveg(írások.get(maxIndex).getSzerző()) + ": " + Morze2Szöveg(írások.get(maxIndex).getIdézet()));

        System.out.println("9. feladat: Arisztotelész idézetei:");
        for (MorzeÍrások egyed : írások) {
            if (Morze2Szöveg(egyed.getSzerző()).equals("ARISZTOTELÉSZ")) {
                System.out.println("\t\t\t-" + Morze2Szöveg(egyed.getIdézet()));
            }
        }

        try {
            FileWriter író = new FileWriter("forditas.txt");

            for (MorzeÍrások egyed : írások) {
                író.write(String.format("%s:%s\n", Morze2Szöveg(egyed.getSzerző()), Morze2Szöveg(egyed.getIdézet())));
            }

            író.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static String Morze2Szöveg(String morzeSzöveg) {
        ArrayList<MorzeABC> morzeListaMás = new ArrayList<>();

        try {
            Scanner olvasó = new Scanner(new File("morzeabc.txt"));

            olvasó.nextLine();

            while (olvasó.hasNextLine()) {
                String[] adatok = olvasó.nextLine().split("\t");
                morzeListaMás.add(new MorzeABC(adatok));
            }

            olvasó.close();
        } catch (FileNotFoundException e) {
            System.out.println("A forrásállomány nem található!");
            System.exit(-1);
        }

        StringBuilder rendesSzöveg = new StringBuilder();

        String[] szavak = morzeSzöveg.split(" {7}");
        for (int i = 0; i < szavak.length; i++) {
            String[] betű = szavak[i].split(" {3}");

            for (int j = 0; j < betű.length; j++) {
                for (MorzeABC egyed : morzeListaMás) {
                    if (betű[j].equals(egyed.getMorzeKód())) {
                        rendesSzöveg.append(egyed.getBetű());
                    }
                }
            }
            if (i != szavak.length - 1) {
                rendesSzöveg.append(" ");
            }
        }
       return rendesSzöveg.toString();
    }
}