package hianyzasok;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hianyzasok {

    static Scanner be = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<naplo> lista = new ArrayList<>();

        beolvas(lista);
        System.out.println("2. feladat: " + feladat2(lista));
        System.out.println("3. feladat " + karakterkereso('X', lista) + " " + karakterkereso('I', lista));
        int honap = ReadInt("Hónap= ");
        int nap = ReadInt("nap= ");
        System.out.println("Azon a napon " + hetnapja(honap, nap) + " volt");

        String napnev = ReadString("nap= ");
        int ora = ReadInt("óra= ");
            
        System.out.println("hiányzások száma: "+feladat6(napnev, ora, lista));
        be.close();
    }

    public static void beolvas(ArrayList<naplo> lista) {
        try {
            File adat = new File("naplo.txt");
            Scanner fileinput = new Scanner(adat);
            int id = -1;
            while (fileinput.hasNextLine()) {
                String data = fileinput.nextLine();
                String tomb[] = data.split(" ");

                if (data.charAt(0) == '#') {
                    lista.add(new naplo(Integer.parseInt(tomb[1]), Integer.parseInt(tomb[2]), new ArrayList<>()));
                    id++;
                } else {

                    lista.get(id).tanulohozzadas(new tanulok(tomb[0] + " " + tomb[1], tomb[2]));
                }

            }
            fileinput.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }

    public static int feladat2(ArrayList<naplo> lista) {
        int tanulodb = 0;

        for (naplo e : lista) {
            tanulodb += e.getTanulolista().size();

        }

        return tanulodb;
    }

    public static int karakterkereso(char c, ArrayList<naplo> lista) {
        int db = 0;
        for (naplo object : lista) {
            for (tanulok t : object.getTanulolista()) {
                for (int i = 0; i < t.getOrak().length(); i++) {

                    if (t.getOrak().charAt(i) == c) {
                        db++;
                    }

                }
            }

        }

        return db;
    }

    public static String hetnapja(int honap, int nap) {
        String[] hetnapjai = {"Vasárnap", "Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat"};
        int[] napok = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 335};
        int index = (napok[honap - 1] + nap) % 7;

        return hetnapjai[index];
    }

    public static int ReadInt(String text) {
        System.out.println(text);
        return be.nextInt();
    }

    public static String ReadString(String text) {
        System.out.println(text);
        return be.next();
    }

    public static int feladat6(String napnev, int ora, ArrayList<naplo> lista) {
        int db = 0;
        for (naplo e : lista) {
            if (hetnapja(e.getHonap(), e.getNap()).equals(napnev)) {
                for (tanulok tanulo : e.getTanulolista()) {
                    if (tanulo.getOrak().charAt(ora - 1) == 'X' || tanulo.getOrak().charAt(ora - 1) == 'I') {
                        db++;
                    }

                }
            }
        }

        return db;
    }

}
