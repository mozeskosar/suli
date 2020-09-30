package snooker;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class Snooker {

    public static class adatok {

        int helyezes;
        String nev;
        String orszag;
        int nyeremeny;

        public adatok(int helyezes, String nev, String orszag, int nyeremeny) {
            this.helyezes = helyezes;
            this.nev = nev;
            this.orszag = orszag;
            this.nyeremeny = nyeremeny;
        }

    }

    public static void main(String[] args) throws FileNotFoundException {

        Vector<adatok> v = new Vector<>();
        Scanner fileinput = new Scanner(new File("snooker.txt"));
        String elsosor = fileinput.nextLine();
        while (fileinput.hasNextLine()) {

            String data = fileinput.nextLine();
            String temp[] = data.split(";");
            v.add(new adatok(Integer.parseInt(temp[0]), temp[1], temp[2], Integer.parseInt(temp[3])));

        }
        fileinput.close();
        System.out.println("3. feladat: A világranglistán " + v.size() + " versenyző szerepel");

        int nyeremenyosszeg = 0;
        for (adatok e : v) {
            nyeremenyosszeg = Integer.sum(nyeremenyosszeg, e.nyeremeny);
        }

        double atlag = nyeremenyosszeg / v.size();
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("4. feladat: A versenyzők átlagosan " + df.format(atlag) + " fontot kerestek");

        int kinaimax = Integer.MIN_VALUE;
        int hely = 0;

        for (int i = 0; i < v.size(); i++) {
            if (v.get(i).orszag.equals("Kína")) {
                if (v.get(i).nyeremeny > kinaimax) {
                    kinaimax = v.get(i).nyeremeny;

                }
            }

        }

        for (int i = 0; i < v.size(); i++) {
            if (v.get(i).nyeremeny == kinaimax) {
                hely = i;
            }
        }

        System.out.println("5. feladat: A legjobban kereső kínai versenyző:");
        System.out.println("Helyezés: " + v.get(hely).helyezes);
        System.out.println("Név: " + v.get(hely).nev);
        System.out.println("Ország: " + v.get(hely).orszag);
        System.out.println("Nyeremény összege: " + v.get(hely).nyeremeny * 380 + " Ft");

        boolean norvegvane = false;
        for (adatok e : v) {
            if (e.orszag.equals("Norvégia")) {
                norvegvane = true;
            }
        }
        if (norvegvane == true) {
            System.out.println("6. feladat: A versenyzők között van norvég versenyző.");
        }
        if (norvegvane == false) {
            System.out.println("6. feladat: A versenyzők között nincs norvég versenyző.");
        }

        System.out.println("7. feladat: Statisztika");

        HashMap orszagStat = new HashMap<String, Integer>();
        for (adatok e : v) {
            String orszag = e.orszag;
            orszagStat.put(orszag, orszagStat.getOrDefault(orszag, 0));
        }
        
        System.out.println("7. Feladat: Statisztika:");
        for (Object e : orszagStat.entrySet()) {
            if (e.getValue() > 4) {
                System.out.println(e.getKey() + ": " + e.getValue() + " fő");
            }
        }

    }

}
