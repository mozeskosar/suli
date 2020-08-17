/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Tanc {

    public static class tancok {

        String tanc;

        public tancok(String tanc) {
            this.tanc = tanc;
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<tancok> lista = new ArrayList<>();
        beolvas(lista);
        System.out.println(lista.size());
        
    }

    public static void beolvas(ArrayList<tancok> lista) throws FileNotFoundException {
        Scanner fileinput = new Scanner(new File("tancrend.txt"));
        while (fileinput.hasNextLine()) {
            String data = fileinput.nextLine();
            String tomb[] = data.split("\n");
            lista.add(new tancok(tomb[0]));

        }
        fileinput.close();

    }

}
