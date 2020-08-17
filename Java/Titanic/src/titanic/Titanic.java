/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package titanic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Titanic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //File beolvasása és tárolása
        ArrayList<Tosztaly> lista = new ArrayList<>();

        try {
            FileReader fajl = new FileReader("titanic.txt");
            BufferedReader br = new BufferedReader(fajl);
            String sor = " ";
            while ((sor = br.readLine()) != null) {

                String[] darabok = sor.split(";");
    //0.,1.,2., elem van

                String kategoria = darabok[0];
                int eltunt = Integer.parseInt(darabok[1]);
                int tulelok = Integer.parseInt(darabok[2]);
                Tosztaly t = new Tosztaly(kategoria, tulelok, eltunt);
                lista.add(t);

            }
            br.close();

        } catch (IOException e) {
            System.out.println("HIBA a beolvasáskor!" + e);
        }

        System.out.println("Az adatok beolvasva");

       
        



      //2.Határozza meg, és írja ki a képernyőre a minta szerint, hogy az állományban hány kategória(adatsor)található!

        System.out.println("2.feladat");
        System.out.println("Kategóriák száma:" + lista.size());

     
        
        
        
        
        //3.Állapítsa meg és írja ki a képernyőre a minta szerint, hogy a kategóriákban összesen hány személy található! 

        System.out.println("3.feladat");
        int osszletszam = 0;
        for (int i = 0; i < lista.size(); i++) {
            osszletszam += lista.get(i).eltuntek + lista.get(i).tulelok;
        }
        System.out.println("Ennyi személy található a listában: " + osszletszam);

       
        
        
        
        
        
        
       //4.Kérjen be a felhasználótól kereséshez egy kulcsszót vagy a kulcsszó egy részét! Állapítsa
        //meg, hogy a megadott karakterlánc megtalálható-e a kategóriák neveiben! A keresés eredményét „Van találat!”, vagy „Nincs találat!” formában írja ki a képernyőre!


        System.out.println("4.feladat");
        Scanner be = new Scanner(System.in);
        System.out.print("Kérem a kulcsszót");
        String kulcsszo = be.next();

        boolean van = false;
        int index = 0;
        while (van == false && index < lista.size()) {
            if (lista.get(index).kategoria.contains(kulcsszo)) {
                van = true;
            } else {
                index++;
            }
        }
        if (van) {
            System.out.println("Van ilyen előfordulás!");
        } else {
            System.out.println("Nincs ilyen előfordulás!");
        }

      
        
        
        
        
        
        
        
      
      //5.feladatHa az előző feladatban volt találat a kategóriára, akkor listázza ki a keresésnek megfelelő kategóriák nevét és a kategóriákba sorolt utasok létszámát a minta szerint!   

        System.out.println("5.feladat");
        if (van) {
            for (Tosztaly elem : lista) {
                if (elem.kategoria.contains(kulcsszo)) {
                    System.out.print(elem.kategoria + ": ");
                    int letszam = elem.tulelok + elem.eltuntek;
                    System.out.println(letszam);

                }

            }
   }
            
        
        
        
        
        
        
        
        
        
        
        
        //6.Készítsen listát azon kategóriákról, ahol az eltűntek aránya meghaladta a 60%-ot! Az elkészült listát írja ki a képernyőre a minta szerint! 

        System.out.println("6.feladat");
            for (Tosztaly elem : lista) {
                if ((double) elem.eltuntek / (elem.eltuntek + elem.tulelok) > 0.6) {

                }
                System.out.println(elem.kategoria);
            }

     
        
            
            
            
            
            
            
            //7.Határozza meg és írja ki a képernyőre a minta szerint, hogy melyik kategóriában volt a
            //legtöbb túlélő! Feltételezheti, hogy a kategóriák nem tartalmaznak azonos számú túlélőt. 
            System.out.println("7.feladat");
            int max=lista.get(0).tulelok;
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).tulelok>max) {
                    max=lista.get(i).tulelok;
                }
        }  for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).tulelok == max) {
                System.out.println(lista.get(i).kategoria);
        }
        }
            
            

        
        
        
    }
}
