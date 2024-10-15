package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class Fuvar {
    public static void main(String[] args) {
        ArrayList<Utazás> utazások = new ArrayList<>();

        try {
            Scanner olvasó =  new Scanner(new File("fuvar.csv"));

            olvasó.nextLine();

            while (olvasó.hasNextLine()) {
                String[] adatok = olvasó.nextLine().split(";");
                utazások.add(new Utazás(adatok));
            }

            olvasó.close();
        } catch (FileNotFoundException e) {
            System.out.println("A forrásállomány nem található!");
            System.exit(-1);
        }

        System.out.println("3. feladat: " + utazások.size());

        double fuvarÖssz = 0;
        int fuvarSzámláló = 0;

        for (Utazás egyed : utazások) {
            if (egyed.getTaxiId() == 6185) {
                fuvarÖssz += egyed.getVitelDíj();
                fuvarSzámláló++;
            }
        }
        System.out.printf("4. feladat: %d alatt: %.2f$\n", fuvarSzámláló, fuvarÖssz);

        System.out.println("5. feladat:");
        ArrayList<String> fizetésmódok = new ArrayList<>();
        for (Utazás egyed : utazások) {
            if (!fizetésmódok.contains(egyed.getFizetésMód())) {
                fizetésmódok.add(egyed.getFizetésMód());
            }
        }

        for (String fizetésmód : fizetésmódok) {
            int számláló = 0;
            for (Utazás egyed : utazások) {
                if (egyed.getFizetésMód().equals(fizetésmód)) {
                    számláló++;
                }
            }
            System.out.printf("\t\t%s: %d fuvar\n", fizetésmód, számláló);
        }

        double távolságÖssz = 0;
        for (Utazás egyed : utazások) {
            távolságÖssz += egyed.getTávolság();
        }

        System.out.printf("6. feladat: %.2fkm", távolságÖssz * 1.6);

        System.out.println("7. feladat: Leghosszabb fuvar:");
        int fuvarMax = utazások.get(0).getUtazásIdeje();
        int fuvarId = 0;
        for (int i = 1; i < utazások.size(); i++) {
            if (utazások.get(i).getUtazásIdeje() > fuvarMax) {
                fuvarMax = utazások.get(i).getUtazásIdeje();
                fuvarId = i;
            }
        }
        System.out.printf("\t\tFuvar hossza: %d másodperc\n", utazások.get(fuvarId).getUtazásIdeje());
        System.out.printf("\t\tTaxi azonosítója: %d\n", utazások.get(fuvarId).getTaxiId());
        System.out.printf("\t\tMegtett távolság: %.1f km\n", utazások.get(fuvarId).getTávolság() * 1.6);
        System.out.printf("\t\tViteldíj: %.2f$\n", utazások.get(fuvarId).getVitelDíj());

        try {
            FileWriter író = new FileWriter("Hibak.txt");

            író.write("taxi_id;indulas;idotartam;tavolsag;viteldij;borravalo;fizetes_modja\n");

            ArrayList<Utazás> hibásak = new ArrayList<>();
            for (Utazás egyed : utazások) {
                if (egyed.getUtazásIdeje() > 0 && egyed.getVitelDíj() > 0 && egyed.getTávolság() == 0) {
                    hibásak.add(egyed);
                }
            }

            DateTimeFormatter formázó = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            hibásak.sort(Comparator.comparing(hibás -> LocalDateTime.parse(hibás.getIndulás(), formázó)));

            for (Utazás egyed : hibásak) {
                író.write(String.format("%d;%s;%d;%s;%s;%s;%s\n",
                        egyed.getTaxiId(),
                        egyed.getIndulás(),
                        egyed.getUtazásIdeje(),
                        String.valueOf(egyed.getTávolság()).replace(".",","),
                        String.valueOf(egyed.getVitelDíj()).replace(".",","),
                        String.valueOf(egyed.getBorravaló()).replace(".",","),
                        egyed.getFizetésMód()));
            }

            író.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}