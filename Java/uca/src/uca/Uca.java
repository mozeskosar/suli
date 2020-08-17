/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uca;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Uca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
      ArrayList<telek>lista=new ArrayList<telek>();
       beolvas(lista); 
       // System.out.println(lista.get(0).getSzelesseg()); 
       
        System.out.println("2. feladat");
        System.out.println("Az eladott telkek száma: "+lista.size());
        
        
        System.out.println("3.feladat");
        feladat3(lista);
        feladat4(lista);
        
    }
    
    public static void beolvas(ArrayList<telek>lista){
   try{
        File adat=new File("kerites.txt");
        Scanner fileinput=new Scanner(adat);
        while(fileinput.hasNextLine()){
        String data=fileinput.nextLine();
        String[]tomb=data.split(" ");
        lista.add(new telek(tomb[0].equals("1"),Integer.parseInt(tomb[1]),tomb[2].charAt(0)));
        
        
        
        }fileinput.close();
              
                }catch(FileNotFoundException e){System.out.println(e);}
    
    }
    
    public static void feladat3(ArrayList<telek>lista){
    String parosvparatlan;
        if (lista.get(lista.size()-1).isOldal()) {
            parosvparatlan="paratlan";
        }else{
        parosvparatlan="paros";
        
        }
        
        int db=0;
        for (int i = 0; i < lista.size()-1; i++) {
            if (lista.get(lista.size()-1).isOldal()==lista.get(i).isOldal()) {
                db++;
            }
        }
        if (lista.get(lista.size()-1).isOldal()) {
            db=db*2+2;
        }
        else{db=db*2+2;}
        System.out.println("A "+parosvparatlan+" oldalon adták el a telket.");
        System.out.println("db: "+db);
    }
    
    public static void feladat4(ArrayList<telek>lista){
    
        int szam = 1;
        
        for (int i = 1; i < lista.size()-2; i++) {
            if (lista.get(i).isOldal()) {
                szam++;
                if((lista.get(i-1).isOldal() && lista.get(i-1).getSzin() == lista.get(i).getSzin()) && lista.get(i).getSzin() != '#'){
                    break;
                }
                
                else if((lista.get(i+1).isOldal() && lista.get(i+1).getSzin() == lista.get(i).getSzin()) && lista.get(i).getSzin() != '#')
                {
                    break;
                }
            }
        }
    
        //szam = szam*2;
        
        System.out.println("db: "+szam);
    
    
    
    
    }
    
    
}
