package szalloda;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Szalloda {

    public static class pitypangszallo {

        int foglalasszam;
        int szobaszam;
        int erkezes;
        int tavozas;
        int vendegekszama;
        int reggelise;
        String azonosito;

        public pitypangszallo(int foglalasszam, int szobaszam, int erkezes, int tavozas, int vendegekszama, int reggelise, String azonosito) {
            this.foglalasszam = foglalasszam;
            this.szobaszam = szobaszam;
            this.erkezes = erkezes;
            this.tavozas = tavozas;
            this.vendegekszama = vendegekszama;
            this.reggelise = reggelise;
            this.azonosito = azonosito;
        }

    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<pitypangszallo> lista = new ArrayList<pitypangszallo>();
        beolvas(lista);

        int maxidotartam = 0;
        int azon = 0;
        for (int i = 0; i < lista.size(); i++) {
            int segedmax = lista.get(i).tavozas - lista.get(i).erkezes;
            if (segedmax > maxidotartam) {
                maxidotartam = segedmax;
                azon = i;
            }
        }
        System.out.println("2. feladat:");
        System.out.println(lista.get(azon).azonosito + " (" + lista.get(azon).erkezes + ") - " + maxidotartam);

        PrintWriter pr = new PrintWriter(new FileWriter("bevetel.txt"));

        int tavasziosszeg = 0;
        int nyariosszeg = 0;
        int osziosszeg = 0;
        int szobaosszeg1 = 0;
        int reggeliosszeg1 = 0;

        for (int i = 0; i < lista.size(); i++) {

            //tavaszi
            if (lista.get(i).erkezes <= 1 && lista.get(i).tavozas <= 120) {
                int eltoltottnap = lista.get(i).tavozas - lista.get(i).erkezes;
                if (lista.get(i).vendegekszama < 2) {
                    szobaosszeg1 = eltoltottnap * (((lista.get(i).vendegekszama - 2) * 2000) + 2 * 9000);
                    if (lista.get(i).reggelise == 1) {
                        reggeliosszeg1 = (lista.get(i).vendegekszama * 1100) * eltoltottnap;
                    }
                    tavasziosszeg = szobaosszeg1 + reggeliosszeg1;

                } else if (lista.get(i).vendegekszama == 2) {

                    szobaosszeg1 = (2 * 9000) * eltoltottnap;
                    if (lista.get(i).reggelise == 1) {
                        reggeliosszeg1 = (lista.get(i).vendegekszama * 1100) * eltoltottnap;
                    }
                    tavasziosszeg = szobaosszeg1 + reggeliosszeg1;

                } else if (lista.get(i).vendegekszama == 1) {
                    szobaosszeg1 = eltoltottnap * 9000;
                    if (lista.get(i).reggelise == 1) {
                        reggeliosszeg1 = 1100 * eltoltottnap;
                    }
                    tavasziosszeg = szobaosszeg1 + reggeliosszeg1;
                }

                pr.print(lista.get(i).foglalasszam + "-" + tavasziosszeg + "\n");
            } //nyari
            if (lista.get(i).erkezes <= 121 && lista.get(i).tavozas <= 243) {
                int eltoltottnap = lista.get(i).tavozas - lista.get(i).erkezes;
                if (lista.get(i).vendegekszama < 2) {
                    szobaosszeg1 = eltoltottnap * (((lista.get(i).vendegekszama - 2) * 2000) + 2 * 10000);
                    if (lista.get(i).reggelise == 1) {
                        reggeliosszeg1 = (lista.get(i).vendegekszama * 1100) * eltoltottnap;
                    }
                    tavasziosszeg = szobaosszeg1 + reggeliosszeg1;

                } else if (lista.get(i).vendegekszama == 2) {

                    szobaosszeg1 = (2 * 10000) * eltoltottnap;
                    if (lista.get(i).reggelise == 1) {
                        reggeliosszeg1 = (lista.get(i).vendegekszama * 1100) * eltoltottnap;
                    }
                    tavasziosszeg = szobaosszeg1 + reggeliosszeg1;

                } else if (lista.get(i).vendegekszama == 1) {
                    szobaosszeg1 = eltoltottnap * 10000;
                    if (lista.get(i).reggelise == 1) {
                        reggeliosszeg1 = 1100 * eltoltottnap;
                    }
                    tavasziosszeg = szobaosszeg1 + reggeliosszeg1;
                }

                pr.print(lista.get(i).foglalasszam + "-" + tavasziosszeg + "\n");
            } //oszi
            if (lista.get(i).erkezes <= 244 && lista.get(i).tavozas <= 335) {
                int eltoltottnap = lista.get(i).tavozas - lista.get(i).erkezes;
                if (lista.get(i).vendegekszama < 2) {
                    szobaosszeg1 = eltoltottnap * (((lista.get(i).vendegekszama - 2) * 2000) + 2 * 8000);
                    if (lista.get(i).reggelise == 1) {
                        reggeliosszeg1 = (lista.get(i).vendegekszama * 1100) * eltoltottnap;
                    }
                    tavasziosszeg = szobaosszeg1 + reggeliosszeg1;

                } else if (lista.get(i).vendegekszama == 2) {

                    szobaosszeg1 = (2 * 8000) * eltoltottnap;
                    if (lista.get(i).reggelise == 1) {
                        reggeliosszeg1 = (lista.get(i).vendegekszama * 1100) * eltoltottnap;
                    }
                    tavasziosszeg = szobaosszeg1 + reggeliosszeg1;

                } else if (lista.get(i).vendegekszama == 1) {
                    szobaosszeg1 = eltoltottnap * 8000;
                    if (lista.get(i).reggelise == 1) {
                        reggeliosszeg1 = 1100 * eltoltottnap;
                    }
                    tavasziosszeg = szobaosszeg1 + reggeliosszeg1;
                }

                pr.print(lista.get(i).foglalasszam + "-" + tavasziosszeg + "\n");
            }

        }

        pr.close();

    }

    public static void beolvas(ArrayList<pitypangszallo> lista) throws FileNotFoundException {

        Scanner fileinput = new Scanner(new File("pitypang.txt"));
        String elsosor = fileinput.nextLine();
        while (fileinput.hasNextLine()) {

            String data = fileinput.nextLine();
            String tomb[] = data.split(" ");
            lista.add(new pitypangszallo(Integer.parseInt(tomb[0]), Integer.parseInt(tomb[1]), Integer.parseInt(tomb[2]), Integer.parseInt(tomb[3]),
                    Integer.parseInt(tomb[4]), Integer.parseInt(tomb[5]), tomb[6]));

        }

        fileinput.close();
    }

}
