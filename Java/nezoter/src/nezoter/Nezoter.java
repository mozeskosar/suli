/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nezoter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Nezoter {

    static Scanner be = new Scanner(System.in);
    static int[] cat = new int[]{0, 0, 0, 0, 0};

    public static void main(String[] args) {

        ArrayList<ArrayList<Character>> kategoria = new ArrayList<>();
        ArrayList<ArrayList<Character>> foglaltsag = new ArrayList<>();
        beolvas("foglaltsag.txt", foglaltsag);
        beolvas("kategoria.txt", kategoria);
        feladat2(foglaltsag);
        feladat3(foglaltsag);
        feladat4(kategoria);
        feladat5(foglaltsag, kategoria);
        feladat6(foglaltsag);
        
        try{feladat7(kategoria,foglaltsag);}catch(IOException e){System.out.println(e);}

    }

    public static void beolvas(String location, ArrayList<ArrayList<Character>> lista) {
        try {
            int index = 0;
            File adat = new File(location);
            Scanner fileinput = new Scanner(adat);

            while (fileinput.hasNextLine()) {
                String sor = fileinput.nextLine();
                lista.add(new ArrayList<Character>());

                for (int i = 0; i < sor.length(); i++) {

                    lista.get(index).add(sor.charAt(i));
                }
                index++;
            }
            fileinput.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }

    public static void feladat2(ArrayList<ArrayList<Character>> lista) {
        System.out.println("Adj meg egy sort");
        int sor = be.nextInt() - 1;
        System.out.println("Adj meg egy szék számot");
        int oszlop = be.nextInt() - 1;

        if (lista.get(sor).get(oszlop) == 'x') {
            System.out.println("foglalt");
        } else {
            System.out.println("szabad");
        }

    }

    public static void feladat3(ArrayList<ArrayList<Character>> lista) {
        int sorhossz = lista.get(0).size();
        int max = lista.size() * sorhossz;
        int db = 0;

        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < lista.get(0).size(); j++) {
                if (lista.get(i).get(j) == 'x') {
                    db++;
                }
            }

        }

        System.out.printf("Eladott jegyek száma: %d db, ez a nézőtér %.0f%%-a\n", db, ((double) db / (double) max) * 100);

    }

    public static void feladat4(ArrayList<ArrayList<Character>> lista) {

        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < lista.get(0).size(); j++) {

                cat[Integer.parseInt(lista.get(i).get(j).toString()) - 1]++;

            }
        }

        int max = 0;
        for (int i = 1; i < cat.length; i++) {
            if (cat[max] < cat[i]) {
                max = i;
            }
        }
        System.out.println("A legtöbbet eladott jegy kategóriája: " + (max + 1));

    }

    public static void feladat5(ArrayList<ArrayList<Character>> lista, ArrayList<ArrayList<Character>> listab) {
        int[] arak = new int[]{5000, 4000, 3000, 2000, 1500};
        cat = new int[]{0, 0, 0, 0, 0};

        int vegosszeg = 0;
        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < lista.get(0).size(); j++) {
                if (lista.get(i).get(j) == 'x') {
                    cat[Integer.parseInt(listab.get(i).get(j).toString()) - 1]++;
                }
            }
        }

        for (int i = 0; i < arak.length; i++) {
            vegosszeg += cat[i] * arak[i];
        }
        System.out.println("Bevétel: " + vegosszeg);

    }

    public static void feladat6(ArrayList<ArrayList<Character>> lista) {
        int db = 0;

        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < lista.get(0).size(); j++) {
                if (lista.get(i).get(j) == 'o') {

                    if (j == 0) {
                        if (lista.get(i).get(j + 1) == 'x') {
                            db++;
                        }

                    } else if (j == lista.get(0).size() - 1 && lista.get(i).get(j - 1) == 'x') {
                        db++;
                    } else if (lista.get(i).get(j - 1) == 'x' && lista.get(i).get(j + 1) == 'x') {
                        db++;
                    }

                }

            }
        }
        System.out.println(db);

    }

    public static void feladat7(ArrayList<ArrayList<Character>> lista, ArrayList<ArrayList<Character>> listab) throws IOException {
    
       PrintWriter pr=new PrintWriter(new FileWriter("szabad.txt"));
        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < lista.get(0).size(); j++) {
                if (listab.get(i).get(j)=='o') {
                   pr.print(lista.get(i).get(j));
                }
                else{
                pr.print('x');
                }
                
            }
            pr.print("\n");
        }
       pr.close();
       
    
    
    }
    
    
    
    
}
