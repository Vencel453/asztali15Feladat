package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Balkezes> balkezesek  = new ArrayList<>();

        try {
            Scanner olvasó = new Scanner(new File("balkezesek.txt"));

            olvasó.nextLine();

            while (olvasó.hasNextLine()) {
                String[] adatok = olvasó.nextLine().split(";");
                balkezesek.add(new Balkezes(adatok));
            }

            olvasó.close();
        } catch (FileNotFoundException exception) {
            System.out.println("A forrásállomány nem található");
            System.exit(-1);
        }

        System.out.println("3. feladat: " + balkezesek.size());

        System.out.println("4. feladat:");
        for (Balkezes egyed : balkezesek) {
            int év = Integer.parseInt(egyed.getUtolsó().substring(0, 4));
            int hónap = Integer.parseInt(egyed.getUtolsó().substring(5,7));
            if (év == 1999 && hónap == 10) {
                System.out.printf("\t\t%s, %.1f cm\n", egyed.getNév(), egyed.getMagasság() * 2.54);
            }
        }

        Scanner konzol = new Scanner(System.in);
        int évszám = 0;
        do {
            System.out.print("Kérek egy 1990 és 1999 közötti évszámot!: ");
            évszám = (int)(Math.abs(konzol.nextInt()));
            if (évszám >= 1990 && 1999 >= évszám) {
                break;
            }
            else {
                System.out.print("Hibás adat!");
            }
        } while (true);

        int össz = 0;
        int számláló = 0;

        for (Balkezes egyed : balkezesek) {
            int elsőÉv = Integer.parseInt(egyed.getElső().substring(0, 4));
            int utolsóÉv = Integer.parseInt(egyed.getUtolsó().substring(0, 4));
            if (elsőÉv <= évszám && évszám <= utolsóÉv) {
                össz += egyed.getSúly();
                számláló++;
            }
        }

        System.out.printf("6. feladat: %.2f\n", (double)össz / számláló);

    }
}