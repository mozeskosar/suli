/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultrabalaton;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Ultrabalaton {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
       ArrayList<balatonosztaly> lista=new ArrayList<>();
        BufferedReader br=new BufferedReader(new FileReader("ub2017egyeni.txt"));
        String sor="";
        while((sor=br.readLine())!=null){
        String darabok[]=sor.split(";");
       
        String versenyzonev=darabok[0];
        String rajtszam=darabok[1];
        String versenyzokategoria=darabok[2];
        String idoeredmeny=darabok[3];
        String tavszazalek=darabok[4];
       balatonosztaly b=new balatonosztaly(versenyzonev,rajtszam,versenyzokategoria,idoeredmeny,tavszazalek);
        lista.add(b);}
      
        br.close();  
        
        System.out.println("3.feladat");
        int osszversenyzo=lista.size()-1;
            System.out.println("Összes versenyző: "+osszversenyzo);
        
        System.out.println("4.feladat");
       int noiedb=0;
            for (int i = 0; i < osszversenyzo; i++) {
                
                if (lista.get(i).versenyzokategoria.equals("Noi")&&lista.get(i).tavszazalek.equals("100")) {
                    noiedb++;                    
                } }
       

        System.out.println("Összes női versenyző: "+noiedb+" fő");
    

        
        System.out.println("5.feladat");
        
        Scanner be=new Scanner(System.in);
        String bekertnev=be.nextLine();
        for (int i = 0; i < 10; i++) {
            
       
        if (lista.get(i).versenyzonev.equals(bekertnev)) {
            System.out.println("Indult a sportoló");
        }else{System.out.println("Nem indult");}
         }
        
        

  } }