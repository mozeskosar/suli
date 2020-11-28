package playfair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Playfair {

    public static class PlayfairKodolo {

        String bemenet;

        public PlayfairKodolo(String bemenet) throws FileNotFoundException {
            Scanner fileinput = new Scanner(new File(bemenet));
            while (fileinput.hasNextLine()) {
                String data = fileinput.nextLine();
                String temp[] = data.split("\n");
                lista.add(temp[0]);
            }

        }

        public int SorIndex(char index) {
            int hely = 0;
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).contains(String.valueOf(index))) {
                    hely = i;
                }
            }
            return hely;
        }

        public int OszlopIndex(char index) {
            int hely = 0;
            int oszlopja = 0;
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).contains(String.valueOf(index))) {
                    hely = i;
                }
            }

            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(hely).charAt(i) == index) {
                    oszlopja = i;
                }
            }

            return oszlopja;
        }

        public String kodolBetupar(String betupar) {
            char betu1 = betupar.charAt(0);
            char betu2 = betupar.charAt(1);
            int betu1Sor = SorIndex(betu1);
            int betu1Oszlop = OszlopIndex(betu1);
            int betu2Sor = SorIndex(betu2);
            int betu2Oszlop = OszlopIndex(betu2);
           
            if (betu1Sor == betu2Sor) {
                return azonossor(betu1Sor, betu1Oszlop, betu2Oszlop);
            }
           
            if (betu1Oszlop == betu2Oszlop) {
                return azonososzlop(betu1Oszlop, betu1Sor, betu2Sor);
            }
            
            return kodolasTeglalapban(betu1Oszlop, betu1Sor, betu2Oszlop, betu2Sor);
        }

        public String azonossor(int sor, int oszlop1, int oszlop2) {
            char betu1, betu2;
            if (oszlop1 == 4) {
                betu1 = lista.get(sor).charAt(0);
            } else {
                betu1 = lista.get(sor).charAt(oszlop1 + 1);
            }
            if (oszlop2 == 4) {
                betu2 = lista.get(sor).charAt(0);
            } else {
                betu2 = lista.get(sor).charAt(oszlop2 + 1);
            }
            return String.valueOf(betu1) + betu2;
        }

        public String azonososzlop(int oszlop, int sor1, int sor2) {
            char betu1, betu2;
            if (sor1 == 4) {
                betu1 = lista.get(0).charAt(oszlop);
            } else {
                betu1 = lista.get(sor1 + 1).charAt(oszlop);
            }
            if (sor2 == 4) {
                betu2 = lista.get(0).charAt(oszlop);
            } else {
                betu2 = lista.get(sor2 + 1).charAt(oszlop);
            }
            return String.valueOf(betu1) + betu2;
        }

        public String kodolasTeglalapban(int oszlop1, int sor1, int oszlop2, int sor2) {
            char betu1 = lista.get(sor1).charAt(oszlop2);
            char betu2 = lista.get(sor2).charAt(oszlop1);
            return String.valueOf(betu1) + betu2;
        }

    }
    public static ArrayList<String> lista = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        PlayfairKodolo peldany = new PlayfairKodolo("kulcstabla.txt");
        System.out.println("6. feladat - Kérek egy nagybetűt: ");
        Scanner be = new Scanner(System.in);
        String bekert = be.nextLine();
        char index = bekert.charAt(0);
        System.out.println("A karakter sorának az indexe: " + peldany.SorIndex(index));
        System.out.println("A karakter oszlopának az indexe: " + peldany.OszlopIndex(index));
        System.out.println("8. feladat - Kérek egy karakterpárt: ");
        Scanner be2 = new Scanner(System.in);
        String betupar = be2.nextLine();
        System.out.println("Kódolva: " + peldany.kodolBetupar(betupar));

    }

}
