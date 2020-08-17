/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helyjegy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Helyjegy {

    public static class jegyek {

        private int ules;
        private int felszallas;
        private int leszallas;

        public jegyek(int ules, int felszallas, int leszallas) {
            this.ules = ules;
            this.felszallas = felszallas;
            this.leszallas = leszallas;
        }

        public int getUles() {
            return ules;
        }

        public int getFelszallas() {
            return felszallas;
        }

        public int getLeszallas() {
            return leszallas;
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<jegyek> lista = new ArrayList<>();
        beolvas(lista);
        feladat2(lista);
        feladat3(lista);
        feladat4(lista);
        feladat5(lista);
        feladat6(lista);

    }

    public static void beolvas(ArrayList<jegyek> lista) throws FileNotFoundException {

        File adat = new File("eladott.txt");
        Scanner fileinput = new Scanner(adat);
        while (fileinput.hasNextLine()) {
            String data = fileinput.nextLine();
            String tomb[] = data.split(" ");
            lista.add(new jegyek(Integer.parseInt(tomb[0]), Integer.parseInt(tomb[1]), Integer.parseInt(tomb[2])));

        }

        fileinput.close();

    }

    public static void feladat2(ArrayList<jegyek> lista) {

        System.out.println("2. feladat: Az utolsó ülésének azonosítója: " + lista.get(lista.size() - 1).ules + " A beutazott távolság: " + ((lista.get(lista.size() - 1).leszallas) - (lista.get(lista.size() - 1).felszallas)));

    }

    public static void feladat3(ArrayList<jegyek> lista) {
        System.out.println("3. feladat: Akik végigutazták az egész útvonalat: ");
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).felszallas == 0 && lista.get(i).leszallas == 172) {
                System.out.println(lista.get(i).ules);
            }
        }

    }

    public static void feladat4(ArrayList<jegyek> lista) {
        ArrayList<Integer> bevetel = new ArrayList<>();
        int jegybevetel = 0;
        for (int i = 0; i < lista.size(); i++) {
            bevetel.add(((lista.get(i).leszallas) - (lista.get(i).felszallas) / 10) * 71);
        }
//        System.out.println(bevetel);

        int osszeg = 0;
        for (int i = 0; i < bevetel.size(); i++) {
            if (bevetel.get(i) > 0) {
                osszeg += bevetel.get(i);
            }
        }

        System.out.println("4. feladat: A bevételből származó összeg: " + osszeg + " Ft");
    }

    public static void feladat5(ArrayList<jegyek> lista) {
        ArrayList<Integer> renfel = new ArrayList<>();
        for (jegyek e : lista) {
            renfel.add(e.felszallas);
        }
        Collections.sort(renfel);

        ArrayList<Integer> renle = new ArrayList<>();
        for (jegyek e : lista) {
            renle.add(e.leszallas);
        }
        Collections.sort(renle);

        int feldb = 0;
        int ledb = 0;

        for (int i = 0; i < lista.size(); i++) {

            if (renfel.get(i) == 172) {
                feldb++;
            }

        }

        for (int i = 0; i < lista.size(); i++) {

            if (renle.get(i) == 172) {
                ledb++;
            }

        }

        System.out.println("5. feladat: Az utolsó elötti megállóban ennyien szálltak fel: " + feldb + " és ennyien le: " + ledb);

    }

    public static void feladat6(ArrayList<jegyek> lista) {

        Long megallole = lista.stream().map(mapper -> mapper.leszallas).distinct().count();
        System.out.println("6. feladat: a busz: " + megallole  + " db megallóba állt meg.");
    }

    
    public static void feladat7(ArrayList<jegyek> lista) throws IOException {
    
        
        PrintWriter pr=new PrintWriter(new FileWriter("kihol.txt"));
     
        
        
    
    }
}
