/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesztverseny;

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
public class Tesztverseny {

    static Scanner input = new Scanner(System.in);
    static int bekert;
    static int tomb[] = new int[]{3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 6};

    public static void main(String[] args) {

        ArrayList<Class> lista = new ArrayList<Class>();
        beolvas(lista);
        System.out.println("2.feladat");
        System.out.println(lista.size());
        feladat3(lista);
        feladat4(lista);
        feladat5(lista);
        try{
        feladat6(lista);}
        catch(IOException e){System.out.println(e.getMessage());}
        Collections.sort(lista);
        
        feladat7(lista);
    }

    public static void beolvas(ArrayList<Class> lista) {
        try {
            File adat = new File("valaszok.txt");
            Scanner fileinput = new Scanner(adat);
            Class.helyesvalasz = fileinput.nextLine();
            while (fileinput.hasNextLine()) {
                String[] tomb = fileinput.nextLine().split(" ");

                lista.add(new Class(tomb[0], tomb[1]));
            }
            fileinput.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }

    public static void feladat3(ArrayList<Class> lista) {
        System.out.println("3.feladat");
        String be = input.next();
        bekert = 0;
        for (Class class1 : lista) {
            if (class1.getAzonosito().equals(be)) {
                System.out.println(class1.getValasz());
                bekert++;
                break;

            }
        }

    }

    public static void feladat4(ArrayList<Class> lista) {
        System.out.println(Class.helyesvalasz);
        String valasz = lista.get(bekert - 1).getValasz();
        for (int i = 0; i < valasz.length(); i++) {
            if (Class.helyesvalasz.charAt(i) == valasz.charAt(i)) {
                System.out.print("+");
            } else {
                System.out.print(" ");
            }
        }

    }

    public static void feladat5(ArrayList<Class> lista) {
        System.out.println("5.feladat");
        System.out.println("feladat sorszáma: ");
        int sorszam = input.nextInt() - 1;
        int helyes = 0;

        for (Class class1 : lista) {
            if (class1.getValasz().charAt(sorszam) == Class.helyesvalasz.charAt(sorszam)) {
                helyes++;
            }

        }
        double szazalek = (double) helyes / (double) lista.size() * 100;
        System.out.println("A feladatra " + helyes + " fő");
        System.out.println(String.format("%.2f ", szazalek));
    }

    public static void feladat6(ArrayList<Class> lista) throws IOException {
            System.out.println("6.feladat");
        FileWriter fr=new FileWriter("pontok.txt");
            PrintWriter pr=new PrintWriter(fr);
            for (Class class1 : lista) {
            class1.setPont(pontkalkulator(class1));
        pr.printf("%s %d\n", class1.getAzonosito(),class1.getPont());
            
            }
            
            
            pr.close();
        
    }

  
    public static void feladat7(ArrayList<Class> lista) {
    int elozo=-1;
    int fennmarado=3;
    int index=0;
     
        for (Class class1 : lista) {
             if (fennmarado>0&& index<3) {
                 if (class1.getPont()!=elozo) {
                     index++;
                     fennmarado--;
                     elozo=class1.getPont();
                 }
                 System.out.println(String.format("%d.díj(%d pont): %s", index,class1.getPont(),class1.getAzonosito()));             
             }
   
         }

     }

public static int pontkalkulator(Class c){
int pont=0;
    for (int i = 0; i < c.getValasz().length(); i++) {
        if (c.getValasz().charAt(i)==Class.helyesvalasz.charAt(i)) {
          pont+=tomb[i];  
        }
        
    }
return pont;
}
}

