
package jaror;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;


public class Jaror {

    public static class jarmuvek{
    
        LocalTime ido;
        String rendszam;

        public jarmuvek(LocalTime ido, String rendszam) {
            this.ido = ido;
            this.rendszam = rendszam;
        }
    
    
    
    }

    public static void main(String[] args) throws FileNotFoundException {
    
       ArrayList<jarmuvek>lista=new ArrayList<jarmuvek>();
        beolvas(lista);
       int  munkaido=lista.get(lista.size()-1).ido.getHour()-lista.get(0).ido.getHour();
        System.out.println("2. feladat: A járőrök "+munkaido+" órát dolgoztak!");
      
        
    }
    
    public static void beolvas(ArrayList<jarmuvek>lista) throws FileNotFoundException{
    
        Scanner fileinput=new Scanner(new File("jarmu.txt"));
        while(fileinput.hasNextLine()){
        String data=fileinput.nextLine();
        String tomb[]=data.split(" ");
        lista.add(new jarmuvek(LocalTime.of(Integer.parseInt(tomb[0]), Integer.parseInt(tomb[1]), Integer.parseInt(tomb[2])),tomb[3]));
        
        }
        fileinput.close();
    
    }
    
}
