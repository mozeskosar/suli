package varosok;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

public class Varosok {

    public static class varos {

        String varos;
        String orszag;
        double lakossag;

        public varos(String varos, String orszag, double lakossag) {
            this.varos = varos;
            this.orszag = orszag;
            this.lakossag = lakossag;
        }

        public String getVaros() {
            return varos;
        }

        public String getOrszag() {
            return orszag;
        }

        public double getLakossag() {
            return lakossag;
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {

        ArrayList<varos> lista = new ArrayList<varos>();
        beolvas(lista);
        System.out.println("3. feladat: Városok száma: " + lista.size() + " db");
        feladat4(lista);
        feladat5(lista);
        feladat6(lista);
        feladat7(lista);
        feladat8(lista);

    }

    public static void beolvas(ArrayList<varos> lista) {

        try {
            File adat = new File("varosok.txt");
            Scanner fileinput = new Scanner(adat);
            String elsosor = fileinput.nextLine();
            while (fileinput.hasNextLine()) {
                String data = fileinput.nextLine();
                String[] tomb = data.split(";");
                lista.add(new varos(tomb[0], tomb[1], Double.parseDouble(tomb[2].replace(",", "."))));
            }
            fileinput.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }

    public static void feladat4(ArrayList<varos> lista) {

        double osszeg = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getOrszag().equals("India")) {
                osszeg = osszeg + lista.get(i).getLakossag();
            }
        }
        System.out.println("4. Feladat: indiai nagyvárosok lakosságának összege: " + osszeg + " fő");

    }

    public static void feladat5(ArrayList<varos> lista) {
        double max = 0;
        int index = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getLakossag() > max) {
                max = lista.get(i).getLakossag();
                index = i;
            }
        }
        System.out.println("5. Feladat: A legnagyobb lakosságú város adatai: ");
        System.out.println("Név: " + lista.get(index).getVaros());
        System.out.println("Ország: " + lista.get(index).getOrszag());
        System.out.println("Lakosság: " + lista.get(index).getLakossag() + " fő");

    }

    public static void feladat6(ArrayList<varos> lista) {

        boolean magyare = false;
        for (varos e : lista) {
            if (e.getOrszag().contains("Magyar")) {
                magyare = true;
            }
        }

        if (magyare == false) {
            System.out.println("6. Feladat: Nincs magyar város az adatok között!");
        } else {
            System.out.println("6. Feladat: Van magyar város az adatok között!");
        }

    }

    public static void feladat7(ArrayList<varos> lista) {

        int egyszokoz = 0;
        int szokozdb = 0;
        for (int i = 0; i < lista.size(); i++) {

            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getVaros().contains(" ") && lista.get(i).getVaros().contains(" ")) {
                    szokozdb++;
                    if (szokozdb > egyszokoz) {
                        szokozdb = egyszokoz;
                    }
                }
            }
        }
        System.out.println(egyszokoz);
    }

    public static void feladat8(ArrayList<varos> lista) {

    }
}
