/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cegesauto;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Cegesauto {
static Scanner input=new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        ArrayList<autok>kocsik=new ArrayList<>();
          beolvas(kocsik);      
        feladat2(kocsik);
        feladat3(kocsik);
        feladat4(kocsik);   
        feladat5(kocsik);
        
        
    input.close();}
 
    public static void beolvas(ArrayList<autok>lista){
    
    try{
        File adat=new File("autok.txt");
        Scanner fileinput=new Scanner(adat);
        
        while(fileinput.hasNextLine()){
        String data=fileinput.nextLine();
        String[]tomb=data.split(" ");
        String[]ido=tomb[1].split(":");
        LocalDateTime temp=LocalDateTime.of(2019, Month.MARCH, Integer.parseInt(tomb[0]), Integer.parseInt(ido[0]), Integer.parseInt(ido[1]),0);
        lista.add(new autok(temp,tomb[2],Integer.parseInt(tomb[3]),Integer.parseInt(tomb[4]),tomb[5].equals("1")));
        }fileinput.close();
              
                }catch(FileNotFoundException e){System.out.println(e);} 
    }
    
      public static void feladat2(ArrayList<autok>lista){
      
          System.out.println("2.feladat");
          for (int i = lista.size()-1; i >= 0; i--) {
              if (!(lista.get(i).isKibe())) {
                  System.out.println(lista.get(i).getDatum().getDayOfMonth()+".nap rendzsám: "+lista.get(i).getRendszam());
                  break;
              }
              
          }      }
          
          public static void feladat3(ArrayList<autok>lista){
            System.out.println("3.feladat");
              System.out.print("Nap: ");
              int nap=input.nextInt();
          
              System.out.println("A forgalom a"+nap+" napon:");  
              
              for (autok object : lista) {
                  if (object.getDatum().getDayOfMonth()==nap) {
                      String ki="ki";
                      if (object.isKibe()) {
                          ki="be";
                      }
                      
                  System.out.println(object.getDatum().getHour()+":"+object.getDatum().getMinute()+":"+object.getRendszam()+":"+object.getAzon()+":"+ki);
                  }
              }
              
          }
          
          public static void feladat4(ArrayList<autok>lista){
              System.out.println("4.feladat");
        Map<String,Integer> data=new HashMap<String,Integer>();  
              for (autok object : lista) {
                  if (data.get(object.getRendszam())==null){
                      data.put(object.getRendszam(),1);
                  }else{
                  data.put(object.getRendszam(), data.get(object.getRendszam())+1);
                  }
              }
      
              int db=0;
              for (int object : data.values()) {
                  if (object %2==1) {
                      db++;
                  }
              }
          
              System.out.println("db "+db);
          }

  public static void feladat5(ArrayList<autok>lista){
  Long rendszamdb=lista.stream().map(kaka -> kaka.getRendszam()).distinct().count();
      System.out.println("A különböző rendszámok: "+rendszamdb);
  
  }  
    
    }
    
    
    

