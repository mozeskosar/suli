package automata;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Automata {

    public static class csokiadatok {

        int rekeszszam;
        int csokidb;
        int ar;

        public csokiadatok(int rekeszsorszam, int csokidb, int ar) {
            this.rekeszszam = rekeszsorszam;
            this.csokidb = csokidb;
            this.ar = ar;
        }

    }

    public static class vasarloadatok {

        int rekeszsorszam;
        int kivantdb;
        int egycoindb;
        int kettocoindb;
        int otcoindb;
        int tizcoindb;
        int huszcoindb;
        int otvencoindb;
        int szazcoindb;

        public vasarloadatok(int rekeszsorszam, int kivantdb, int egycoindb, int kettocoindb, int otcoindb, int tizcoindb, int huszcoindb, int otvencoindb, int szazcoindb) {

            this.rekeszsorszam = rekeszsorszam;
            this.kivantdb = kivantdb;
            this.egycoindb = egycoindb;
            this.kettocoindb = kettocoindb;
            this.otcoindb = otcoindb;
            this.tizcoindb = tizcoindb;
            this.huszcoindb = huszcoindb;
            this.otvencoindb = otvencoindb;
            this.szazcoindb = szazcoindb;
        }

    }

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<csokiadatok> csokilista = new ArrayList<>();
        ArrayList<vasarloadatok> vasarlolista = new ArrayList<>();
        csokibeolvas(csokilista);
        vasarlobeolvas(vasarlolista);
 
      
        int osszar=0;
        for (csokiadatok object : csokilista) {
            osszar+=object.ar;
        }
        System.out.println("#");
        System.out.println(osszar);
        System.out.println("#");
    
        ArrayList<Integer>rekeszlista=new ArrayList<>();
        for (int i = 0; i < vasarlolista.size(); i++) {
          rekeszlista.add(vasarlolista.get(i).rekeszsorszam);
        }
         LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(rekeszlista);
        ArrayList<Integer> listWithoutDuplicates = new ArrayList<>(hashSet);
        Collections.sort(listWithoutDuplicates);
        for (int i = 0; i < listWithoutDuplicates.size(); i++) {
            System.out.print(listWithoutDuplicates.get(i)+" ");
        }
        System.out.println("");
        System.out.println("#");
        
        
        
        
        
    }

    
    public static void csokibeolvas(ArrayList<csokiadatok> csokilista) throws FileNotFoundException {

        Scanner fileinput = new Scanner(new File("csoki.txt"));
        String elsosor = fileinput.nextLine();
        while (fileinput.hasNextLine()) {
            String data = fileinput.nextLine();
            String[] tomb = data.split(" ");

            csokilista.add(new csokiadatok(Integer.parseInt(tomb[0]), Integer.parseInt(tomb[1]), Integer.parseInt(tomb[2])));

        }

        fileinput.close();
    }

    public static void vasarlobeolvas(ArrayList<vasarloadatok> vasarlolista) throws FileNotFoundException {
        Scanner fileinput = new Scanner(new File("vasarlas.txt"));
        String elsosor = fileinput.nextLine();
        while (fileinput.hasNextLine()) {
            String data = fileinput.nextLine();
            String[] tomb = data.split(" ");

            vasarlolista.add(new vasarloadatok(Integer.parseInt(tomb[0]), Integer.parseInt(tomb[1]), Integer.parseInt(tomb[2]),
                    Integer.parseInt(tomb[3]), Integer.parseInt(tomb[4]), Integer.parseInt(tomb[5]), Integer.parseInt(tomb[6]),
                    Integer.parseInt(tomb[7]), Integer.parseInt(tomb[8])));

        }

        fileinput.close();
    }

}
