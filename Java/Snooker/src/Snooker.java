import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

        ArrayList<adatok> lista = new ArrayList<>();
        Scanner fileinput = new Scanner(new File("snooker.txt"));
        String elsosor = fileinput.nextLine();
        while (fileinput.hasNextLine()) {

            String data = fileinput.nextLine();
            String tomb[] = data.split(";");
            lista.add(new adatok(Integer.parseInt(tomb[0]), tomb[1], tomb[2], Integer.parseInt(tomb[3])));
        }
        fileinput.close();
        System.out.println("3. feladat: A világranglistán " + lista.size() + " versenyző szerepel");
        DecimalFormat df = new DecimalFormat("#.##");
        int atlagint = 0;
        for (int i = 0; i < lista.size(); i++) {
            atlagint = Integer.sum(atlagint, lista.get(i).nyeremeny);
        }
        double atlag = atlagint;
        System.out.println("4. feladat: A versenyzők átlagosan " + df.format(atlag) + " fontot kerestek");

        int kinaimax = 0;
        int kinaihely = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).orszag.equals("Kína")) {
                if (lista.get(i).nyeremeny > kinaimax) {
                    kinaimax = lista.get(i).nyeremeny;
                    kinaihely = i;
                }

            }
        }
        System.out.println("5. feladat: A legjobban kereső kínai versenyző:");
        System.out.println("Helyezés: " + lista.get(kinaihely).helyezes);
        System.out.println("Név: " + lista.get(kinaihely).nev);
        System.out.println("Ország: " + lista.get(kinaihely).orszag);
        System.out.println("Nyeremény összege: " + lista.get(kinaihely).nyeremeny * 380 + " Ft");

        boolean norvege = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).orszag.equals("Norvégia")) {
                norvege = true;
            }
        }
        if (norvege) {
            System.out.println("6. feladat: A versenyzők között van norvég versenyző.");
        } else {
            System.out.println("6. feladat: A versenyző között nincs norvég versenyző");
        }
        System.out.println("7. feladat: Statisztika");
        HashMap<String, Integer> versenyzok = new HashMap<>();
        for (int i = 0; i < lista.size(); i++) {
            versenyzok.put(lista.get(i).orszag, versenyzok.getOrDefault(lista.get(i).orszag, 0) + 1);
        }
        for (Map.Entry<String, Integer> e : versenyzok.entrySet()) {
            if (e.getValue() > 4) {
                System.out.println(e.getKey() + " - " + e.getValue() + " fő");
            }

        }

    }
}
