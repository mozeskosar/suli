/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loves;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.sql.Time;
/**
 *
 * @author User
 */
public class Loves {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Az 1. feladat megoldása");
        System.out.println("Az adatok beolvasása a verseny.txt fájlból");

        BufferedReader beolvas = new BufferedReader(new FileReader("verseny.txt"));
        String sor;
        sor = beolvas.readLine().trim();
        int db = Integer.parseInt(sor);
        String[] lovesek = new String[db];
        int i;
        for (i = 1; i <= db; i++) {
            lovesek[i - 1] = beolvas.readLine();
        }
        beolvas.close();
        System.out.println("A beolvasás megtörtént.\n");

        System.out.println("A 2. feladat megoldása");
        System.out.println("Az egymást követően többször találó versenyzők:");

        for (i = 1; i <= db; i++) {
            if (lovesek[i - 1].contains("++")) {
                System.out.print(i + " ");
            }
        }

        System.out.println("\n\nA 3. feladat megoldása");
        System.out.print("A legtöbb lövést leadó versenyző rajtszáma: ");

        int max = 1;
        for (i = 2; i <= db; i++) {
            if (lovesek[i - 1].length() > lovesek[max - 1].length()) {
                max = i;
            }
        }
        System.out.println(max + "\n");

        System.out.println("A 4. feladat megoldása");
        System.out.println("A loertek függvény elkészítése\n");   // A függvény a main metódus után található 

        System.out.println("Az 5. feladat megoldása");
        System.out.println("Egy versenyző sorszámának bekérése és eredményének kiértékelése");

        Scanner sc = new Scanner(System.in);
        System.out.print("Kérem a versenyző sorszámát (max " + db + "): ");

        int rajtszam = sc.nextInt();
        String sorozat = lovesek[rajtszam - 1];
        int hossz = sorozat.length();

        System.out.println("5. a.");
        System.out.print("Célt érő lövések:");

        for (i = 1; i <= hossz; i++) {
            if (sorozat.substring(i - 1, i).equals("+")) {
                System.out.print(" " + i);
            }
        }

        System.out.println("\n5. b.");
        System.out.print("Az eltalált korongok száma: ");

        int talalatDb = 0;
        for (i = 1; i <= hossz; i++) {
            if (sorozat.substring(i - 1, i).equals("+")) {
                talalatDb++;
            }
        }
        System.out.println(talalatDb);

        System.out.println("5. c.");
        System.out.print("A leghosszabb hibátlan lövéssorozatának hossza: ");   // Az most nem kell, hogy hol kezdődik a hibátlan lövéssorozat. 

        int maxThossz = 0;
        int aktThossz = 0;

        for (i = 1; i <= hossz; i++) {
            if (sorozat.substring(i - 1, i).equals("+")) {
                aktThossz++;
                if (aktThossz > maxThossz) {
                    maxThossz = aktThossz;
                }
            } else {
                aktThossz = 0;
            }
        }
        System.out.println(maxThossz);

        System.out.println("5. d.");
        System.out.print("A lőeredménye: ");

        int pontszam = loertek(sorozat);
        System.out.println(pontszam + " pont \n");
        sc.close();

        System.out.println("A 6. feladat megoldása");
        System.out.println("A verseny végeredményének kiíratása a sorrend.txt fájlba");

        int[] rajtszamok = new int[db];
        int[] pontszamok = new int[db];
        for (i = 1; i <= db; i++) {
            rajtszamok[i - 1] = i;
            pontszamok[i - 1] = loertek(lovesek[i - 1]);
        }

        int j, asztal;
        for (i = db - 1; i >= 1; i--) {
            for (j = 1; j <= i; j++) {
                if (pontszamok[j - 1] < pontszamok[j]) {
                    asztal = rajtszamok[j - 1];
                    rajtszamok[j - 1] = rajtszamok[j];
                    rajtszamok[j] = asztal;

                    asztal = pontszamok[j - 1];
                    pontszamok[j - 1] = pontszamok[j];
                    pontszamok[j] = asztal;
                }
            }
        }

        PrintWriter kiir = new PrintWriter(new FileWriter("sorrend.txt"));

        int aktHelyezes = -1;
        int aktPont = 1000000;
        for (i = 1; i <= db; i++) {
            if (pontszamok[i - 1] < aktPont) {
                aktHelyezes = i;
                aktPont = pontszamok[i - 1];
            }

            kiir.print(aktHelyezes + "\t" + rajtszamok[i - 1]);
            kiir.println("\t" + aktPont);
        }
        kiir.close();
        System.out.println("A sorrend.txt fájl kiíratása befejeződött. \n");
    }

    public static int loertek(String sor) {
        int aktPont = 20;
        int ertek = 0;
        for (int i = 1; i <= sor.length(); i++) {
            if (aktPont > 0 && sor.substring(i - 1, i).equals("-")) {
                aktPont -= 1;
            } else {
                ertek += aktPont;
            }
        }
        int loertek = ertek;
        return loertek;
    }

}
