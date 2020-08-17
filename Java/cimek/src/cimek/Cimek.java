
package cimek;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Cimek {

    public static class ipk {

        String elso;
        String masodik;
        String harmadik;
        String negyedik;
        String otodik;
        String hatodik;
        String hetedik;
        String nyolcadik;

        public ipk(String elso, String masodik, String harmadik, String negyedik, String otodik, String hatodik, String hetedik, String nyolcadik) {
            this.elso = elso;
            this.masodik = masodik;
            this.harmadik = harmadik;
            this.negyedik = negyedik;
            this.otodik = otodik;
            this.hatodik = hatodik;
            this.hetedik = hetedik;
            this.nyolcadik = nyolcadik;
        }

        public String getElso() {
            return elso;
        }

        public String getMasodik() {
            return masodik;
        }

        public String getHarmadik() {
            return harmadik;
        }

        public String getNegyedik() {
            return negyedik;
        }

        public String getOtodik() {
            return otodik;
        }

        public String getHatodik() {
            return hatodik;
        }

        public String getHetedik() {
            return hetedik;
        }

        public String getNyolcadik() {
            return nyolcadik;
        }

    }
    
    static Scanner be = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException, IOException {

        ArrayList<ipk> lista = new ArrayList<>();
        beolvas(lista);
        System.out.println("2. feladat :");
        System.out.println("Az állományban " + lista.size() + " darab adatsor van.");
        feladat4(lista);
        feladat5(lista);
        feladat6(lista);

    }

    public static void beolvas(ArrayList<ipk> lista) throws FileNotFoundException {

        File adat = new File("ip.txt");
        Scanner fileinput = new Scanner(adat);
        while (fileinput.hasNextLine()) {
            String data = fileinput.nextLine();
            String tomb[] = data.split(":");

            lista.add(new ipk(tomb[0], tomb[1], tomb[2], tomb[3], tomb[4], tomb[5], tomb[6], tomb[7]));
        }
        fileinput.close();
    }

    public static void feladat4(ArrayList<ipk> lista) {

        int dokudb = 0;
        int globaldb = 0;
        int helyidb = 0;

        for (ipk e : lista) {

            if (e.elso.equals("2001") && e.masodik.equals("0db8")) {
                dokudb++;
            }

            if (e.elso.equals("2001") && e.masodik.charAt(0) == '0' && e.masodik.charAt(1) == 'e') {
                globaldb++;
            }

            if (e.elso.charAt(0) == 'f' && e.elso.charAt(1) == 'c') {
                helyidb++;
            }
            if (e.elso.charAt(0) == 'f' && e.elso.charAt(1) == 'd') {
                helyidb++;
            }
        }

        System.out.println("4. feladat :");
        System.out.println("Dokumentációs cím: " + dokudb + " darab");
        System.out.println("Globális egyedi cím: " + globaldb + " darab");
        System.out.println("Helyi egyedi cím: " + helyidb + " darab");

    }

    public static void feladat5(ArrayList<ipk> lista) throws IOException {

        PrintWriter pr = new PrintWriter(new FileWriter("sok.txt"));

        int nulladb = 0;
        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < 4; j++) {
                if (lista.get(i).elso.charAt(j) == '0') {
                    nulladb++;
                }
                if (nulladb >= 18) {
                    pr.print(lista.get(i).elso + ":" + lista.get(i).masodik + ":" + lista.get(i).harmadik + ":" + lista.get(i).negyedik
                            + ":" + lista.get(i).otodik + ":" + lista.get(i).hatodik + ":" + lista.get(i).hetedik + ":" + lista.get(i).nyolcadik + "\n"
                    );
                    break;
                }
            }

        }
        pr.close();
    }

    public static void feladat6(ArrayList<ipk> lista) {
        System.out.println("6. feladat :");
        System.out.println("Kérek egy sorszámot :");
        int sorszam = be.nextInt();

       
        
    }

}
