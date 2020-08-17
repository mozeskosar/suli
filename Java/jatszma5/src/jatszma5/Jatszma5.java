/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jatszma5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Jatszma5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
    ArrayList<String>lista=(ArrayList<String>) Files.readAllLines(Paths.get("labdamenetek5.txt"));
        System.out.println("3.feladat: A labdamenetek száma: "+lista.size()); 
        feladat4(lista);
        feladat5(lista);
        
        
    }
    
    public static void feladat4(ArrayList<String>lista){
    double adogatodb=0;
    
        for (String e : lista) {
            if (e.equals("A")) {
                adogatodb++;
            }
           
        } 
        System.out.println("4.feladat: Az adogató játékos "+((adogatodb/lista.size())*100)+"%-ban nyerte meg a labdameneteket");
    }
    
    public static void feladat5(ArrayList<String>lista){
   
        int max=0;
        int temp=0;
        for (int i = 0; i < lista.size(); i++) {
            temp=0;
            
            if (lista.get(i).equals("A")) {
                
             
                for (int j = i; j < lista.size(); j++) {
                    if (lista.get(j).equals("A")) {
                        temp++;
                    }
                    else{break;}
                }
            
                if (temp>max) {
                    max=temp;
                }
            
            }
        }
        System.out.println(max);
     
    }
     
   public static void jatszma(ArrayList<String>lista){
   
   
   
   }
    
    
    
    }
    
    

