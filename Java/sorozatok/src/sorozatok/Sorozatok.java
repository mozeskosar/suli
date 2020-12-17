package sorozatok;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Sorozatok {

    public static class adatok {

        String datum;
        String sorozat;
        String epizod;
        int hossz;
        boolean latta;

        public adatok(String datum, String sorozat, String epizod, int hossz, boolean latta) {
            this.datum = datum;
            this.sorozat = sorozat;
            this.epizod = epizod;
            this.hossz = hossz;
            this.latta = latta;
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<adatok> lista = new ArrayList<>();
        int szamlalo = 0;
        String temp[] = new String[5];
        Scanner fileinput = new Scanner(new File("lista.txt"));
        while (fileinput.hasNextLine()) {
            String data = fileinput.nextLine();
            temp[szamlalo] = data;
            szamlalo++;
            if (szamlalo == 5) {
                lista.add(new adatok(temp[0], temp[1], temp[2], Integer.parseInt(temp[3]), temp[4].equals("1")));
                szamlalo = 0;
            }
        }
        fileinput.close();

        int nemismert = 0;
        for (adatok e : lista) {
            if (e.datum.equals("NI")) {
                nemismert++;
            }
        }
        System.out.println("2. feladat\nA listában " + (lista.size() - nemismert) + " db vetítési dátummal rendelkező epizód van.\n");

        DecimalFormat df = new DecimalFormat("#.##");
        int lattae = 0;
        for (adatok e : lista) {
            if (e.latta) {
                lattae++;
            }
        }
        double atlagepizod = lattae / Double.parseDouble(String.valueOf(lista.size())) * 100;
        System.out.println("3.feladat\nA listában lévő epizódok " + (df.format(atlagepizod)) + "%-át látta.\n");

        int osszido = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).latta) {
                osszido = Integer.sum(lista.get(i).hossz, osszido);
            }
        }
        int nap = osszido / (24 * 60);
        int ora = osszido / 60 - (nap * 24);
        int perc = osszido - ((ora * 60) + (nap * 24 * 60));
        System.out.println("4.feladat\nSorozatnézéssel " + nap + " napot " + ora + " órát " + perc + " percet töltött.\n");

        Scanner be = new Scanner(System.in);
        System.out.print("5.feladat\nAdjon meg egy dátumot! Dátum=");
        String bekertdatum = be.nextLine();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).latta == false) {
                if (!lista.get(i).datum.equals("NI")) {
                    LocalDate simadatum = stringbolido(lista.get(i).datum);
                    LocalDate bekertd = stringbolido(bekertdatum);

                    if (simadatum.isBefore(bekertd) || simadatum.isEqual(bekertd)) {
                        System.out.println(lista.get(i).epizod + "\t" + lista.get(i).sorozat);

                    }
                }
            }
        }

        System.out.print("\n7.feladat\nAdja meg a hét egy napját(például cs)! Nap= ");
        Scanner benap = new Scanner(System.in);
        String bekertnap = benap.nextLine();
        LinkedHashSet<String> hetnapjasorozat = new LinkedHashSet<>();
        for (adatok e : lista) {
            if (!e.datum.equals("NI")) {
                if (hetnapja(stringbolido(e.datum).getYear(), stringbolido(e.datum).getMonthValue(), stringbolido(e.datum).getDayOfMonth()).equals(bekertnap)) {
                    hetnapjasorozat.add(e.sorozat);
                }
            }
        }

        if (hetnapjasorozat.size() == 0) {
            System.out.println("Az adott napon nem kerül adásba sorozat");
        }

        for (String e : hetnapjasorozat) {
            System.out.println(e);
        }

        PrintWriter pr = new PrintWriter(new FileWriter("summa.txt"));
        HashMap<String, Integer> sorozatesdb = new HashMap<>();
        HashMap<String, Integer> sorozatesosszido = new HashMap<>();
        int szum = 0;

        for (int i = 0; i < lista.size(); i++) {
            sorozatesdb.put(lista.get(i).sorozat, sorozatesdb.getOrDefault(lista.get(i).sorozat, 0) + 1);
            sorozatesosszido.put(lista.get(i).sorozat, sorozatesosszido.getOrDefault(lista.get(i).sorozat, 0) + lista.get(i).hossz);
        }

        sorozatesosszido.keySet().forEach((entry) -> {
            pr.println(entry + " " + sorozatesosszido.get(entry) + " " + sorozatesdb.get(entry));
        });
        pr.close();

    }

    public static String hetnapja(int ev, int ho, int nap) {
        String napok[] = {"v", "h", "k", "sze", "cs", "p", "szo"};
        int honapok[] = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};

        if (ho < 3) {
            ev = ev - 1;

        }
        return napok[(ev + (ev / 4) - (ev / 100) + (ev / 400) + honapok[ho - 1] + nap) % 7];
    }

    public static LocalDate stringbolido(String datum) {

        int ev = Integer.parseInt(datum.charAt(0) + "" + datum.charAt(1) + "" + datum.charAt(2) + "" + datum.charAt(3));
        int honap = Integer.parseInt(datum.charAt(5) + "" + datum.charAt(6));
        int nap = Integer.parseInt(datum.charAt(8) + "" + datum.charAt(9));

        return LocalDate.of(ev, honap, nap);

    }
}
