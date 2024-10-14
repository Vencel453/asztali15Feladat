package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Operátorok {
    public static void main(String[] args) {
        ArrayList<Kifejezés> kifejezések = new ArrayList<>();

        try {
            Scanner olvasó = new Scanner(new File("kifejezesek.txt"));

            while (olvasó.hasNextLine()) {
                String[] adatok = olvasó.nextLine().split(" ");
                kifejezések.add(new Kifejezés(adatok));
            }

            olvasó.close();
        } catch (FileNotFoundException exception) {
            System.out.println("A forrásállomány nem található!");
            System.exit(1);
        }

        System.out.printf("2. feladat: Kifejezések száma: %d\n", kifejezések.size());

        int modSzámláló = 0;
        for (Kifejezés egyed : kifejezések) {
            if (egyed.getOperátor().equals("mod")) {
                modSzámláló++;
            }
        }
        System.out.printf("3. feladat: Kifejezések maradékos osztással: %d\n", modSzámláló);

        String eredmény = "Nincs ilyen kifejezés!";
        for (Kifejezés egyed : kifejezések) {
            if ((egyed.getElsőOperandus() % 10 == 0) && (egyed.getMásodikOperandsu() % 10 == 0)) {
                eredmény = "Van ilyen kifejezés!";
                break;
            }
        }

        System.out.println("4. feladat: " + eredmény);

        String[] kifejezésekTömb = {"mod", "/", "div", "-", "*", "+"};

        System.out.println("5. feladat: Statisztika");
        for (String kifejezes : kifejezésekTömb) {
            int ossz = 0;
            for (Kifejezés egyed : kifejezések) {
                if (egyed.getOperátor().equals(kifejezes)) {
                    ossz++;
                }
            }
            System.out.printf("\t\t%s\t-> %d db\n", kifejezes, ossz);
        }

        System.out.print("7. feladat: kérek egy kifejezést (pl.: 1 + 1): ");
        Scanner konzol = new Scanner(System.in);
        String bekérés = konzol.nextLine();
        while (!bekérés.equals("vége")) {
            String[] bekérésTömb = bekérés.split(" ");
            System.out.printf("\t\t%s = %s\n", bekérés, Kifejezés.Művelet(bekérésTömb));
            System.out.print("7. feladat: kérek egy kifejezést (pl.: 1 + 1): ");
            bekérés = konzol.nextLine();
        }


        try {
            FileWriter író = new FileWriter("eredmenyek.txt");

            for (Kifejezés egyed : kifejezések) {
               String[] egyedTömb = {String.valueOf(egyed.getElsőOperandus()), egyed.getOperátor(), String.valueOf(egyed.getMásodikOperandsu())};
               író.write(String.format("%s %s %s = %s\n", egyedTömb[0], egyedTömb[1], egyedTömb[2], Kifejezés.Művelet(egyedTömb)));
            }

            író.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("8. feladat: eredmenyek.txt");
    }
}