/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otszaz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.Map.Entry;

public class Otszaz {

    static Scanner be = new Scanner(System.in);
    static int vasarlaszam, darabszam;
    static String arunev;

    public static void main(String[] args) {
        ArrayList<vasarlok> lista = new ArrayList<>();
        beolvas(lista);
        System.out.println("2. feladat: A fizetések száma: " + lista.size());
        System.out.println("3. feladat: Az első vásárló: " + lista.get(0).getTermek().size() + " darab terméket vásárolt");
        vasarlaszam = readInt("sorszam") - 1;
        arunev = readString("aru neve");
        darabszam = readInt("darabszam");
        feladat5(lista);
        System.out.println("6. feladat " + darabszam + "ertek: " + ertek(darabszam));
        feladat7(lista);
        feladat8(lista);
        be.close();
    }

    public static void beolvas(ArrayList<vasarlok> lista) {
        try {
            File adat = new File("penztar.txt");
            Scanner fileinput = new Scanner(adat);
            Map<String, Integer> termek = new HashMap<>();
            while (fileinput.hasNextLine()) {
                String data = fileinput.nextLine();

                if (data.equals("F")) {
                    lista.add(new vasarlok(termek));
                    termek.clear();
                } else {
                    if (termek.get(data) == null) {
                        termek.put(data, 1);
                    } else {
                        termek.put(data, termek.get(data) + 1);
                    }

                }

            }
            fileinput.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }

    private static int readInt(String szoveg) {
        System.out.println(szoveg);

        return be.nextInt();
    }

    private static String readString(String szoveg) {
        System.out.println(szoveg);

        return be.next();
    }

    public static void feladat5(ArrayList<vasarlok> lista) {

        boolean ffound = false;
        boolean lfound = false;
        int first = 0, last = 0, db = 0;

        for (int i = 0; i < lista.size(); i++) {
            for (Map.Entry<String, Integer> object : lista.get(i).getTermek().entrySet()) {
                if (object.getKey() != null && object.getKey().equals(arunev)) {
                    if (!ffound) {
                        ffound = true;
                        first = i + 1;
                    }
                    db++;

                }

            }

        }

        for (int i = lista.size() - 1; i >= 0; i--) {

            if (lfound) {
                break;
            }
            for (Map.Entry<String, Integer> object : lista.get(i).getTermek().entrySet()) {
                if (object.getKey() != null && object.getKey().equals(arunev)) {
                    if (!lfound) {
                        lfound = true;
                        last = i + 1;
                        break;
                    }

                }

            }

        }

        System.out.println("első: " + first);
        System.out.println("utolsó: " + last);
        System.out.println("db: " + db);

    }

    public static int ertek(int db) {
        int ar = 0;

        switch (db) {

            case 1:
                ar = 500;
                break;

            case 2:
                ar = 950;
                break;

            default:
                ar = 950 + (400 * (db - 2));
                break;
        }
        return ar;
    }

    public static void feladat7(ArrayList<vasarlok> lista) {

        for (Map.Entry<String, Integer> object : lista.get(vasarlaszam).getTermek().entrySet()) {
            System.out.println(object.getValue() + " " + object.getKey());
        }

    }

    public static void feladat8(ArrayList<vasarlok> lista) {

        for (int i = 0; i < lista.size(); i++) {
              int id=i+1; 
              int ar=0;
         
            
            for (Map.Entry<String, Integer> object : lista.get(i).getTermek().entrySet()) {
                ar+=ertek(object.getValue());
            }

            System.out.println(id+" : "+ar);
        }
    }

}
