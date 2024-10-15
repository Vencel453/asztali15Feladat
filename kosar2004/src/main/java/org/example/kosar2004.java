package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class kosar2004 {
    public static void main(String[] args) {
        ArrayList<Mérkőzés> mérkőzések = new ArrayList<>();

        try {
            Scanner olvasó = new Scanner(new File("eredmenyek.csv"));

            olvasó.nextLine();

            while (olvasó.hasNextLine()) {
                String[] adatok = olvasó.nextLine().split(";");
                mérkőzések.add(new Mérkőzés(adatok));
            }

            olvasó.close();
        } catch (FileNotFoundException e) {
            System.out.println("A forrásállomány nem található!");
            System.exit(-1);
        }

        int hazaiSzámláló = 0;
        int idegenSzámláló = 0;

        for (Mérkőzés egyed : mérkőzések) {
            if (egyed.getHazai().equals("Real Madrid")) {
                hazaiSzámláló++;
                continue;
            }
            if (egyed.getIdegen().equals("Real Madrid")) {
                idegenSzámláló++;
            }
        }

        System.out.printf("3. feladat: Real Madrid: Hazai: %d, Idegen: %d\n", hazaiSzámláló, idegenSzámláló);


    }
}