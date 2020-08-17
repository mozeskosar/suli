/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lezerloveszet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author felhaszn
 */
public class LezerLoveszet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<JatekosLovese>lista=new ArrayList<JatekosLovese>();
        beolvas(lista);
        System.out.println("5. feladat: Lövések száma: "+lista.size()+" db");
//        System.out.println(JatekosLovese.Tavolsag(3.0, 4.0));
        
    double min=999.1;
    int lovessorszam=0;

        for (int i = 0; i < lista.size(); i++) {
            if (JatekosLovese.Tavolsag(lista.get(i).getLovesx(), lista.get(i).getLovesy())<min) { 
                min=JatekosLovese.Tavolsag(lista.get(i).getLovesx(), lista.get(i).getLovesy());
                lovessorszam=i;
            }
        }
        System.out.println("7. feladat: Legpontosabb lövés: ");
        System.out.print(lista.get(lovessorszam).getSorszam()+".; "); // ,lista.get(lovessorszam).getNev(),lista.get(lovessorszam).getLovesx(),lista.get(lovessorszam).getLovesy(),min);
        System.out.print(lista.get(lovessorszam).getNev()+"; ");
        System.out.print(lista.get(lovessorszam).getLovesx()+"; ");
        System.out.print(lista.get(lovessorszam).getLovesy()+"; ");
        System.out.print(min);
        System.out.println();
        
//        System.out.println("*"+JatekosLovese.Pontszam(26.99,33.00)); 
        int nullapontosdb=0;
        for (int i = 0; i < lista.size(); i++) {
            if (JatekosLovese.Pontszam(lista.get(i).getLovesx(), lista.get(i).getLovesy())==0) {
                nullapontosdb++;
            }
        }
        System.out.println("9. feladat: Nulla pontos lövések száma: "+nullapontosdb);
        
        Long jatekosszam=lista.stream().map(mapper -> mapper.getNev()).distinct().count();
        System.out.println("10. feladat: Játékosok száma: "+jatekosszam);
        
    }

    
     public static void beolvas(ArrayList<JatekosLovese> lista) {
        try {
            int lovesdb=0;
            File adat = new File("lovesek.txt");
            Scanner fileinput = new Scanner(adat);
            String celtablakordinatak=fileinput.nextLine();
            String[] tomb2 = celtablakordinatak.split(";");
           JatekosLovese.celtablax=Double.parseDouble(tomb2[0].replace(",", ".")); 
           JatekosLovese.celtablay=Double.parseDouble(tomb2[1].replace(",", "."));
            while (fileinput.hasNextLine()) {
                String data = fileinput.nextLine();
                String[] tomb = data.split(";");
                
                lista.add(new JatekosLovese(tomb[0], Double.parseDouble(tomb[1].replace(",", ".")), Double.parseDouble(tomb[2].replace(",", ".")),lovesdb++,0));
            }
            fileinput.close();

        } catch (IOException e) {
            System.out.println(e);
        }

    }
    

     
}