/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanciskola;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Tanciskola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        List<String> file = Files.readAllLines(Paths.get("tancrend.txt"));
        ArrayList<Tancosztaly> lista = new ArrayList<Tancosztaly>();

        for (int k = 0; k < file.size(); k += 3) {
            lista.add(new Tancosztaly(file.get(k), file.get(k + 1), file.get(k + 2)));    }
    

        System.out.println("2.feladat");
        System.out.println("Elsõ tánc neve: " + lista.get(0).getKategoria() + ", az utolsóé: " + lista.get(lista.size() - 1).getKategoria());

        feladat3(lista);
        feladat4(lista);
    }

    public static void feladat3(ArrayList<Tancosztaly> lista) {

        int sambaDb = 0;
        for (int i = 1; i < lista.size(); i++) {
            if (lista.get(i).getKategoria().equals("samba")) {
                sambaDb++;
            }
        }
        System.out.println("A sambát " + sambaDb + " pár mutatta be.");

    }
    public static void feladat4(ArrayList<Tancosztaly> lista) {

        System.out.print("Vilma a következő táncokban szerepelt: ");

        for (int i = 1; i < lista.size(); i++) {
            if (lista.get(i).getNoi().equals("Vilma")) {
                System.out.print(lista.get(i).getKategoria() + " ");
            }
        }
 }

}
