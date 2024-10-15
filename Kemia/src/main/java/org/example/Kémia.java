package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Kémia {
    public static void main(String[] args) {
        ArrayList<Elem> elemek = new ArrayList<>();

        try {
            Scanner olvasó = new Scanner(new File("felfedezesek.csv"));

            olvasó.nextLine();

            while (olvasó.hasNextLine()) {
                String[] adatok = olvasó.nextLine().split(";");
                elemek.add(new Elem(adatok));
            }

            olvasó.close();
        } catch (FileNotFoundException e) {
            System.out.println("A forrásállomány nem található!");
            System.exit(-1);
        }

        System.out.println("3. feladat: Elemek száma: " + elemek.size());

        int ókorSzámláló = 0;

        for (Elem egyed : elemek) {
            if (!egyed.getÉv().equals("Ókor")) {
                ókorSzámláló = elemek.indexOf(egyed);
                break;
            }
        }

        System.out.println("4. feladat: Felfedezések száma az ókorban: " + ókorSzámláló);
        Scanner konzol = new Scanner(System.in);
        String bekérés = "";
        do {
            System.out.print("5. feladat: kérek egy vegyjelet: ");
            bekérés = konzol.nextLine();
            if (bekérés.length() == 1) {
                if (((bekérés.charAt(0) >= 'A') && (bekérés.charAt(0) <= 'Z')) || ((bekérés.charAt(0) >= 'a') && (bekérés.charAt(0) <= 'z'))) {
                    break;
                }
            }
            if (bekérés.length() == 2) {
                if (((bekérés.charAt(0) >= 'A') && (bekérés.charAt(0) <= 'Z')) || ((bekérés.charAt(0) >= 'a') && (bekérés.charAt(0) <= 'z'))) {
                    if (((bekérés.charAt(1) >= 'A') && (bekérés.charAt(1) <= 'Z')) || ((bekérés.charAt(1) >= 'a') && (bekérés.charAt(1) <= 'z'))) {
                        break;
                    }
                }
            }
        }while (true);

        System.out.println("6. feladat: Keresés");
        boolean volt = false;
        for (Elem egyed : elemek) {
            if (bekérés.equalsIgnoreCase(egyed.getVegyjel())) {
                System.out.printf("\t\tAz elem vegyjele: %s\n", egyed.getVegyjel());
                System.out.printf("\t\tAz elem neve: %s\n", egyed.getNév());
                System.out.printf("\t\tRendszáma: %d\n", egyed.getRendszám());
                System.out.printf("\t\tFelfedezés éve: %s\n", egyed.getÉv());
                System.out.printf("\t\tFelfedező: %s\n", egyed.getFelfedező());
                volt = true;
                break;
            }
        }

        if (!volt) {
            System.out.println("Nincs ilyen elem az adatforrásban!");
        }

        int időszak = 0;

        for (int i = ókorSzámláló; i < elemek.size() - 1; i++) {
            if (Integer.parseInt(elemek.get(i+1).getÉv()) - Integer.parseInt(elemek.get(i).getÉv()) > időszak) {
                időszak = Integer.parseInt(elemek.get(i+1).getÉv()) - Integer.parseInt(elemek.get(i).getÉv());
            }
        }

        System.out.println("7. feladat: " + időszak + " év volt a leghosszabb időszak két elem felfedezése között.");

        System.out.println("8. feladat: Statisztika");
        ArrayList<String> jóÉvek = new ArrayList<>();

        for (int i = ókorSzámláló; i < elemek.size(); i++) {
            if (!jóÉvek.contains(elemek.get(i).getÉv())) {
                jóÉvek.add(elemek.get(i).getÉv());
            }
        }

        for (String jóÉv : jóÉvek) {
            int számláló = 0;
            for (int i = ókorSzámláló; i < elemek.size(); i++) {
                if (elemek.get(i).getÉv().equals(jóÉv)) {
                    számláló++;
                }
            }
            if (számláló > 3) {
                System.out.printf("\t\t%s: %d db\n", jóÉv, számláló);
            }
        }
    }
}