package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Jackie {
    public static void main(String[] args) {
        ArrayList<Races> racesList = new ArrayList<>();

        try {
            Scanner reader = new Scanner(new File("jackie.txt"));

            reader.nextLine();

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] datas = line.split("\t");
                racesList.add(new Races(datas));
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("A forrásállomány nem található!");
            System.exit(-1);
        }

        System.out.printf("3. feladat: %d\n", racesList.size());

        int most = racesList.get(0).getRaces();
        int mostYear = racesList.get(0).getYear();
        for (Races temp : racesList) {
            if (temp.getRaces() > most) {
                most = temp.getRaces();
                mostYear = temp.getYear();
            }
        }

        System.out.printf("4. feladat: %d\n", mostYear);

        System.out.println("5. feladat: ");
        ArrayList<Integer> decades = new ArrayList<>();
        for (Races temp : racesList) {
            int decade = (temp.getYear() % 100 / 10) * 10;
            if (!decades.contains(decade)) {
                decades.add(decade);
            }
        }

        for (Integer decade : decades) {
            int wins = 0;
            for (Races temp : racesList) {
                if (decade == (temp.getYear() % 100 / 10) * 10) {
                    wins += temp.getWins();
                }
            }
            System.out.printf("\t\t%d-es évek: %d megnyert verseny\n", decade, wins);
        }

        try {
            FileWriter writer = new FileWriter("jackie.html");

            writer.write("""
                    <!DOCTYPE html>
                    <html>
                    <head></head>
                    <style>td { border:1px solid black;}</style>
                    <body>
                    <h1>Jackie Stewart</h1>
                    <table>
                    """);

            for (Races temp : racesList) {
                writer.write(String.format("<tr><td>%d</td><td>%d</td><td>%d</td></tr>\n", temp.getYear(), temp.getRaces(), temp.getWins()));
            }

            writer.write("""
                    </table>
                    </body>
                    </html>
                    """);

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("6. feladat: jackie.html");


    }
}