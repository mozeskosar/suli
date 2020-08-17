
package furdostat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Furdostat {

    public static class furdok {

        private int vendegazonosito;
        private int furdoazonosito;
        private int bevagyki;
        private int ora;
        private int perc;
        private int masodprec;

        public furdok(int vendegazonosito, int furdoazonosito, int bevagyki, int ora, int perc, int masodprec) {
            this.vendegazonosito = vendegazonosito;
            this.furdoazonosito = furdoazonosito;
            this.bevagyki = bevagyki;
            this.ora = ora;
            this.perc = perc;
            this.masodprec = masodprec;
        }

        public int getVendegazonosito() {
            return vendegazonosito;
        }

        public int getFurdoazonosito() {
            return furdoazonosito;
        }

        public int getBevagyki() {
            return bevagyki;
        }

        public int getOra() {
            return ora;
        }

        public int getPerc() {
            return perc;
        }

        public int getMasodprec() {
            return masodprec;
        }

    }

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<furdok> lista = new ArrayList<furdok>();
        beolvas(lista);
        feladat2(lista);
        feladat3(lista);

    }

    public static void beolvas(ArrayList<furdok> lista) throws FileNotFoundException {

        File adat = new File("furdoadat.txt");
        Scanner fileinput = new Scanner(adat);

        while (fileinput.hasNextLine()) {
            String data = fileinput.nextLine();
            String tomb[] = data.split(" ");
            lista.add(new furdok(Integer.parseInt(tomb[0]), Integer.parseInt(tomb[1]), Integer.parseInt(tomb[2]), Integer.parseInt(tomb[3]), Integer.parseInt(tomb[4]), Integer.parseInt(tomb[5])));
        }
        fileinput.close();

    }

    public static void feladat2(ArrayList<furdok> lista) {
        int min = 0;
        int minaz = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).furdoazonosito == 0 && lista.get(i).vendegazonosito < min) {
                min = lista.get(i).vendegazonosito;
                minaz = i;
            }
        }
        System.out.println("2. feladat");
        System.out.println("Az első vendég " + lista.get(minaz).ora + ":" + lista.get(minaz).perc + ":" + lista.get(minaz).masodprec + "-kor lépett ki az öltözőből.");

        int utolsoaz = 0;
        int utolso = 0;
        for (int i = 0; i < lista.size(); i++) {
            utolso = lista.get(i).vendegazonosito;
            utolsoaz = i;
        }
        while (utolso == lista.get(utolsoaz).vendegazonosito) {
            utolsoaz--;
        }
        System.out.println("Az utolsó vendég " + lista.get(utolsoaz + 1).ora + ":" + lista.get(utolsoaz + 1).perc + ":" + lista.get(utolsoaz + 1).masodprec + "-kor lépett ki az öltözőből.");

    }

    public static void feladat3(ArrayList<furdok> lista) {
   
        
        
        
    }

}
